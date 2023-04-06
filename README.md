# Player's Guide Project

Teaching myself Java programming by following the steps in the [player's
guide](players_guide_java.md). Tasks are tagged with git according to their
day when completed. Opening the completed Day 23 task is as simple as:

```shell
git checkout day23
```

**Current task:** [Day 29](/players_guide_java.md#day-29-design-challenge-15-puzzle-150-xp)

#### Class:

```mermaid
classDiagram
    direction LR
    class PuzzleBoard {
        -int[][] board
        -int moves
        -final int width
        -final int height
        -PuzzleBoard(int width, int height)
        +Direction
        +create15Puzzle()$ PuzzleBoard
        +printBoard()
        +hasWon() boolean
        +commitMove(Direction direction, int amount)
        +getMoves() int
        -populateRandom()
        -getMaxAmount() int
    }
    note for `Direction` "Enum Direction defined in PuzzleBoard"
    class `Direction` {
        <<Enumeration>>
        NORTH
        EAST
        SOUTH
        WEST
    }
    PuzzleBoard ..> `Direction`: Subclass
```
