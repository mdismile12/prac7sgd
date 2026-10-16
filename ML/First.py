import pandas as pd
d = pd.read_excel("sheet1.xlsx")
df = pd.DataFrame(d)
print(df)
df.to_excel("excel.xlsx",index=False) #df to excel
df.to_csv("commasepv.csv",index=False) #df to csv
df.to_csv("textfile.txt",index=False) #df to txt