# Game Development Details

2110215 PROGRAMMING METHODOLOGY I Final Project (2024)

---

# Resources

| Title                        | Description                                                                                                |                                              Link                                               |
| :--------------------------- | :--------------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------: |
| **Game Overview**            | The main markdown file.                                                                                    |                   [README.md](https://github.com/reisenx/PROG-METH-I-PROJECT)                   |
| **Game Development Details** | It contains information about game development.                                                            |   [DEV.md](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/Project%20Details/DEV.md)   |
| **Project Setup**            | A tutorial on how to setup a Java project on Eclipse, and how to use GitHub to collaborate with the teams. | [SETUP.md](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/Project%20Details/SETUP.md) |
| **Project Documentation**    | All class and methods implementation in details.                                                           |  [DOCS.md](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/Project%20Details/DOCS.md)  |

---

# Project Overview

This project is developed by pure Java, written in Eclipse IDE and utilized JavaFX for Graphical User Interface (GUI).

For project design, there are 4 packages and each package focuses on different roles in the project.

## Package `application`

This package focuses only on launching an application.

| Class                                                                                                         | Description                                                             |
| :------------------------------------------------------------------------------------------------------------ | :---------------------------------------------------------------------- |
| [`Main.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/application/Main.java) | This is the main class of a program, focus on launching an application. |

## Package `cell`

This package contains classes of each type of cell. Focuses on initializing each cell properties and setup its behavior.

| Class                                                                                                                | Description                                                                                              |
| :------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------- |
| [`Cell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/Cell.java)               | This is the parent class of all type of cell, it contains essential properties and features of them.     |
| [`SpecialCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/SpecialCell.java) | This is Java interface containing all necessary methods for mystery cell, shield cell, and defuser cell. |
| [`NormalCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)   | This is a class for normal cell, extended from `Cell.java`.                                              |
| [`BombCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)     | This is a class for bomb cell, extended from `Cell.java`.                                                |
| [`MysteryCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)  | This is a class for mystery cell, extended from `Cell.java` and implemented from `SpecialCell.java`.     |
| [`ShieldCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)   | This is a class for mystery cell, extended from `Cell.java` and implemented from `SpecialCell.java`.     |
| [`DefuserCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)  | This is a class for defuser cell, extended from `Cell.java` and implemented from `SpecialCell.java`.     |

## Package `control`

This package is the core of the game. It mainly focuses on both game logic and graphical interface management and configuration.

| Class                                                                                                                         | Description                                                                                                                                                                                                   |
| :---------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [`GameController.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameController.java) | This class focuses on controlling the game logic, making the game runs properly.                                                                                                                              |
| [`GameUtil.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameUtil.java)             | This class contains all game utility methods which are mostly randomization methods used for constructing a board in each game.                                                                               |
| [`GameConfig.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameConfig.java)         | This class contains all game configuration, such as grid size, cell size, amount of cell in each type. All configuration are centralized here, makes it easy to change game configuration.                    |
| [`GUIController.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GUIController.java)   | This class focuses managing GUI. It manages page transition, game music, and some GUI utility method.                                                                                                         |
| [`GUIConfig.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GUIConfig)                | This class contains all GUI configuration, such as application window size, and filename of all GUI components in a game. All configuration are centralized here, makes it easy to change game configuration. |

## Package `pane`

This package contains all of the GUI component of every page in a game.

| Class                                                                                                                    | Description                                                                                                                                                                                                  |
| :----------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [`HomePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/HomePane.java)           | This class construct home screen and its GUI components.                                                                                                                                                     |
| [`HowToPlayPane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/HowToPlayPane.java) | This class construct game tutorial screen and its GUI components.                                                                                                                                            |
| [`StagePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/StagePane.java)         | This class construct stage selection screen and its GUI components.                                                                                                                                          |
| [`GamePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/GamePane.java)           | This class construct game board utilizing randomization method from `GameUtil.java`, creating its GUI components, and working with `GameController.java` to make the game working properly.                  |
| [`ControlPane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/ControlPane.java)     | This class construct game control screen showing at the right side of `GamePane.java`, creating its GUI components, and working with `GameController.java` to properly update game status on user interface. |

---
