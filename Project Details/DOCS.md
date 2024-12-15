# Project Documentation

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

# Java Access Modifier

For simplicity of the documentation, we determine that.

|          Symbol           |    Meaning     |
| :-----------------------: | :------------: |
|           **+**           |     public     |
|           **#**           |   protected    |
|           **-**           |    private     |
| **<ins>underlined</ins>** |     static     |
|       **ALL_CAPS**        | final variable |
|         _italic_          |    abstract    |

---

# Project Implementation Details

This project is developed by pure Java, written in Eclipse IDE and utilized JavaFX for Graphical User Interface (GUI).

For project design, there are 4 packages and each package focuses on different roles in the project.

## Package `application`

This package focuses only on launching an application.

### [`Main.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/application/Main.java)

This is the main class of a program, focus on launching an application.

#### `Main.java` Fields

| Variables                            | Description                                                    |
| :----------------------------------- | :------------------------------------------------------------- |
| **<ins>- BorderPane RootPane</ins>** | The GUI elements of each pane are contained in this main pane. |

#### `Main.java` Methods

| Methods                                   | Description                                                |   More Details   |
| :---------------------------------------- | :--------------------------------------------------------- | :--------------: |
| **<ins>+ void main(String[] args)</ins>** | Launch an application using `launch(args)`.                |        -         |
| **+ void start(Stage primaryStage)**      | Setup the GUI components when the application is launched. | [More Details]() |
| **<ins>+ BorderPane getRootPane()</ins>** | Getter method of `RootPane`.                               |        -         |

---

## Package `cell`

This package contains classes of each type of cell. Focuses on initializing each cell properties and setup its behavior.

### [`Cell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/Cell.java)

This is the parent class of all type of cell, it contains essential properties and features of them.

#### `Cell.java` Fields

| Variables                 | Description                                      |
| :------------------------ | :----------------------------------------------- |
| **- int xPosition**       | Position of a cell in X-axis.                    |
| **- int yPosition**       | Position of a cell in Y-axis.                    |
| **- boolean isClicked**   | Represent that the cell has been clicked or not. |
| **- boolean isFlagged**   | Represent that the cell has been flagged or not. |
| **- String coverImgURL**  | URL of the cell's image before reveal.           |
| **- String revealImgURL** | URL of the cell's image before reveal.           |
| **- GamePane board**      | Refers to the board on which the cell belongs.   |

#### `Cell.java` Methods

| Methods                                               | Description                                                          |   More Details   |
| :---------------------------------------------------- | :------------------------------------------------------------------- | :--------------: |
| **+ Cell(int x, int y, double size, GamePane board)** | Constructor method.                                                  | [More Details]() |
| **_+ abstract void revealCell(boolean playSound)_**   | Reveals the cell. This method works depends on the cell type.        |        -         |
| **_# abstract void playSFX()_**                       | Play the sound effect of a cell. Each cell type has different sound. |        -         |
| **+ void enable()**                                   | Make the cell able to click.                                         |        -         |
| **+ void enable()**                                   | Make the cell unable to click.                                       |        -         |
| **# void updateCellImage(String URL)**                | Change the image that cell displays.                                 | [More Details]() |
| **+ void flagCell**                                   | Toggle a flag on a cell.                                             | [More Details]() |
| **+ String toString()**                               | Display a text for debugging in IDE console.                         |        -         |
| **+ int getxPosition()**                              | Getter method of `xPosition`.                                        |        -         |
| **+ void setxPosition(int xPosition)**                | Setter method of `xPosition`.                                        |        -         |
| **+ int getyPosition()**                              | Getter method of `yPosition`.                                        |        -         |
| **+ void setyPosition(int yPosition)**                | Setter method of `yPosition`.                                        |        -         |
| **+ String getCoverImgURL()**                         | Getter method of `coverImgURL`.                                      |        -         |
| **+ void setCoverImgURL(String coverImgURL)**         | Setter method of `coverImgURL`.                                      |        -         |
| **+ String getRevealImgURL()**                        | Getter method of `revealImgURL`.                                     |        -         |
| **+ void setRevealImgURL(String revealImgURL)**       | Setter method of `revealImgURL`.                                     |        -         |
| **+ boolean isClicked()**                             | Getter method of `isClicked`.                                        |        -         |
| **+ void setClicked(boolean isClicked)**              | Setter method of `isClicked`.                                        |        -         |
| **+ boolean isFlagged()**                             | Getter method of `isFlagged`.                                        |        -         |
| **+ void setFlagged(boolean isFlagged)**              | Setter method of `isFlagged`.                                        |        -         |
| **+ GamePane getBoard()**                             | Getter method of `board`.                                            |        -         |
| **+ void setBoard(GamePane board)**                   | Setter method of `board`.                                            |        -         |

### [`SpecialCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/SpecialCell.java)

This is Java interface containing all necessary methods for mystery cell, shield cell, and defuser cell.

#### `SpecialCell.java` Methods

| Methods               | Description                                        | More Details |
| :-------------------- | :------------------------------------------------- | :----------: |
| **+ void useSkill()** | Use special skill which depends on the cell's type |      -       |

### [`NormalCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)

This is a class for normal cell, extended from `Cell.java`

#### `NormalCell.java` Methods

| Methods                                                     | Description                                                               |   More Details   |
| :---------------------------------------------------------- | :------------------------------------------------------------------------ | :--------------: |
| **+ NormalCell(int x, int y, double size, GamePane board)** | Constructor Method of `NormalCell`. Just use the parent class constructor |        -         |
| **+ void revealCell(boolean playSound)**                    | Reveals all adjacent `NormalCell` and play its sound effect.              | [More Details]() |
| **+ void playSFX()**                                        | Play sound effect of `NormalCell` by using `GUIConfig.SFX[0]` as URL.     |        -         |
| **+ void toString()**                                       | Display a text for debugging in IDE console.                              |        -         |

### [`BombCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)

This is a class for bomb cell, extended from `Cell.java`.

#### `BombCell.java` Methods

| Methods                                                   | Description                                                                                                             |   More Details   |
| :-------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------- | :--------------: |
| **+ BombCell(int x, int y, double size, GamePane board)** | Constructor Method of `BombCell`. It use the parent class constructor and set `revealImgURL` to `GUIConfig.BOMB_IMAGE`. |        -         |
| **+ void revealCell(boolean playSound)**                  | Reveals `BombCell`, play its sound effect and end the game when player loses.                                           | [More Details]() |
| **+ void playSFX()**                                      | Play sound effect of `BombCell` by using `GUIConfig.SFX[1]` as URL.                                                     |        -         |
| **+ void toString()**                                     | Display a text for debugging in IDE console.                                                                            |        -         |

### [`MysteryCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)

This is a class for mystery cell, extended from `Cell.java` and implemented from `SpecialCell.java`.

#### `MysteryCell.java` Methods

| Methods                                                      | Description                                                                                                         |   More Details   |
| :----------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------ | :--------------: |
| **+ MysteryCell(int x, int y, double size, GamePane board)** | Constructor Method of `MysteryCell`. It use the parent class constructor and call `useSkill()` to replace an image. |        -         |
| **+ void revealCell(boolean playSound)**                     | Reveals `BombCell` and play its sound effect.                                                                       | [More Details]() |
| **+ void playSFX()**                                         | Play sound effect of `MysteryCell` by using `GUIConfig.SFX[2]` as URL.                                              |        -         |
| **+ void useSkill()**                                        | `MysteryCell` special skill. Just set `revealImgURL` to `GUIConfig.SPECIAL_IMAGE[0]`.                               |        -         |
| **+ void toString()**                                        | Display a text for debugging in IDE console.                                                                        |        -         |

### [`ShieldCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)

This is a class for mystery cell, extended from `Cell.java` and implemented from `SpecialCell.java`.

#### `ShieldCell.java` Methods

| Methods                                                     | Description                                                                                                                     |   More Details   |
| :---------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------ | :--------------: |
| **+ ShieldCell(int x, int y, double size, GamePane board)** | Constructor Method of `ShieldCell`. It use the parent class constructor and set `revealImgURL` to `GUIConfig.SPECIAL_IMAGE[1]`. |        -         |
| **+ void revealCell(boolean playSound)**                    | Reveals `ShieldCell`, play its sound effect and use its special skill by calling `useSkill()`.                                  | [More Details]() |
| **+ void playSFX()**                                        | Play sound effect of `ShieldCell` by using `GUIConfig.SFX[3]` as URL.                                                           |        -         |
| **+ void useSkill()**                                       | `ShieldCell` special skill. Increase the player's shield amount by 1.                                                           |        -         |
| **+ void toString()**                                       | Display a text for debugging in IDE console.                                                                                    |        -         |

### [`DefuserCell.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/cell/NormalCell.java)

This is a class for defuser cell, extended from `Cell.java` and implemented from `SpecialCell.java`.

#### `DefuserCell.java` Methods

| Methods                                                      | Description                                                                                                                      |   More Details   |
| :----------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------- | :--------------: |
| **+ DefuserCell(int x, int y, double size, GamePane board)** | Constructor Method of `DefuserCell`. It use the parent class constructor and set `revealImgURL` to `GUIConfig.SPECIAL_IMAGE[2]`. |        -         |
| **+ void revealCell(boolean playSound)**                     | Reveals `DefuserCell`, play its sound effect and use its special skill by calling `useSkill()`.                                  | [More Details]() |
| **+ void playSFX()**                                         | Play sound effect of `DefuserCell` by using `GUIConfig.SFX[4]` as URL.                                                           |        -         |
| **+ void useSkill()**                                        | `DefuserCell` special skill. It randomly flags 3 `BombCell` on a board.                                                          | [More Details]() |
| **+ void toString()**                                        | Display a text for debugging in IDE console.                                                                                     |        -         |

---

## Package `control`

This package is the core of the game. It mainly focuses on both game logic and graphical interface management and configuration.

### [`GameController.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameController.java)

This class focuses on controlling the game logic, making the game runs properly.

#### `GameController.java` Fields

| Variables                                | Description                                                                                                                                                                                 |
| :--------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **<ins>- GameController instance</ins>** | The `instance` that represents `GameController` class.                                                                                                                                      |
| **- GamePane gamePane**                  | `GamePane` of current `instance`.                                                                                                                                                           |
| **- ControlPane controlPane**            | `ControlPane` of current `instance`                                                                                                                                                         |
| **- boolean isGameStart**                | This represents that the game has started or not. Default value is `false`.                                                                                                                 |
| **- boolean isGameEnd**                  | This represents that the game has ended or not. Default value is `false`                                                                                                                    |
| **- int clickedCells**                   | Amount of cells that a player clicked. This cannot be negative number and default value is `0`                                                                                              |
| **- int flaggedCells**                   | Amount of flags remaining. This can be negative number to reminds player of using more flags that amount of `BombCell` in a board and default value is amount of all `BombCell` on a board. |
| **- int shieldAmount**                   | Amount of shield that player has. This cannot be negative number and default value is `0`                                                                                                   |

#### `GameController.java` Methods

| Methods                                            | Description                                                                                                                                                                                                                                  |   More Details   |
| :------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :--------------: |
| **- GameController()**                             | This constructor method does nothing, and set as private to ensure that this has been called once.                                                                                                                                           |        -         |
| **<ins>+ void getInstance()</ins>**                | Getter method of `instance`. Create a new instance, if the instance is `null`. This implementation ensure that only one `instance` exists.                                                                                                   |        -         |
| **<ins>- void playWinSFX()</ins>**                 | Plays sound effect when the player wins by using `GUIConfig.SFX[5]` as URL.                                                                                                                                                                  |        -         |
| **- void initializeValue()**                       | Resets `clickedCells`, `shieldAmount` to `0`, resets `shieldAmount` to amount of all `BombCell` on a board, and resets `flagText`, `cellText` and `shieldText` on `ControlPane`.                                                             |        -         |
| **+ void newGame()**                               | This method is called when a plyaer starts a new game.                                                                                                                                                                                       | [More Details]() |
| **+ void restartGame()**                           | This method is called when a player restarts a game.                                                                                                                                                                                         | [More Details]() |
| **+ void endGame()**                               | This method is called when the game ends.                                                                                                                                                                                                    | [More Details]() |
| **+ void updateFlagRemaining(int change)**         | Updates both `flagRemaining` variable and `flagText` on `ControlPane`. The value cannot greater than `MAX_FLAG` which is amount of all `BombCell` on a board.                                                                                |        -         |
| **+ void updateClickedCell(int count)**            | Updates both `cellClicked` variable and `cellText` on `controlPane`. The value cannot lower than `MIN_CLICK` which is `0`, and cannot greater than `MAX_CLICKED` which is amount of all `Cell` minus by amount of all `BombCell` on a board. |        -         |
| **+ void updateShieldAmount(int change)**          | Updates both `shieldAmount` variable and `shieldText` on `ControlPane`. The value cannot lower than `MIN_SHIELD` which is `0`, and cannot greater than `MAX_SHIELD` which is amount of all `ShieldCell` on a board.                          |        -         |
| **- revealBombs()**                                | Reveals all bombs without playing its sound effect on a board when a player loses. If the bomb is flagged, remove it before reveal.                                                                                                          |        -         |
| **- disableAllCells()**                            | Call `disable()` on every `Cell` on a board.                                                                                                                                                                                                 |        -         |
| **- enableAllCells()**                             | Call `enable()` on every `Cell` on a board                                                                                                                                                                                                   |        -         |
| **+ GamePane getGamePane()**                       | Getter method of `gamePane`                                                                                                                                                                                                                  |        -         |
| **+ void setGamePane(GamePane gamePane)**          | Setter method of `gamePane`                                                                                                                                                                                                                  |        -         |
| **+ ControlPane getControlPane()**                 | Getter method of `controlPane`                                                                                                                                                                                                               |        -         |
| **+ void setControlPane(ControlPane controlPane)** | Setter method of `controlPane`                                                                                                                                                                                                               |        -         |
| **+ int getClickedCells()**                        | Getter method of `clickedCells`                                                                                                                                                                                                              |        -         |
| **+ int getFlaggedRemaining()**                    | Getter method of `flagRemaining`                                                                                                                                                                                                             |        -         |
| **+ int getShieldAmount()**                        | Getter method of `shieldAmount`                                                                                                                                                                                                              |        -         |
| **+ boolean isGameStart()**                        | Getter method of `isGameStart`                                                                                                                                                                                                               |        -         |
| **+ void setGameStart(boolean isGameStart)**       | Setter method of `isGameStart`                                                                                                                                                                                                               |        -         |
| **+ boolean isGameEnd()**                          | Getter method of `isGameEnd`                                                                                                                                                                                                                 |        -         |
| **+ void setGameEnd(boolean isGameEnd)**           | Setter method of `isGameEnd`                                                                                                                                                                                                                 |        -         |

### [`GameUtil.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameUtil.java)

This class contains all game utility methods which are mostly randomization methods used for constructing a board in each game.

#### `GameUtil.java` Methods

| Methods                                                                                         | Description                                                                                                     |   More Details   |
| :---------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------- | :--------------: |
| **<ins>+ HashSet\<Integer> getRandomCellPosition(int range, int amount)</ins>**                 | Generates a `HashSet` of `amount` numbers from 0 to `range`.                                                    | [More Details]() |
| **<ins>+ Cell getRandomCell(ArrayList\<Cell> allCells)</ins>**                                  | Randomly picks one `Cell` from `allCells`.                                                                      | [More Details]() |
| **<ins>+ ArrayList\<Cell> getRandomMultipleCells(ArrayList\<Cell> allCells, int amount)</ins>** | Randomly picks `amount` objects of `Cell` from `allCells`.                                                      | [More Details]() |
| **<ins>+ ArrayList\<Integer> generateSequence(int mystery, int shield, int defuser)</ins>**     | Generates a random sequence of `mystery` of `0` numbers, `shield` of `1` numbers, and `defuser` of `2` numbers. | [More Details]() |
| **<ins>+ ArrayList\<Cell> getAdjacentCells(Cell cell)</ins>**                                   | Returns `ArrayList` of all adjacent `Cell` of current `cell`.                                                   | [More Details]() |
| **<ins>+ ArrayList\<Cell> getAdjacentNormalCells(Cell cell)</ins>**                             | Returns `ArrayList` of all adjacent `NormalCell` of current `cell`.                                             | [More Details]() |
| **<ins>+ ArrayList\<Cell> getUnflaggedCells(ArrayList\<Cell> allCells)</ins>**                  | Returns `ArrayList` of not flagged cells in `allCells`.                                                         | [More Details]() |
| **<ins>+ int countBomb(Cell cell)</ins>**                                                       | Counts amount of `BombCell` that adjacent to the current `cell`.                                                | [More Details]() |
| **<ins>+ int countSpecial(Cell cell)</ins>**                                                    | Counts amount of `SpecialCell` that adjacent to the current `cell`.                                             | [More Details]() |
| **<ins>+ boolean isValidCell(int x, int y, GamePane board)</ins>**                              | Validate `x` and `y` position.                                                                                  | [More Details]() |

### [`GameConfig.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GameConfig.java)

This class contains all game configuration, such as grid size, cell size, amount of cell in each type. All configuration are centralized here, makes it easy to change game configuration.

#### `GameConfig.java` Fields

All configuration are contains in `Array`. Every data of stage `n` are in index `n-1` of all fields.

> **Example:** Amount of `BombCell` in stage 5 is `GameConfig.BOMBS[4]`.

| Variables                           | Description                                                   |
| :---------------------------------- | :------------------------------------------------------------ |
| **<ins>+ int[] GRID_SIZE</ins>**    | Board size of each stage (e.g. `16 × 16`)                     |
| **<ins>+ int[] CELLS</ins>**        | Amount of `Cell` on a board of each stage. (e.g. `256`)       |
| **<ins>+ double[] CELL_SIZE</ins>** | `Cell` size of each stage in pixel (e.g. `28.8`)              |
| **<ins>+ int[] BOMBS</ins>**        | Amount of `BombCell` on a board of each stage. (e.g. `40`)    |
| **<ins>+ int[] MYSTERY</ins>**      | Amount of `MysteryCell` on a board of each stage. (e.g. `12`) |
| **<ins>+ int[] SHIELD</ins>**       | Amount of `ShieldCell` on a board of each stage. (e.g. `2`)   |
| **<ins>+ int[] DEFUSER</ins>**      | Amount of `DefuserCell` on a board of each stage. (e.g. `1`)  |

### [`GUIController.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GUIController.java)

This class focuses managing GUI. It manages page transition, game music, and some GUI utility method.

#### `GUIController.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `GUIController.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

### [`GUIConfig.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/control/GUIConfig)

This class contains all GUI configuration, such as application window size, and filename of all GUI components in a game. All configuration are centralized here, makes it easy to change game configuration.

#### `GUIConfig.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `GUIConfig.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

---

## Package `pane`

This package contains all of the GUI component of every page in a game.

### [`HomePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/HomePane.java)

This class construct home screen and its GUI components.

#### `HomePane.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `HomePane.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

### [`HowToPlayPane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/HowToPlayPane.java)

This class construct game tutorial screen and its GUI components.

#### `HowToPlayPane.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `HowToPlayPane.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

### [`StagePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/StagePane.java)

This class construct stage selection screen and its GUI components.

#### `StagePane.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `StagePane.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

### [`GamePane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/GamePane.java)

This class construct game board utilizing randomization method from `GameUtil.java`, creating its GUI components, and working with `GameController.java` to make the game working properly.

#### `GamePane.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `GamePane.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

### [`ControlPane.java`](https://github.com/reisenx/PROG-METH-I-PROJECT/blob/main/MINDsweeper/src/pane/ControlPane.java)

This class construct game control screen showing at the right side of `GamePane.java`, creating its GUI components, and working with `GameController.java` to properly update game status on user interface.

#### `ControlPane.java` Fields

| Variables | Description |
| :-------- | :---------- |

#### `ControlPane.java` Methods

| Methods | Description | More Details |
| :------ | :---------- | :----------: |

---
