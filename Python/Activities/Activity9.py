list1 = [1,2,45,77,88]
list2 = [90,3,5,6]
list3 = []
for i in list1:
    if i % 2 != 0:
        list3.append(i)
for j in list2:
    if j % 2 == 0:
        list3.append(j)

print(list3)