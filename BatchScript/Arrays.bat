:: Arrays

@echo off

:: Create an array

set list=1 2 3 4

(for %%a in (%list%) do (
     echo %%a
))


:: Create an array by setting by indices

set a[0]=7
set a[1]=8
set a[2]=9

echo The first element of the array is %a[0]%
echo The second element of the array is %a[1]%
echo The third element of the array is %a[2]%

:: This works, but cannot reference index[3] even though it is the last index
:: must index [-1]?
set a[-1]=10
echo The last element of the array is %a[-1]%
