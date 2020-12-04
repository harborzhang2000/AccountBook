# My Personal Project --AccountBook

## A. Introduction

Q&A:
- ##### What will the application do?  
*This application named AccountBook aims at helping users manage their account in their daily life.* 
- *The app allows users to add money (positive or negative amount)to the account book.*
- *The app will save and record every account in detail.*
- *The app allows users to delete the account they are selected.*
- *The app will provide users an overall balance of their account.*
- *The app will give users an overall view of their accounts.*


- ##### Who will use it?
*The indented uses are all people who want to well manage their money 
in their daily life. They can be children who want to save their pocket money
in order to buy their favorite toys. They can be housewives who want to record
their money on everyday shopping. They also can be students like us who want to
manage our school fee and everyday cost. It is designed to be a common app which
is easy and convenient to use by anyone.*



- ##### Why is this project of interest to you?
*I am currently a student at UBC and I realize that many peers around
 me have these needs to well manage their money. Some of us live on parents'
 support, some of us need to apply for educational loans, and some of us need to 
 get a part-time job to pay their school fees. Overall, we are young adults who just
 enter the real society and we just begin to accumulate our fortune. Therefore, I believe
 it is very essential to design an app like an account book to help us control our wallets.*

## B. User Stories
- As a user, I want to be able to add an account to my account book
- As a user, I want to be able to delete an account from my account book
- As a user, I want to be able to view an account on my account book
- As a user, I want to be able to calculate the overall balance of my account book
- As a user, I want to be able to save accounts to file
- As a user, I want to be able to load my accounts from file
## C. Phase 4: Task 2
- I choose the second option which is "including a type hierarchy in my code", and it is
in the ui package.
The super type is an interface in Java library named ActionListener. 
It is a useful interface that I learnt from ORACLE website. When an action is performed by the users,
it will send the messages to all its subclasses and make the action. 
It has four subclasses, respectively, AccountBook, AddAccount, BalanceAccount and AccountView.
They all override the method named actionPerformed, except for the AccountView, which extends
all methods from the AccountBook class. Because different subclasses have different actions,
this method is overrided in different ways in each subclass, which satisfies the requirement of task 2.
## D. Phase 4: Task 3
- In the ui package, class AccountBook, class AddAccount and class BalanceAccount,
because I need to add Jframe, Jpanel, Jbutton, Jtable...to the constructor, there were 
a lot of lines of code in the constructor which looked really messy. Therefore, to make
my code more readable and more clear, I put the functions related to the same field together
and refactor them as a new method. In this way, the code looks easier to read for the readers,
and more importantly, it is also great for me to modify my code in the future.
- The class AddAccount and the class BalanceAccount both deal with two fields,
namely, Accountlist and AccountBook, which decrease the cohesion of each class.
For future construction, I think I can separate the classes so that each class 
only has one field to deal with. In this way, it can increase the cohesion of this project.
- The class AccountView also has a bunch of code in the constructor which are all used to 
set the visibility of the buttons. In this case, I can refactor these code into a new method
called setButtonVisbility() in the future construction, in order to make it easier to read.
 
