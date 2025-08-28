text
# Polynomial Secret Solver

This project reads polynomial root data from a JSON file where the y-values are encoded in various numerical bases. It decodes these values, uses quadratic or higher-degree Lagrange interpolation to reconstruct the polynomial, and solves for the constant term \( c \) in the polynomial equation.

---

## Features

- Reads polynomial roots with encoded y-values from a JSON file.
- Decodes y-values based on their base.
- Supports very large numbers using Java's `BigInteger`.
- Uses Lagrange interpolation to find the constant term \( c \) (polynomial value at \( x=0 \)).
- Easily extendable for polynomials of various degrees.

---

## Prerequisites

- Java JDK 8 or later installed and configured.
- [org.json library jar](https://repo1.maven.org/maven2/org/json/json/20220320/json-20220320.jar) (`json-20220320.jar`).
- Command-line terminal or IDE (e.g., VS Code).
- Your input JSON file (named `input.json`) placed in the project directory.

---

## Project Structure

PolynomialSecretSolver/
│
├── PolynomialSecretSolver.java # Main Java source code
├── input.json # Input JSON file with test data
├── json-20220320.jar # JSON parsing library
└── README.md # This readme file

text

---

## Sample Input (`input.json`)

{
"keys": {
"n": 4,
"k": 3
},
"1": {
"base": "10",
"value": "4"
},
"2": {
"base": "2",
"value": "111"
},
"3": {
"base": "10",
"value": "12"
},
"6": {
"base": "4",
"value": "213"
}
}

text

---

## How to Run

1. **Compile the code:**

javac -cp json-20220320.jar PolynomialSecretSolver.java

text

2. **Run the program:**

On Windows PowerShell:

java -cp ".;json-20220320.jar" PolynomialSecretSolver

text

On Mac/Linux terminal:

java -cp ".:json-20220320.jar" PolynomialSecretSolver

text

---

## Expected Output

The program reads the JSON, decodes the encoded y-values, performs interpolation, and prints the value of the constant term \( c \), for example:

The value of c (constant term) is: 5

text

---

## How It Works (Summary)

- **Decoding y-values:** Converts encoded strings from given numerical bases (base 2, 4, 10, etc.) to Java's BigInteger.
- **Interpolation:** Uses Lagrange interpolation formula to find polynomial coefficients given roots.
- **Secret \( c \):** Computed as the polynomial evaluated at \( x=0 \), representing the constant term.

---

## Graphical Overview

graph LR
A[Input JSON] --> B[Decode y-values with Bases]
B --> C[Lagrange Interpolation]
C --> D[Polynomial Reconstruction]
D --> E[Calculate constant c (x=0)]
E --> F[Print result]

text

---

## Troubleshooting

- Make sure your `input.json` and `json-20220320.jar` files are in the project folder.
- Use correct classpath syntax (`.;` on Windows, `.:` on Unix).
- For very large numbers, `BigInteger` ensures no integer overflow.
- If running fails, confirm Java and JAR paths are correct.

---

## License

This project is licensed under the MIT License.

---

## Contact

For issues or improvements, please open an issue or pull request on GitHub.

---

*Happy coding!*
