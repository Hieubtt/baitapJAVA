from sklearn.metrics import accuracy_score
from data_processing import load_data, preprocess_data
import joblib
import pandas as pd

if __name__ == "__main__":
    # Load the test data
    test_df = load_data("data.csv")

    # Preprocess the data
    test_df_processed = preprocess_data(test_df)

    # Load the training columns
    train_cols = joblib.load("models/train_cols.joblib")

    # Separate features and target
    y_test = test_df_processed["ProductID"]
    X_test = test_df_processed.drop("ProductID", axis=1)

    # Align the columns of the test data with the training data
    X_test = X_test.reindex(columns=train_cols, fill_value=0)

    # Load the model
    model = joblib.load("models/model.joblib")

    # Make predictions
    predictions = model.predict(X_test)

    # Evaluate the model
    accuracy = accuracy_score(y_test, predictions)
    print(f"Model accuracy: {accuracy}")
