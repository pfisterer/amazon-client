Simple Amazon Client
=============

Requirements
======
To build, you need

* Java 8 or higher (<http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>) 
* Maven 3 or higher (<http://maven.apache.org/>)

Building and Setup
======
Before cloning this repository, be sure to enable automatic conversion of CRLF/LF on your machine using `git config --global core.autocrlf input`. For more information, please  refer to <http://help.github.com/dealing-with-lineendings/>

To build the project, run `mvn package`, this will build the program and place the generated jar file in the directory `target/`.

Running
======

Create a file in src/main/resources with the following contents:
```
amazon.accessKey=<your amazon access key>
amazon.secretKey=<your amazon secret key>
amazon.associateTag=<your amazon associate tag>
```

Use this filename in Main.java
