========================
BUILD OUTPUT DESCRIPTION
========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "BPlusTree.jar" 

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

1) To run the code add the input file to the dist directory.

2) In the terminal go into the dist directory.

3) in the command line put: java -jar "BPlusTree.jar" FILENAME

4) in the same directory and output created in the same folder.