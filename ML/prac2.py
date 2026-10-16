import pandas as pd
import numpy as np
# Create sample dataset with missing values
data = {
    'First Score': [100, 90, np.nan, 95],
    'Second Score': [30, 45, 56, np.nan],
    'Third Score': [np.nan, 40, 80, 98]
}
df = pd.DataFrame(data)

print("Original Data:")
print(df)

# 1. isnull() - check missing values
print("\nMissing values:")
print(df.isnull())

# 2. notnull() - check non-missing values
print("\nNon-missing values:")
print(df.notnull())

# 3. dropna() - remove rows containing missing values
print("\nAfter dropna():")
print(df.dropna())

# 4. fillna() - fill missing values with 0
print("\nAfter fillna(0):")
print(df.fillna(0))

# 5. replace() - replace a specific value
print("\nAfter replace():")
print(df.replace(100, 99))

# 6. interpolate() - estimate missing values
print("\nAfter interpolate():")
print(df.interpolate())