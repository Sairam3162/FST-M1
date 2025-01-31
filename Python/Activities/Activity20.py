import pandas

dataframe = pandas.read_excel("C:/Users/SairamDeepala/FST-M1/Python/Activity19.xlsx")
print(dataframe)
print("Number of rows & columns : ", dataframe.shape)
print("Emails:",dataframe["Email"])
print(dataframe.sort_values("FirstName"))