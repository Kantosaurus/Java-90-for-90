# Project Name: Number Guessing Game

## Description
Today's project is a simple yet engaging number guessing game. The goal of the game is for the user to guess a randomly generated number within a specified range, depending on the chosen difficulty level:
- **Difficulty 1**: Number between 1 and 10, with 3 tries.
- **Difficulty 2**: Number between 1 and 100, with 7 tries.
- **Difficulty 3**: Number between 1 and 1000, with 10 tries.

The computer generates the random number and provides feedback after each guess:
- If the guess is too high, the program informs the user that the number is smaller.
- If the guess is too low, the program informs the user that the number is larger.
- If the user guesses correctly, the program congratulates them and displays the number of tries it took.

Once the user exhausts their allowed number of tries, the program reveals the correct number and asks if the user would like to play again.

## Java Concepts Covered
- **Random Number Generation**: Using `ThreadLocalRandom` to generate random numbers within a specified range.
- **Input Validation**: Ensuring the user inputs valid integers for difficulty selection and guesses.
- **Control Flow**: Utilizing loops (`while`, `switch`) and conditional statements (`if-else`) to manage game logic.
- **Exception Handling**: Managing invalid inputs gracefully without crashing the program.
- **Reusability**: Implementing helper methods (`randomNumberGenerator`, `guess`) to avoid code duplication and improve readability.

## Setup Instructions
1. Ensure you have Java installed on your system. You can verify this by running:
   ```bash
   java -version
If not installed, download and install the latest version of Java from Oracle  or OpenJDK .
2. Save the .java file (e.g., NGG.java) in a directory.
3. Open a terminal or command prompt, navigate to the directory containing the .java file, and compile the program:
    javac NGG.java
4. Run the compiled program using:
    java NGG

## Interesting Details
    Dynamic Difficulty Levels : The game adapts to the user's choice of difficulty, offering progressively challenging ranges and limited attempts.
    Play Again Feature : After completing a game, the user is prompted to play again, allowing for continuous gameplay without restarting the program manually.
    User-Friendly Feedback : The program provides clear and concise feedback after each guess, guiding the user toward the correct answer.
    Error Handling : Invalid inputs (e.g., non-integer values or out-of-range difficulty levels) are handled gracefully, ensuring a smooth user experience.


## Example Output
Hello! What is your name? 
John
Hello John!
Please choose the difficulty of the game (1-4): 
1
John has chosen difficulty 1!
You have 3 tries to guess a number between 1 and 10 inclusive.
Goodluck John!
John, what is guess number 1?
5
The number you guessed is too small!
John, what is guess number 2?
8
You Win! John only took 2 number of tries!
Would you like to play again? (yes/no): 
no
Thank you for playing! Goodbye!

## Notes
    Potential Improvements :
        Add a leaderboard to track the user's best scores (e.g., fewest tries).
        Include additional difficulty levels with larger ranges or fewer tries.
        Allow the user to customize the range and number of tries for a personalized experience.
         
    Known Issues :
        If the user enters an invalid response to the "play again" prompt (e.g., anything other than "yes" or "no"), the program assumes "no" and exits. This behavior could be improved with additional validation.