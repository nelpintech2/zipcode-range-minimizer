# Zip Code Range Minimizer Application

Version: 1.0.0-SNAPSHOT

Author: Nelson Pinto

Date: 03/18/2021


#### Background
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

#### Problem
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

##### Notes
The ranges above are just examples, your implementation should work for any set of arbitrary ranges
Ranges may be provided in arbitrary order
Ranges may or may not overlap
Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices.

##### Examples:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

### Running the application

1. Running in IDE
   - Import as existing Maven project.
   - Go to RunAs -> Run Configurations -> Arguments. In Program Arguments, you may provide the actual inputs.
2. Running via command prompt
   - cd into project root path.
   - Run following commands.
```
mvn clean package
```
```
java -jar target\zipcode-range-minimizer-1.0.0-SNAPSHOT.jar [94133,94133] [94200,94299] [94226,94399]
```

#### Running tests
```
mvn test
```
The Surefire reports can be found at `${project dir}/target/surefire-reports/`
