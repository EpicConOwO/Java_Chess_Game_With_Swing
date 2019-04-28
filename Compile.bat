@echo off

IF NOT EXIST SourceFiles goto FirstRun


IF NOT EXIST class goto MakeDir


:FirstRun
mkdir SourceFiles
move *.java SourceFiles 

:MakeDir
echo at mkdir
 mkdir class 
 



cd class
del *.class
echo going to soucefile
cd ..\SourceFiles
javac *.java -d ..\class
pause