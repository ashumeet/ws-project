# Zip Code Range Problem

## Problem:
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

### Notes:
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

### Examples:
If the input: ```[94133,94133] [94200,94299] [94600,94699]```

Then the output should be: ```[94133,94133] [94200,94299] [94600,94699]```

If the input: ```[94133,94133] [94200,94299] [94226,94399]```

Then the output should be: ```[94133,94133] [94200,94399]```

### Design and Further:
* This code only has model and service layer.
* Test code is written to test the service layer only.
* Further we can add spring or GJuice frameword and plug in this service in a API.
* Further we can write test case to test 'add' method for 'CondensedRangeList' class.

### Test Code:
* Run the junit test in the IDE or run ```./gradlew test``` from command line

### Limitations:
* The code will fail if the input is not in the correct format
