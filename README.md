## Running and installing
1. Clone the project from git
2. To simply run test in chrome browser either press "Run" button in the `InsuranceCarTest` or run `mvn clean test` from command line in the root of the project.
3. To run tests in parallel run `mvn surefire:test` from command line.
   ! **To run `mvn` commands maven should be installed and added to PATH. It is possible to install maven using `brew install maven`**

## Test Architecture and Decisions
* I have used page objects for all test pages
* The base abstract test is used to initialize the web driver. This class could be extended in the future to include initialization of different web drivers for required browsers.
* ConsentScenario is used to accept cookies in the consent window no matter which page the test is on. It uses script execution to bypass the shadow root inside the HTML DOM.
* CarDataParameter is used to pass different parameters depending on the test case