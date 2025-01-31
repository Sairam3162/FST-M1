import pytest


def test_sum(list_value):
    sum = 0
    for i in list_value:
        sum+=i
    print("sum of that list is : ",sum)
    assert sum == 55
