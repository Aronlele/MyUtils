@echo on
set php_home=D:\architect\php-7.4.12
set nginx_home=D:\architect\openresty-1.17.8.2-win64

echo Starting PHP FastCGI...
RunHiddenConsole %php_home%/php-cgi.exe -b 127.0.0.1:9000 -c %php_home%/php.ini

echo Starting nginx...
RunHiddenConsole %nginx_home%/nginx.exe -p %nginx_home%