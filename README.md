# MINDsweeper

**2110215 PROGRAMMING METHODOLOGY I Final Project (2024)**

---

## Introduction

MINDsweeper takes inspiration on the classic Minesweeper game, but it has extra twists and a more visual interface.

This is 2D indie game implemented by using concept of Object Oriented Programming (OOP) in Java and utilizing JavaFX for Graphical User Interface (GUI).

This final project was developed for Chulalongkorn University's 2110215 PROGRAMMING METHODOLOGY I course by

- Worralop Srichainont ([@reisenx](https://github.com/reisenx))
- Sasarose Buranapin ([@ssrose-b](https://github.com/ssrose-b))

### Game Development Details, [COMING SOON]()

[INSERT HOME IMAGE HERE]

---

## Game Overview

### MINDsweeper Objective

MINDsweeper is a game where bombs are hidden in a board of cells. The objective of this game is to opening all of the safe cells. If the player clicks on a bomb without a shield, the player loses a game.

[INSERT WIN/LOSES IMAGES HERE]

### How to play?

When the player opens a game, the shows up.

1. **Start Game** navigates to stage 1 of a game.
2. **Select Stage** navigates to stage selection page, there are 9 stages in this game.
3. **How to Play** navigates to tutorial game tutorial page.
4. **Exit** simply close the game.

[INSERT HOME PAGE HERE]

Each stage in a game would have the interface like this.

- **Cells** are small squares on a board.
- Click **Start Game** to starts a game.
- Click **Restart** to create a new board. This can be clicked after the game ends and during unsatisfied game.
- **Left click** on a cell, to open it.
- **Right click** on a cell, to flag a cell that suspicious to be a bomb. After clicking, a red flag appears on a cell.
- Each cell in a board has different effect when the player click on it.

[INSERT IMAGE HERE]

### Normal Cell

**Normal cell** is a cell that has a number indicates amount of adjacent bombs and special cells to itself. this type of cell has two variants.

- **White Normal cell:** a number only indicates amount of adjacent bombs. (Has no special cells adjacent to this cell.)
- **Yellow Normal cell:** a number indicates amount of adjacent bombs and special cells. (Has special cells adjacent to this cell.)

[INSERT IMAGE HERE]

### Bomb Cell

**Bomb cell** is dangerous. If the player clicks on this cell without a shield, they immediately loses a game.

[INSERT IMAGE HERE]

### Shield Cell

**Shield cell** is a special cell that gives the player a shield which can protect player from a bomb explosion once.

[INSERT IMAGE HERE]

### Defuser Cell

**Defuser cell** is a special cell that automatically flags 3 bombs randomly.

[INSERT IMAGE HERE]

### Mystery Cell

**Mystery cell** is a special cell, but it cannot do anything other than showing `?` to a player. It is more like degraded version of normal cell.

[INSERT IMAGE HERE]

---

## Stage Overview

| Stage | Board Size | Bombs | Mystery | Shield | Defuser |
| :---: | :--------: | :---: | :-----: | :----: | :-----: |
|   1   |   9 × 9    |  10   |    0    |   1    |    1    |
|   2   |   9 × 9    |  10   |    7    |   1    |    0    |
|   3   |   9 × 9    |  10   |    8    |   0    |    0    |
|   4   |  16 × 16   |  40   |    0    |   2    |    2    |
|   5   |  16 × 16   |  40   |   12    |   2    |    0    |
|   6   |  16 × 16   |  40   |   14    |   0    |    0    |
|   7   |  25 × 25   |  120  |    0    |   3    |    3    |
|   8   |  25 × 25   |  120  |   20    |   3    |    0    |
|   9   |  25 × 25   |  120  |   23    |   0    |    0    |

[INSERT IMAGE HERE]
