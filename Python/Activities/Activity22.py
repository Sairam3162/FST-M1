import pytest
import math

def test_sum_of_two_nums():
    a = 5
    b = 10
    assert a+b == 15

def test_diff_of_two_nums():
    a = 5
    b = 10
    assert b-a == 5

@pytest.mark.activity
def test_prod_of_two_nums():
    a = 5
    b = 10
    assert a*b == 50

@pytest.mark.activity
def test_quo_of_two_nums():
    a = 5
    b = 10
    assert b/a == 2