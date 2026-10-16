import pandas as pd
d = pd.read_excel("sheet1.xlsx")
df = pd.DataFrame(d)
# print(df.head(3))
# print(df.tail(2))
print(df.info)
