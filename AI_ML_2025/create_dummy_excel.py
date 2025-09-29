import pandas as pd

# Create a dummy dataframe
df = pd.DataFrame({
    'feature1': [1, 2, 3, 4],
    'feature2': [5, 6, 7, 8],
    'feature3': [9, 10, 11, 12],
    'feature4': [13, 14, 15, 16],
    'target': [0, 1, 0, 1]
})

# Save it to an excel file
df.to_excel("data/dummy_data.xlsx", index=False)

print("Dummy Excel file created successfully!")
