tuple1 = tuple((input("please enter the numbers for a tuple : ").split(",")))
print(tuple1)
for i in tuple1:
    if(int(i) % 5 == 0 ):
        print(i)