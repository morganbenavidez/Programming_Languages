@ echo off :: This ensures the commands are not shown when the code is executed.

:: Rem (This is the same as :: for commenting out)


:: The dir command is used to take the contents of the location C:\Program Files
:: The > command is used to redirect the output of above to the file C:\lists.txt
:: I don't have the permissions to execute this line
dir "C:\Program Files" > C:\lists.txt 

:: echo command is used to alert the user that the operation is complete
echo "The program has completed"