@echo off

IF NOT EXIST SourceFiles (
mkdir SourceFiles
move *.java SourceFiles 
 ) ELSE ( 
 echo Folder SourceFiles already Exists )


IF NOT EXIST class (
mkdir class 

) ELSE ( echo Folder class already Exists)


cd class
del *.class
cd ..\SourceFiles
javac *.java -d ..\class
pause
