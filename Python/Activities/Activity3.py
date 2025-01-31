user1 = input("what is player 1's name? ")
user2 = input("what is player 2's name? ")

user1_input = input(user1+ " do you choose rock, paper or scissors ?").lower()
user2_input = input(user2+ " do you choose rock, paper or scissors ?").lower()

if(user1_input == user2_input):
    print("It is a tie")
elif user1_input == 'rock':
    if user2_input == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif user1_input == 'scissors':
    if user2_input == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif user1_input == 'paper':
    if user2_input == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")