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
4. To run specific test go to `features/chosenScenario.feature` and press `run
5. To run a whole test suit go to `cucumber/runner/TestRunner.java` and run the `TestRunner`

### Reporting

The framework is using build in reporting function.
To open the report:

1. Run suite using `TestRunner`
2. Go to `target` and find the file `cucumber.html`
3. Open that file using any browser