# TrelloWebAPI

## JAVA
### Install JDK and set JAVA_HOME; PATH Variable
Example for Windows:\
Installed Java Location: = _C:\Program Files\Java\jdk1.8.0_162_\
JAVA_HOME = _C:\Program Files\Java\jdk1.8.0_162_\
PATH: _%JAVA_HOME%\bin_\

## MAVEN
 ### Set M2_HOME; MAVEN_HOME; PATH Variable
Example in Windows:\
Unzipped Maven Location: = _C:\Program Files\Java\apache-maven-3.5.2_\
M2_HOME: = _C:\Program Files\Java\apache-maven-3.5.2_\bin
MAVEN_HOME: =_C:\Program Files\Java\apache-maven-3.5.2_\
PATH: _%M2_HOME%_


## GET THE CODE
**Git:**

git clone https://github.com/.git \
**cd Trello**

Or simply download a zip file.

## Using Maven to run test and generate report

**mvn clean verify serenity:aggregate**

This runs Cucumber features using Cucumber's JUnit runner. The @RunWith(CucumberWithSerenity.class) annotation on the CucumberTestSuite class tells JUnit to kick off Cucumber.

#### Executing web test on Windows (info):
     The chrome driver server (src\test\resources\drivers\chromedriver.exe) is referenced in serenity.properties file
     Ensure chrome browser is installed on the (preferable brwoser version between 65-67)

#### Executing web test on other platforms  (info):
     Update serenity.properties file (property - 'webdriver.chrome.driver') with location of the driver server
     Ensure chrome browser is installed on the (preferable  compatible brwoser version with the chrome driver sever)

## Viewing the reports
Command provided above will produce a Serenity test report called **_index.html_** in the **_target/site/serenity_** directory


     ****** A sample serenity report report (index.html) from the last run has been placedat 'src/test/resources/sample_serenity_report/serenityer' for reference ******


## Integration with CI Tool -  Jenkins

### Jenkins Instance Installation:

 1. Go to https://jenkins.io/
 
 2. Download .war file
 
 3. _cd_ <directory where .war is located> \
        _java - jar jenkins.war_
        
 4. OPEN browser in local at _localhost:8080_
 
 5. Credntials
    
    default usernmae: _admin_ \
    default password: located <_/Users/<usernmae>/.jenkins/secret/intialAdminPassword_>
    

### Create Jenkins Job:

1. Install plugin: _HTML publisher plugin_ (https://plugins.jenkins.io/htmlpublisher)

2. Create a new freestyle project

3. Configure Job

    **3.1 source code management:**
    
    _**GIT**_\
    		**Repo URl:**  https://github.com/.git \
    		**branch**: /*master\
    
    **3.2 Build**\
        3.2.1 Invoke top-level Maven target:\
        **Goal:**
        clean verify serenity:aggregate\
        **POM**:
        <projectname>/pom.xml\
        
    **3.3 Post build actions:**\
        publish HTML report:\
        **Index page[s]:** target/site/serenity/index.html \
        
    **Unable to see reports properly in Jenkins ?**\
        Click Manage Jenkins > Script Console, and run one of the following scripts from the console:
            
   _System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")_    		
    		
    		 
