# AppiumJavaSample
Sample project for running tests using Java/TestNG/Appium 

## Setting up your machine
### Prerequisites before running the script for Appium setup 
* Set `JAVA_HOME` as an environment variable

* Set `ANDROID_HOME` as an environment variable - pointing to the directory where Android SDK should be setup

* Execute the following scripts to setup your Mac [setup_mac.sh](setup_mac.sh) or Ubuntu [setup_linux.sh](setup_linux.sh) machine automatically 
> The above script will install all dependencies required for implementing / running tests on Android devices. To do the setup for iOS devices, run `appium-doctor` and see the list of dependencies that are missing, and install the same.

> You may be prompted for password or confirmations along the way 

## Running the tests
### Prerequisites:
* Start appium server manually (and update the url/port if not using the default)
* Have devices connected / emulators started. Accordingly, update the (.*Test.java) test file with the relevant information about the devices
* The device should have the Chrome browser

### Tests
This project includes the following tests implemented for Android & iOS devices:

What challenges did you face during this exercise?

The main challenge is the website is down sometimes while accessing and was getting technical errors while scripting. Had to try multiple times

Why did you choose the framework that you chose?
Reason to choose Java/TestNG/Appium framework is because of the ability to create the tests with ease and execute them separate or parallell

