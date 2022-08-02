:: Local and Global Variables
:: the var variable will be destroyed when the ENDLOCAL line is executed

@echo off

set /A globalvar = 5

SETLOCAL

set /A var = 13145
set /A var = %var% + 5
echo %var%
echo %globalvar%

ENDLOCAL


echo %var%