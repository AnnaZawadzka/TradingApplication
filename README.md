# Trading Application Framework

The following repository contains an automation framework for testing web services.
The framework is based on RestAssured, Cucumber and jUnit4.

### Requirements

To open the project you need to have installed:

1. Git
2. [JDK 17](https://www.oracle.com/java/technologies/downloads/#JDK17)
3. At least [Maven 3.6.3](https://maven.apache.org/download.cgi)
4. Build project  [TradingApplication](https://github.com/aldialimucaj/code-challenge) - to build
   the project follow the instruction from README

Install JDK and Maven and configure properly `JAVA_HOME` and `M2_HOME`

### Running tests

1. Clone the repository
2. Install project using command:

```shell
mvn install
```

3. Start the Trading Application listed in Requirements section
4. To run the specific test go to the package  `features/chosenScenario.feature` and press `Run`
5. To run a whole test suit go to the package `cucumber/runner/TestRunner.java` and run the `TestRunner`

(added) 6. Or you can run command 

```shell
mvn test
```
from repository 

### Reporting

The framework is using build in reporting function.
To open the report:

1. Run the test suite using `TestRunner`
2. Go to the `target` and find the file `cucumber.html`
3. Open that file using any browser
