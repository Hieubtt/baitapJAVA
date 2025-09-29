from fastapi.testclient import TestClient
from src.api import app

client = TestClient(app)

def test_predict():
    """
    Tests the /predict endpoint.
    """
    # Define the input data
    input_data = {"features": [1, 2, 3, 4]} # Assuming the model expects 4 features

    # Send a request to the API
    response = client.post("/predict", json=input_data)

    # Check the response
    assert response.status_code == 200
    response_data = response.json()
    assert "prediction" in response_data
    assert "probability" in response_data
    assert isinstance(response_data["prediction"], int)
    assert isinstance(response_data["probability"], float)
