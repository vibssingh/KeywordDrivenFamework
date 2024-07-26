**_Keyword Driven Test Framework_**
A keyword-driven framework is a software testing framework that separates the test script logic from the test data through a set of keywords or actions. Keywords or actions represent the basic building blocks of the test script. Examples of keywords can include "click," "sendKeys," "verifyText," etc. These keywords are defined in a central repository or spreadsheet, along with the associated test data and expected results.

This is a sample application to demonstrate how to setup Keyword Driven Framework using Selenium, TestNG and Apache POI. Framework uses Page Object Design Pattern, hence there is clean separation between test code and page specific code such as locators and layout.

This framework consists of:
```
   Selenium – 4.21.0
   Java 17
   TestNG – 7.10.2
   Maven – 3.9.6
   Apache POI – 5.2.5
   Commons - 2.16.1
   Maven Surefire Plugin - 3.2.5
   Maven Compiler Plugin - 3.13.0
```

All the test to be executed can be configured in TestData.xlsx sheet placed in below path.
```
src\test\resources\testdata.xlsx
```

Open the command prompt and navigate to the folder in which pom.xml file is present. Run the below Maven command.
```
mvn clean test
```

Reports - This framework contains sample TestNG Reports under **_test-output**_ folder.