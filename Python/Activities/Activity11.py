dict1 = {
    "mango": 20,
    "apple": 45,
    "banana": 15
}

fruit_check = input("please enter the fruit to check : ")
if(fruit_check in dict1):
    print(fruit_check,"fruit is available")
else:
    print(fruit_check,"fruit is not available")