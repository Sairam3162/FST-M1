import pandas

dataframe = pandas.read_csv('C:/Users/SairamDeepala/FST-M1/Python/Activity17.csv')
print(dataframe)
	
print("===============")
print("Usernames:")
print(dataframe["Usernames"])
print("===============")
print(dataframe["Usernames"][1],dataframe["Passwords"][1])
print("====================================")
print("Data sorted in ascending Usernames:")
x = dataframe.sort_values('Usernames')
print(x)

print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))