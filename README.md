Для запуска образа необходимо установить значения переменных GITHUB_USER и GITHUB_TOKEN.

*** Вариант запуска через compose в IDEA:
1. Собрать приложение через gradle
2. Посмотреть значения переменных в логах
3. Установить значения переменных среды (пример на mac):
```
echo 'export GITHUB_USER="user"' >> ~/.zshrc
source ~/.zshrc
```
4. Нажать стрелочку в compose

*** Вариант запуска через терминал:
с 1 - 3 пункт повторяем.
4. запускаем в терминале сборку докер образа
``` 
docker buildx build --push -t vuhtang/google-app --build-arg GITHUB_TOKEN=*ваш токен* --build-arg GITHUB_USER=*ваш логин* .
``` 
