# bucks
The goal of this project is to create reusable programs for tax computation, savings trackking and expenses management
1. To run a class inside the JAR, use the command: 
	java -cp <JAR Name.jar> <class name>
2. To run a class inside the JAR that is also part of a package, use the command: 
	java -cp <JAR Name.jar> <package name>.<class name>
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