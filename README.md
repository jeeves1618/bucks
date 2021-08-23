# bucks
The goal of this project is to create reusable programs for tax computation, savings trackking and expenses management
1. To run a class inside the JAR, use the command: 
	java -cp <JAR Name.jar> <class name>
2. To run a class inside the JAR that is also part of a package, use the command: 
	java -cp <JAR Name.jar> <package name>.<class name>
	If you have made the jar file executable using manifest file with the class to be executed specified, then use the command:
	java -jar <JAR Name.jar>
3. http://localhost:8080 is Jenkins server. 
4. http://[jenkins-server]/[command] where [command] can be any one of the following
    exit
    restart
    reload
    Example: http://localhost:8080/exit	
5. To download and run the WAR file version of Jenkins: Open up a terminal/command prompt window to the download directory. 
	Run the command java -jar jenkins. war 
6. To do
	- Junit Tests
	- Host the application in an Apache Tomcat server
	- Rewrite the takeHome class so that it returns values rather than printing it.
7. services.msc is the command to list Windows services.
8. To start SonarQube C:\sonarqube\sonarqube-8.3.1.34397\bin\windows-x86-64\StartSonar.bat
	Sonar is avaialble in the port http://localhost:9000 
	More about Sonar on: https://docs.sonarqube.org/latest/setup/get-started-2-minutes/
	stop the Sonar Server through Ctrl+c before closing the command window
9. H2
	Directory: cd c:\Program Files (x86)\H2\bin
	To get into Shell: java -cp h2-*.jar org.h2.tools.Shell
	<namerev>
10. =CONCATENATE(RIGHT(C2,4),MID(C2,4,2),LEFT(C2,2))
		
chartOfAccounts = C:\\dev\\Data\\ChartOfAccounts.xlsx
NLPtokenizer = C:\\dev\\Data\\NLP.xlsx
OneSal1 = C:\\dev\\Data\\OneAcctSal1.xlsx
TwoSal1 = C:\\dev\\Data\\TwoAcctSal1.xlsx
OneSav1 = C:\\dev\\Data\\OneAcctSav1.xlsx
TwoSav1 = C:\\dev\\Data\\TwoAcctSav1.xlsx
