@echo off
::set /p "id=Enter Application Name: "

@echo off
:: TOP
:: Run list of applications in Computer and display
:: run 'wmic' and hit enter
:: run product get name and hit enter,   This will pull up the product list on your PC
set /p UserInputPath=Which of these applications would you like to delete?
cd C:\%UserInputPath%

:: Are you sure this is the  name: 'input' of the application you want to delete (Y/N)
:: if Y:
::          You really want to delete? (Y/N)
::          If Y, do:
::              run product where name=UserInputPath call uninstall
::          else:
::              JUMP TOP - set /p UserInputPath=What Directory would you like? i.e. jump to top of file and try again, or put in a loop
:: if N: 
::          JUMP TOP - set /p UserInputPath=What Directory would you like? i.e. jump to top of file and try again, or put in a loop
