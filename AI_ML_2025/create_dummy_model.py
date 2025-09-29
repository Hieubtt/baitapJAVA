from sklearn.linear_model import LogisticRegression
import joblib
import numpy as np

# Create a dummy model
model = LogisticRegression()
# Train the model on some dummy data
model.fit(np.array([[1, 2], [3, 4]]), np.array([0, 1]))

# Save the model
joblib.dump(model, "models/model.joblib")

print("Dummy model created successfully!")
