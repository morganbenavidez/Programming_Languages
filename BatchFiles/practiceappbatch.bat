@echo off

title File Deletion
echo Welcome to File Deletion Feature

echo %cd%
cd "C:\Users\Morgan.Benavidez\Documents"
set path=%cd%
echo %cd%
dir

SET a=\testingfile0
SET b=\testingfile1
SET c=\testingfile2
SET d=\testingfile3

SET list=%a% %b% %c% %d%

(for %%e in (%list%) do (
     ::echo %list[%%e]%
     echo %%e
     del /f "%path%%%e"
))

echo %cd%
cd "C:\Users\Morgan.Benavidez\Documents"
echo %cd%
dir

echo PATH
echo %path%

pause



%e% %f% %g% %h% %i% %j%