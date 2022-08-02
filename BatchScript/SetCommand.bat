:: Set command

:: variable-name is the name of the variable you want to set
:: value is the value which needs to be set against the variable
:: /A This switch is used if the value needs to be numeric in nature.

:: set /A variable-name=value



:: In Practice -

@echo off
set message=Hello World
echo %message%

set /A a = 5
set /A b = 10
set /A add = %a% + %b%
set /A subtract = %a% - %b%
set /A divide = %b% / %a%
set /A multiply = %a% * %b%


echo %add%
echo %subtract%
echo %divide%
echo %multiply%