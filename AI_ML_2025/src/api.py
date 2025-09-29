from fastapi import FastAPI
import joblib
from pydantic import BaseModel
from typing import List
import logging
from config import MODEL_PATH

# Configure logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

app = FastAPI()

# Define the input and output data models
class PredictionInput(BaseModel):
    features: List[float]

class PredictionOutput(BaseModel):
    prediction: int
    probability: float

# Load the model
model = joblib.load(MODEL_PATH)

@app.post("/predict", response_model=PredictionOutput)
def predict(data: PredictionInput):
    """
    Makes a prediction using the trained model.

    Args:
        data (PredictionInput): The input data for the prediction.

    Returns:
        PredictionOutput: The prediction and its probability.
    """
    logger.info(f"Received prediction request with data: {data}")
    # The input data is now validated by Pydantic.
    # We can access the features as a list.
    features = [data.features]
    prediction = model.predict(features)[0]
    probability = model.predict_proba(features)[0].max()
    logger.info(f"Prediction: {prediction}, Probability: {probability}")
    return PredictionOutput(prediction=prediction, probability=probability)
