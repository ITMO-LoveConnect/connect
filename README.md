# ITMO LoveConnect
## Сборка
Для сборки необходимо запустить команду `./gradlew build`
## Локальная развертка
Для запуска проекта необходимо включенное и настроенное s3 и Postgres хранилища. Самым простым способом будет последовательно выполнить команды по развертке всех необходимых сервисов с помощью docker-compose файла.
  1. Запустите команду:  
      ```
      docker compose -f ./docker/docker-compose.yml --profile dev up -d
      ```
     Эта команда поднимет Postgres и s3 локально.

  2. Запустите приложение: 
     ```
     ./gradlew bootRun
     ```
  3. При удачном запуске вам должны быть доступны эндпоинты `/tag` , `/auth/...`, `/swagger-ui/index.html`... по адресу `http://localhost:8080`
## Удаленная развертка 
Для удаленной развертки необходимо:
  1. Сбилдить образ с обновлением тэга latest для той ветки, которую вы хотите развернуть. Это делается через github actions:
     ![image](https://github.com/user-attachments/assets/8f6dd0cf-3a86-483e-beb2-999f17ede220)
     Также можно не обновлять latest тэг, при этом в ghcr запушится версия приложения с тэгом `ghcr.io/itmo-loveconnect/connect:{название ветки}-{дата и время сборки}`
  2. Запустить деплой на сервер. Тоже через github actions. Перед этим убедитесь что все параметры для приложения настроены:
     ![image](https://github.com/user-attachments/assets/5ade70ac-5cce-483e-9023-f64228d3bea9)
     Запуск деплоя:
     ![image](https://github.com/user-attachments/assets/63df1739-b212-4c25-b809-b54db11a7e4f)
  3. После этого при успешном деплое на сервере команда
     ```
     docker logs -f docker-prod_app-1
     ```
     должна выводит в стандартный поток логи приложения.

## [Ссылка на презентацию](https://drive.google.com/drive/folders/1Ke-hiDQ37F6m8XISE-2La0o41oAx2pLU?usp=sharing)
