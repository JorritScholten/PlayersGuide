# Player's Guide Project

Teaching myself Java programming by following the steps in the [player's guide](players_guide_java.md). Tasks are
tagged with git according to their day when completed. Opening the completed Day 23 task is as simple as:

```shell
git checkout day23
```

**Current task:** [Day 28](/players_guide_java.md#day-28-design-challenge-rock-paper-scissors-150-xp)

#### Enums:

```mermaid
classDiagram
    direction LR
    class RPSOptions {
        <<Enumeration>>
        ROCK
        PAPER
        SCISSORS
        +contest(RPSOptions opponent) RPSMatchResult
    }

    class RPSMatchResult {
        <<Enumeration>>
        WIN
        LOSE
        DRAW
    }

    RPSOptions ..> RPSMatchResult
```

#### RPSOptions.contest() flow:

```mermaid
%%{init: { "flowchart": { "curve": "linear" } } }%%
flowchart TD
    a["RPSMatchResult contest(RPSOptions opponent)"] --> b
    b{{"this == opponent"}} -->|false| d
    b -->|true| c["return DRAW;"]
    d{{"this == ROCK"}} ---->|false| h
    d -->|true| e{{"opponent == PAPER"}}
    e -->|true| f["return LOSE;"]
    e -->|false| g["return WIN;"]
    h{{"this == PAPER"}} -->|false| l
    h -->|true| i{{"opponent == SCISSORS"}}
    i -->|true| j["return LOSE;"]
    i -->|false| k["return WIN;"]
    l{{opponent == ROCK}} -->|false| m["return LOSE;"]
    l -->|true| n["return WIN;"]
```

#### Main program flow:

```mermaid
%%{init: { "flowchart": { "curve": "linear" } } }%%
flowchart TD
    a[Program start] --> b("Ask for player 1 choice")
    c -->|Invalid input| b
    b --> c{{Validate input}}
    c -->|Valid input| d("RPSOptions player1 = RPSOptions.< choice >;")
    d --> e("Ask for player 2 choice")
    e --> f{{Validate input}}
    f -->|Invalid input| e
    f -->|Valid input| g("RPSOptions player2 = RPSOptions.< choice >;")
    g --> h{{"switch(player1.contest(player2))"}}
    h -->|case WIN| i("print: player1 wins")
    h -->|case LOSE| j("print: player2 wins")
    h -->|case DRAW| k("print: players draw")
    i --> l[print: Match concluded!]
    j --> l
    k --> l
```
