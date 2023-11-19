@echo off
echo Deleting contents of the target directory...

REM 输出消息给用户
echo This script is deleting contents of the target directory.

REM 切换到项目根目录
cd /d "%~dp0\..\..\.."

REM 检查 target 目录是否存在
if exist "target/" (
    REM 删除target目录及其所有内容
    rd /s /q "target"
    echo Deletion completed.
    REM 输出消息给用户
    echo Deletion completed. You can tell your mom it's done.
) else (
    REM 输出消息给用户的
    echo Target directory does not exist. Nothing to delete.
)

REM 输出消息给你
echo before suite execution completed.

REM 不需要按任意键去结束
exit /b