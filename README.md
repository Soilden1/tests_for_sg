
# <a href="https://sabyget.ru/"><img src="media/logo/sabyget.ico" width="55" height="55"/></a> Проект по автоматизации тестирования для <a href="https://sabyget.ru/">Sabyget.ru</a>.</h1>

## :technologist: Технологии и инструменты

<p  align="center">

<a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/logo/Idea.svg"></a>
<a href="https://www.java.com/"><img width="5%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://selenoid.autotests.cloud/"><img width="5%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/logo/Selenide.svg"></a>
<a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="5%" title="Junit5" src="media/logo/Junit5.svg"></a>
<a href="https://github.com/"><img width="5%" title="GitHub" src="media/logo/GitHub.svg"></a>
<a href="https://allurereport.org/"><img width="5%" title="Allure Report" src="media/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/Allure_TO.svg"></a>
<a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="media/logo/Jenkins_logo.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/logo/Jira.svg"></a>
<a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/logo/Telegram.svg"></a>
</p>

-  Java - язык программирования, на котором написан проект
-  IntelliJ IDEA - среда разработки Java-проектов
-  Gradle - система автоматической сборки проектов
-  Junit5 - фреймворк для создания и управления тестами
-  GitHub - сервис для совместной разработки и хостинга проектов
-  Selenide - обёртка вокруг Selenium WebDriver, позволяющая быстро и просто писать тесты на UI
-  Allure Report - гибкий инструмент для составления отчетов о тестировании
-  Jenkins - программа, позволяющая организовать процесс непрерывной интеграции и доставки кода программного продукта, сборки
-  Selenoid - удаленная ферма девайсов, которая позволяет запускать браузеры в docker контейнерах, записывать видео
-  Allure TestOps - программа, позволяющее управлять как ручным, так и автоматизированным тестированием
-  Jira - удобный инструмент для полноценного контроля за всем циклом тестирования
-  Telegram - реализовано автоматическое оповещение о результатах прохождения автотестов


## :heavy_check_mark: Список функционала, покрытого автотестами:

- [x] Авторизация
- [x] Навигация по сайту
- [x] Поиск и получение информации о заведении
- [x] Покупки клиента Saby Get
- [x] Чаты и контакты клиента Saby Get
- [x] Система лояльности в заведении
- [x] Работа с профилем клиента
- [x] Отзывы о заведении
- [x] Пользовательское соглашение


## :heavy_check_mark: Список проверок, реализованных в ручных тестах

- [x] Просмотр новости
- [x] Сортировка заведений по рейтингу


## :rocket: Запуск тестов

###  :rocket: Локальный запуск :
```bash
gradle clean test
```

###  :rocket: Удаленный запуск (в Jenkins):
<p align="center">
<img title="Jenkins" src="media/images/jenkins.jpg">
</p>

1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/022-Soilden-tests_for_sg/">проект</a>
2. Нажать **Build with Parameters**
3. Результат запуска сборки можно посмотреть в отчёте Allure

## :triangular_flag_on_post: Allure отчеты:

### <img src="media/logo/Allure.svg" width="25" height="25"  alt="Allure"/>Отчет в </a> <a target="_blank" href="https://jenkins.autotests.cloud/job/022-Soilden-tests_for_sg/allure/"> Allure Report</a>

#### :black_small_square: Основной отчет
<p align="center">
<img title="Allure Report Dashboards" src="media/images/allureReport.jpg">
</p>

#### :black_small_square: Тесты
<p align="center">
<img title="Allure Report Tests" src="media/images/tests.jpg">
</p>

### <img src="media/logo/Allure_TO.svg" width="25" height="25"  alt="Allure TestOps"/>Отчет в Allure </a> <a target="_blank" href="https://allure.autotests.cloud/project/3956/dashboards"> TestOps</a>

#### :black_small_square: Allure отчет
<p align="center">
<img title="Allure TestOps Dashboards" src="media/images/allureReport.png">
</p>

#### :black_small_square: Тесты в Allure TestOps
<p align="center">
<img title="Allure TestOps Tests" src="media/images/allureTests.png">
</p>


#### :black_small_square: Пример ручных тестов
<p align="center">
  <img title="Allure TestOps manual tests" src="media/images/manual.png">
</p>

## <img src="media/logo/Jira.svg" width="25" height="25" alt="Jira"/>Интеграция с</a> <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1044"> Jira</a>
<p align="center">
  <img title="Allure TestOps overview" src="media/images/jira.png">
</p>

## <img src="media/logo/Telegram.svg" width="25" height="25"  alt="Telegram"/>Telegram уведомления</a>

<p align="center">
<img title="Allure Overview Dashboard" src="media/images/telegram.png">
</p>

##  <img src="media/logo/Selenoid.svg" width="25" height="25" alt="Selenoid"/>Selenoid видеозапись тестов</a>
### Видеозапись прохождения тестов

<p align="center">
  <img title="Selenoid video" src="media/video/video.gif">
</p>
