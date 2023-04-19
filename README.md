# Player's Guide Project

Teaching myself Java programming by following the steps in the [player's
guide](players_guide_java.md). Tasks are tagged with git according to their
day when completed. Opening the completed Day 23 task is as simple as:

```shell
git checkout day23
```

**Current task:** [Day 35](players_guide_java.md#day-35-challenge-robotic-interface-75-xp)

Changing *RobotCommand* to an *interface* still compiles and runs with some small changes, the
big downside to this however is that there is no type safety now without performing additional
checks (using *if( instanceof )*). For this specific case using an *interface* seems to be the
inferior solution.
