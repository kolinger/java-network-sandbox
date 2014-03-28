@echo off
echo Generating slices...
slice2java --output-dir=../../java -Islices slices.ice
echo Done
pause
