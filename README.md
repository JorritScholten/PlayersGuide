# Player's Guide Project

Teaching myself Java programming by following the steps in the [player's guide](players_guide_java.md).

**Current task:** [Day 23](/players_guide_java.md#day-23-challenge-the-point-75-xp)

### Are your x and y immutable? Why did you choose what you did?

The created points are immutable because there are no setter methods for Point.x and Point.y and both are also
declared as final. Either choices suffice to make Point immutable but declaring x and y as final is safer as it
enforces immutability.