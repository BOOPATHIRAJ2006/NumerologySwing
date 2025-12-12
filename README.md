```markdown
# Java Quiz & Numerology Apps

This repository contains two simple Java applications:
- **OnlineQuizApp.java**: A console-based quiz application that fetches questions from a MySQL database and evaluates user answers.[file:1]
- **NumerologySwing.java**: A GUI-based numerology calculator using Java Swing that computes a numerology number from a user’s name and shows a brief meaning.[file:2]

---

## Files

- `OnlineQuizApp.java`  
  Console application that connects to a MySQL database named `questions`, retrieves all questions, displays multiple-choice options (A–D), accepts user input, and maintains a running score.[file:1]

- `NumerologySwing.java`  
  Swing `JFrame` application with a text field for entering a name, a button to trigger calculation, and labels to show the computed numerology number and its associated meaning.[file:2]

---

## Prerequisites

- Java Development Kit (JDK) 8 or later installed and available on your PATH.[file:1][file:2]
- For `OnlineQuizApp.java`:
  - MySQL server running locally (or adjust URL).[file:1]
  - Database `questions` with a table `questions` having at least these columns:
    - `question` (TEXT/VARCHAR)
    - `optionA`, `optionB`, `optionC`, `optionD` (TEXT/VARCHAR)
    - `correctOption` (CHAR or VARCHAR, typically one of `A`, `B`, `C`, `D`).[file:1]
  - MySQL JDBC driver on the classpath when running.[file:1]

---

## Setup

### Database setup for OnlineQuizApp

1. Create the database and table (example structure):

```

CREATE DATABASE questions;
USE questions;

CREATE TABLE questions (
id INT AUTO_INCREMENT PRIMARY KEY,
question VARCHAR(255),
optionA VARCHAR(255),
optionB VARCHAR(255),
optionC VARCHAR(255),
optionD VARCHAR(255),
correctOption CHAR(1)
);

```

2. Insert sample questions with correct option letters matching one of `A`, `B`, `C`, or `D`.[file:1]

3. Update the following fields in `OnlineQuizApp.java` as per your setup:[file:1]

```

String url = "jdbc:mysql://localhost:3306/questions";
String user = "root";      // your MySQL username
String password = "";      // your MySQL password

```

---

## Running the Applications

### Compile

From the directory containing the `.java` files:

```

javac OnlineQuizApp.java
javac NumerologySwing.java

```

Ensure the MySQL JDBC driver JAR is on the classpath when compiling if required by your environment.[file:1]

### Run OnlineQuizApp

```

java -cp .:mysql-connector-j.jar OnlineQuizApp

```

- The program will:
  - Connect to the `questions` database.[file:1]
  - Loop through all rows in `questions` table.[file:1]
  - Display each question with options A–D.[file:1]
  - Prompt: `Your answer (A/B/C/D):` and accept input via `Scanner`.[file:1]
  - Compare the input (converted to uppercase) with `correctOption` and update `score`.[file:1]
  - Show whether the answer is correct or wrong for each question and finally display the total score.[file:1]

(Adjust classpath separator `:` to `;` on Windows.)

### Run NumerologySwing

```

java NumerologySwing

```

- The window will display:
  - A title “Numerology Number Finder”.[file:2]
  - A text field labeled “Enter Your Name:”.[file:2]
  - A “Calculate” button.[file:2]
  - Labels showing “Numerology Number:” and the corresponding meaning.[file:2]

Usage flow:[file:2]
- Enter a name (letters only recommended) and click **Calculate**.
- The app:
  - Converts the name to uppercase and trims spaces.[file:2]
  - Validates that the name is not empty; otherwise shows a message dialog.[file:2]
  - Computes the sum of alphabet positions using ASCII (`A = 1`, `B = 2`, …, `Z = 26`).[file:2]
  - Reduces the sum to a single digit or keeps master numbers 11, 22, 33 using `getNumerologyNumber` with a sum-of-digits helper.[file:2]
  - Displays the numeric result and its meaning (e.g., 1 = “PRIMAL FORCE”, 22 = “MASTER BUILDER”, etc.).[file:2]

---

## Notes

- These examples are educational and can be extended with better error handling, validation, and UI/UX improvements.[file:1][file:2]
- Respect intellectual property and copyright when distributing questions or numerology meaning texts; ensure any external content you use is appropriately licensed or original.  
```

<span style="display:none">[^1][^2]</span>

<div align="center">⁂</div>

[^1]: OnlineQuizApp.java

[^2]: NumerologySwing.java

