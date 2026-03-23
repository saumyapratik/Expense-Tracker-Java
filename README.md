# Expense Tracker – Java Console App

## What is this?
A simple Java project I made to keep track of my daily expenses. Nothing fancy, just a console app that lets me add, view, and delete expenses and see where my money is going.

## Why I made this
Honestly, I had no idea where my pocket money was disappearing every month. Food, transport, random stuff — it adds up. So I thought why not build something to track it instead of using a notes app.

## What it can do
- Add an expense with amount, category, and date
- View all recorded expenses
- Check total spending
- See spending broken down by category
- Delete an expense if entered wrong

## Project Structure
```
ExpenseTracker/
├── Expense.java
├── ExpenseManager.java
├── Main.java
└── expenses.txt
```

## How to Run
```
javac *.java
java Main
```

## What I used
- Core Java and OOP — classes, objects, encapsulation
- File Handling — BufferedReader and FileWriter
- Collections — ArrayList and HashMap

## What I learned
This was my first time properly using file handling in Java. Getting data to save and reload correctly took more time than I expected. HashMap made category-wise reports much easier than I thought.

## Known issues / TODO
- Delete feature works but needs cleanup
- Want to add monthly filtering next
- Maybe a GUI version using Java Swing later

## About
Saumya Pratik — B.Tech CSE (AIML)

## Conclusion 
This project helped me understand how Java can be used to solve real-world problems. It also improved my understanding of OOP, file handling, and working with collections.
