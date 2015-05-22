# Fibonacci-WebService
Fibonacci Web Service

Contains Fibonacci App written for EMC

This repo contains the Fibonaci Web Service written for EMC.
Extract the ZIP file and you will see two folders: JUnitTests and BuildDir.

To run the JUnit tests 
1. cd JUnitTests
2. On Windows, compile the sources by executing the following command
   javac -cp .;.\JUNIT\junit-4.12.jar;.\JUNIT\hamcrest-core-1.3.jar com\mycompany\junittests\WSJUnitTests.java
3. To run the tests, execute
   java -cp .;.\JUNIT\junit-4.12.jar;.\JUNIT\hamcrest-core-1.3.jar org.junit.runner.JUnitCore com.mycompany.junittests.WSJUnitTests

The Fibonacci Web Service was developed using Tomcat 7 and Juli for logging. The Juli library is not included in the WAR
file, so you will need to deploy the WAR file on a Tomcat Application Server.
To build and deploy the Web Service to your Tomcat Application Server, do the following
1. cd BuildDir
2. Open the build.xml file and replace the tomcat.home property with the home directory of your Tomcat installation.
   Save the file.
3. Execute -> ant deploy
4. Once the Web Service has been deployed, it can be accessed via the URL,
   http://localhost:8080/FibonacciWS//FibonacciServlet
5. To see a Fibonacci Sequence, use the "num" pararmater as part of a query string, as so
   http://localhost:8080/FibonacciWS//FibonacciServlet?num=5
6. To see the result in XML, JSON, or HTML, use the "fmt" parameter as so,
   http://localhost:8080/FibonacciWS//FibonacciServlet?num=5&&fmt=HTML
