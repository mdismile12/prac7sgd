import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

# Step 1: Load drive-data.csv dataset
df = pd.read_csv('drive-data.csv')

# Step 2: Extract features
X = df[['mean_dist_day', 'mean_over_speed_perc']]

# Step 3: Apply K-Means Clustering (K=4)
kmeans = KMeans(n_clusters=4, random_state=42, n_init=10)
df['cluster'] = kmeans.fit_predict(X)

# Step 4: Display Cluster Centers and Output Summary
print("K-Means Clustering Results (drive-data.csv):")
print("Cluster Centers (Centroids):\n", kmeans.cluster_centers_)
print("\nInertia (Sum of squared distances):", kmeans.inertia_)
print("\nFirst 10 rows with assigned clusters:\n", df.head(10))

# Step 5: Visualize Clusters
plt.figure(figsize=(8, 6))
plt.scatter(X['mean_dist_day'], X['mean_over_speed_perc'], c=df['cluster'], cmap='rainbow', alpha=0.7, edgecolors='k')
plt.scatter(kmeans.cluster_centers_[:, 0], kmeans.cluster_centers_[:, 1], color='black', marker='X', s=200, label='Centroids')

plt.title('K-Means Clustering of Driver Data (K=4)')
plt.xlabel('Mean Distance Driven Per Day')
plt.ylabel('Mean Over Speeding Percentage')
plt.legend()
plt.grid(True)
plt.savefig('kmeans_clusters.png', dpi=300)
plt.show()
