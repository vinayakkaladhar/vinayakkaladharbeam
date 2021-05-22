# Project Title

Automated requirements as mentioned in the Assignment

## Getting Started

Tools used: Intellij as IDE
Browser: Chrome
Language: JAVA
framework : TestNG
Build tool: Maven
OS: MAC

### Prerequisites

Java 1.8+ version installed
Maven installed

## Running the tests

1. Import the pom.XML
2. Use commands: mvn clean followed by mvn install to install the dependencies
3. Invoke the testNG.xml from IDE or
  via terminal: mvn clean test -Dsurefire.suiteXmlFiles=/path/to/testng.xml -DBrowserName= "Chrome"

xml includes:
class: GitHubSearch
Methods: verifySearchFileFunctionality(), VerifyNavigationToRepository(),verifyNavigationToGitHub()

### Scenario1

1.Have built a console application - would take input as: Repository name

2.Have used selenium - Browser approach to extract the details

### Scenario2

1.Have designed a framework with PageObject and PageFactory design pattern involved.

2.Better try-catch mechanism to handle

3.Proper asserts and reporting used to provide a detailed context, can be witnessed in testNG Report - have checked in the same.

4.Tests are capable of running on multiple Browsers and the browser can be chosen and passed as input via terminal.

## Authors

Vinayak kaladhar

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
