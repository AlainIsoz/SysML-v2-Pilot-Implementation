@echo off

echo --- Step 1: Testing Conda installation ---
where conda
if errorlevel 1 (
    echo Conda is not installed. Please install Conda and re-run.
    goto :error
)
call conda --version || goto :error

echo --- Step 2: Testing Java installation ---
where java
if errorlevel 1 (
    echo Java is not installed. Please install Java and re-run.
    goto :error
)
call java --version || goto :error

echo --- Step 3: Installing Python and Jupyter into Conda environment ---
call conda install python=3.* jupyter=1.0.* -y || goto:error

echo --- Step 4: Testing Python installation ---
where python3
if errorlevel 1 (
    echo Python 3 is not installed. Please manually install it.
    goto :error
)

echo --- Step 5: Installing SysML v2 Jupyter kernel ---
echo %*
call jupyter kernelspec remove sysml -f
call python3 %~dp0\install.py --sys-prefix %* || goto:error

echo --- Step 6: Running Jupyter environment ---
echo NOTE: To launch Jupyter you can now run ^"jupyter notebook^" from Terminal.
echo Re-running this script will re-install the environment and launch Jupyter.
echo(
echo(
echo(
echo(
echo(
call jupyter notebook
goto :EOF

:error
echo Failed with error #%errorlevel%.
exit /b %errorlevel%