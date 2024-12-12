# MINDsweeper

**2110215 PROGRAMMING METHODOLOGY I Final Project (2024)**

---

# Introduction

MINDsweeper takes inspiration on the classic Minesweeper game, but it has extra twists and a more visual interface.

This is 2D indie game implemented by using concept of Object Oriented Programming (OOP) in Java and utilizing JavaFX for Graphical User Interface (GUI).

This final project was developed for Chulalongkorn University's 2110215 PROGRAMMING METHODOLOGY I course by

- Worralop Srichainont ([@reisenx](https://github.com/reisenx))
- Sasarose Buranapin ([@ssrose-b](https://github.com/ssrose-b))

<div align="center">

## Game Development Details, [COMING SOON]()

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Home.png" height=80% width=80%>

</div>

---

# Game Overview

## MINDsweeper Objective

MINDsweeper is a game where bombs are hidden in a board of cells. The objective of this game is to opening all of the safe cells. If the player clicks on a bomb without a shield, the player loses a game.

<div align="center">
    <p>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Win.png" height=45% width=45%>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Lose.png" height=45% width=45%>
    </p>
</div>

## How to play?

When the player opens a game, the shows up.

1. **Start Game** navigates to stage 1 of a game.
2. **Select Stage** navigates to stage selection page, there are 9 stages in this game.
3. **How to Play** navigates to tutorial game tutorial page.
4. **Exit** simply close the game.

<div align="center">
    <p>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Home.png" height=45% width=45%>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Stage.png" height=45% width=45%>
    </p>
</div>

Each stage in a game would have the interface like this.

- **Cells** are small squares on a board.
- Click **Start Game** to starts a game.
- Click **Restart** to create a new board. This can be clicked after the game ends and during unsatisfied game.
- **Left click** on a cell, to open it.
- **Right click** on a cell, to flag a cell that suspicious to be a bomb. After clicking, a red flag appears on a cell.
- Each cell in a board has different effect when the player click on it.

<div align="center">
    <p>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/LeftClick.png" height=45% width=45%>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/RightClick.png" height=45% width=45%>
    </p>
</div>

## Normal Cell

**Normal cell** is a cell that has a number indicates amount of adjacent bombs and special cells to itself. this type of cell has two variants.

- **White Normal cell:** a number only indicates amount of adjacent bombs. (Has no special cells adjacent to this cell.)
- **Yellow Normal cell:** a number indicates amount of adjacent bombs and special cells. (Has special cells adjacent to this cell.)

<div align="center">
    <p>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/WhiteNormal.png" height=30% width=30%>
        <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/YellowNormal.png" height=30% width=30%>
    </p>
</div>

## Bomb Cell

**Bomb cell** is dangerous. If the player clicks on this cell without a shield, they immediately loses a game.

<div align="center">
    <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Lose.png" height=60% width=60%>
</div>

## Shield Cell

**Shield cell** is a special cell that gives the player a shield which can protect player from a bomb explosion once.

<div align="center">
    <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Shield.png" height=60% width=60%>
</div>

## Defuser Cell

**Defuser cell** is a special cell that automatically flags 3 bombs randomly.

<div align="center">
    <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Defuser.png" height=60% width=60%>
</div>

## Mystery Cell

**Mystery cell** is a special cell, but it cannot do anything other than showing `?` to a player. It is more like degraded version of normal cell.

<div align="center">
    <img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/UI/Mystery.png" height=30% width=30%>
</div>

---

# Stage Overview

Each stage of a game has different cell amount configuration as table below.

Every time a player restart a game, the cells arrangement are random but the amount of cells are still the same.

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
