from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from data_processing import load_data, preprocess_data
import joblib
import pandas as pd

if __name__ == "__main__":
    # Load the data
    df = load_data("data.csv")

    # Split the data into training and testing sets
    train_df, test_df = train_test_split(df, test_size=0.2, random_state=42)

    # Save the test data
    test_df.to_csv("data/test_data.csv", index=False)

    # Preprocess the training data
    train_df_processed = preprocess_data(train_df)

    # Separate features and target
    X_train = train_df_processed.drop("ProductID", axis=1)
    y_train = train_df_processed["ProductID"]

    # Create and train the model
    model = LogisticRegression()
    model.fit(X_train, y_train)

    # Save the model and training columns
    joblib.dump(model, "models/model.joblib")
    joblib.dump(list(X_train.columns), "models/train_cols.joblib")
