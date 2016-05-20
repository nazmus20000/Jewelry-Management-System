@echo off

echo d | xcopy /y jwldb.db "C:\Database Backup"
echo d | xcopy /y IDGen.db "C:\Database Backup"
echo d | xcopy /y dldb.db "C:\Database Backup"
echo d | xcopy /y acdb.db "C:\Database Backup"
echo d | xcopy /y acddb.db "C:\Database Backup"
echo d | xcopy /y acedb.db "C:\Database Backup"
echo d | xcopy /y mkdb.db "C:\Database Backup"
echo d | xcopy /y tkdb.db "C:\Database Backup"

exit