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

#### Main program flow:

```mermaid
%%{init: { "flowchart": { "curve": "linear" } } }%%
flowchart TD
    a[Program start] --> m("int player1_wins = 0,<br> player2_wins = 0,<br> draws = 0;")
    m --> b("Ask for player 1 choice")
    c -->|Invalid input| b
    b --> c{{Validate input}}
    c -->|Valid input| d("RPSOptions player1 = RPSOptions.&lt;choice>;")
    d --> e("Ask for player 2 choice")
    e --> f{{Validate input}}
    f -->|Invalid input| e
    f -->|Valid input| g("RPSOptions player2 = RPSOptions.&lt;choice>;")
    g --> h{{"switch(player1.contest(player2))"}}
    h -->|case WIN| i("print: player1 wins<br> player1_wins++;")
    h -->|case LOSE| j("print: player2 wins<br> player2_wins++;")
    h -->|case DRAW| k("print: players draw<br> draws++;")
    i --> l{{"Continue playing?"}}
    j --> l
    k --> l
    l -->|Continue playing| b
    l -->|Stop playing| n["print record of matches<br> Program end"]
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

