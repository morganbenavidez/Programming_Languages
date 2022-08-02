@echo off

title Application Deletion.

echo Welcome to Application Deletion Feature

@echo off

::   Tool to help choose proper inputs for HardcodedApplicationNames

: PROMPT
set /p id=Would you like to view a list of currently installed applications before uninstalling? (Y[N]): 
IF %id%==Y GOTO APPLICATIONLIST
IF %id%==N GOTO DELETIONPROCESS

: APPLICATIONLIST
wmic product get name

: JUSTWAIT

echo Add any additional HardcodedApplicationName variables that you may want to now.
echo If you added more variables, than restart script.  Otherwise: proceed.
SET /P deletion=Would you like to proceed with deletion process yet? (WAIT[Y]): 
IF %deletion%==Y GOTO DELETIONPROCESS
IF %deletion%==WAIT GOTO JUSTWAIT

: DELETIONPROCESS

::   Add or subtract more HardcodedApplicationName as needed.

SET a=HardcodedApplicationName0
SET b=HardcodedApplicationName1
SET c=HardcodedApplicationName2
SET d=HardcodedApplicationName3
SET e=HardcodedApplicationName4
SET f=HardcodedApplicationName5
SET g=HardcodedApplicationName6
SET h=HardcodedApplicationName7
SET i=HardcodedApplicationName8
SET j=HardcodedApplicationName9

::   Add or subtract variables to match above as needed.

SET list=%a% %b% %c% %d% %e% %f% %g% %h% %i% %j%

(for %%z in (%list%) do (
     ::echo %list[%%z]%
     echo Searching directory for %%z...
     wmic product where name="%%z" call uninstall
))

pause