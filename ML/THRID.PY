import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.datasets import load_breast_cancer
from sklearn.preprocessing import StandardScaler
from sklearn.decomposition import PCA
# Step 1: Load the Dataset
# Breast Cancer dataset has 30 features, which makes it ideal for dimensionality reduction
cancer = load_breast_cancer()
df = pd.DataFrame(cancer.data, columns=cancer.feature_names)
print("--- Step 1: Original Dataset ---")
print("Original Dataset Shape:", df.shape)
print("\nFirst 5 rows of original data:")
print(df.head())

# Step 2: Feature Scaling / Standardization
# PCA is sensitive to data scale, so features must be standardized (Mean=0, Variance=1)
scaler = StandardScaler()
scaled_data = scaler.fit_transform(df)

# Step 3: Apply PCA to reduce dimensions from 30 to 2
pca = PCA(n_components=2)
pca_data = pca.fit_transform(scaled_data)

# Convert transformed data into DataFrame
df_pca = pd.DataFrame(data=pca_data, columns=['First Principal Component (PC1)', 'Second Principal Component (PC2)'])

print("\n--- Step 2: Dimensionality Reduction using PCA ---")
print("Transformed Dataset Shape:", df_pca.shape)
print("\nFirst 5 rows of PCA Transformed Data:")
print(df_pca.head())

# Step 4: Explained Variance Ratio
# Indicates how much information (variance) is retained by the 2 principal components
explained_variance = pca.explained_variance_ratio_
print("\n--- Step 3: Variance Analysis ---")
print(f"Variance explained by PC1: {explained_variance[0]*100:.2f}%")
print(f"Variance explained by PC2: {explained_variance[1]*100:.2f}%")
print(f"Total Variance Explained by 2 Components: {np.sum(explained_variance)*100:.2f}%")

# Step 5: Visualization of 2D PCA Projections
plt.figure(figsize=(10, 6))
scatter = plt.scatter(df_pca['First Principal Component (PC1)'], 
                      df_pca['Second Principal Component (PC2)'], 
                      c=cancer.target, 
                      cmap='plasma', 
                      edgecolors='k', 
                      alpha=0.8)

plt.title('PCA: 2D Projection of Breast Cancer Dataset', fontsize=14, fontweight='bold')
plt.xlabel('First Principal Component (PC1)', fontsize=12)
plt.ylabel('Second Principal Component (PC2)', fontsize=12)
plt.colorbar(scatter, label='Target Class (0 = Malignant, 1 = Benign)')
plt.grid(True, linestyle='--', alpha=0.6)

# Save the plot image for reference/practical output
plt.savefig('pca_plot.png', dpi=300, bbox_inches='tight')
print("\nPlot saved successfully as 'pca_plot.png'. Displaying plot...")

plt.show()