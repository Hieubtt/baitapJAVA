import pandas as pd
import os

def load_data(file_path):
    """
    Loads data from a CSV or Excel file.

    Args:
        file_path (str): The path to the file.

    Returns:
        pandas.DataFrame: The loaded data.
    """
    _, file_extension = os.path.splitext(file_path)
    if file_extension == '.csv':
        return pd.read_csv(file_path)
    elif file_extension in ['.xlsx', '.xls']:
        return pd.read_excel(file_path)
    else:
        raise ValueError(f"Unsupported file format: {file_extension}")

def preprocess_data(df):
    """
    Performs one-hot encoding on categorical features.

    Args:
        df (pandas.DataFrame): The input dataframe.

    Returns:
        pandas.DataFrame: The preprocessed dataframe.
    """
    categorical_cols = df.select_dtypes(include=['object', 'category']).columns
    df_processed = pd.get_dummies(df, columns=categorical_cols, dummy_na=False)
    return df_processed
