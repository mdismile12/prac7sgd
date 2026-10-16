import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.datasets import load_diabetes
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score

# Step 1: Load dataset
diabetes = load_diabetes()
X = diabetes.data[:, np.newaxis, 2] # Use 1 feature (BMI) for simple linear regression plot
y = diabetes.target

# Step 2: Split data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 3: Train Linear Regression Model
model = LinearRegression()
model.fit(X_train, y_train)

# Step 4: Make Predictions
y_pred = model.predict(X_test)

# Step 5: Model Evaluation
print("Linear Regression Results:")
print("Coefficient (Slope):", model.coef_[0])
print("Intercept:", model.intercept_)
print("Mean Absolute Error (MAE):", mean_absolute_error(y_test, y_pred))
print("Mean Squared Error (MSE):", mean_squared_error(y_test, y_pred))
print("Root Mean Squared Error (RMSE):", np.sqrt(mean_squared_error(y_test, y_pred)))
print("R2 Score:", r2_score(y_test, y_pred))

# Step 6: Plot Regression Line
plt.figure(figsize=(8, 5))
plt.scatter(X_test, y_test, color='blue', label='Actual Data')
plt.plot(X_test, y_pred, color='red', linewidth=2, label='Regression Line')
plt.title('Linear Regression: BMI vs Disease Progression')
plt.xlabel('BMI (Standardized)')
plt.ylabel('Disease Progression')
plt.legend()
plt.grid(True)
plt.savefig('linear_regression.png', dpi=300)
plt.show()