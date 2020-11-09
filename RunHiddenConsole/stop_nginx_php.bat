@echo on
set php_home=D:\architect\php-7.4.12
set nginx_home=D:\architect\openresty-1.17.8.2-win64

echo Stopping PHP FastCGI...
taskkill /F /IM php-cgi.exe > nul

echo Stopping nginx...
taskkill /F /IM nginx.exe > nul

exit