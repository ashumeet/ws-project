#Zip Code Range Problem

##Problem:
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

###Notes:
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

###Examples:
If the input: ```[94133,94133] [94200,94299] [94600,94699]```

Then the output should be: ```[94133,94133] [94200,94299] [94600,94699]```

If the input: ```[94133,94133] [94200,94299] [94226,94399]```

Then the output should be: ```[94133,94133] [94200,94399]```

###Test Code:
Just run the junit test code

###Limitations:
* The code will fail if the input is not in the correct format