# Лабораторна робота №1 (DOP) 
## Опис проєкту

Загалом реалізовано систему управління сповіщенями *(у завданні система управління замовленнями, можливо помилка)*. 
Принцип [DOP](https://en.wikipedia.org/wiki/Data-oriented_design) реалізовано через `sealed interface Notification` та типи `record` (`TextMsg`, `ImageMsg`, `AudioMsg`).  
У конструкторах кожної моделі додано перевірку параметрів, щоб запобігти створенню об'єктів із порожніми даними або `null`.
Розроблено клас `NotificationProcessor` для обробки сповіщень він використовує `switch expression` з `pattern matching` для обробки всіх типів повідомлень і повертає відформатований текст через `Text Blocks`.
Також, написано юніт-тести на `JUnit 5`, які перевіряють усі сценарії поведінки програми.
## Розрахунок варіанта

$$V = 5 \bmod 3 = 2$$

**Варіант $V = 2$:** Система управління сповіщеннями

## Інструкція із запуску тестів
> Для збірки проєкту та виконання тестів потрібні JDK 21+ та Apache Maven

Запуск тестів через Maven:
```bash
mvn test
```

Результат повинен бути, як на скріншоті знизу:
<img width="1072" height="258" alt="image" src="https://github.com/user-attachments/assets/cec67f51-2e4e-4b3d-a15f-d21613c494e6" />

## Покриття тестами
<img width="1019" height="176" alt="image" src="https://github.com/user-attachments/assets/f9abf465-3745-487a-9ce6-43b394e0aabb" />

Покриття коду тестами (за звітом [JaCoCo](https://www.eclemma.org/jacoco/)):
- **Instructions:** 100%
- **Branches:** 100%
- **Lines:** 100%

Запуск JaCoCo для генерації звіту:
```bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test org.jacoco:jacoco-maven-plugin:report
```
Після генерації звіту відкрийте файл `target/site/jacoco/index.html` у браузері.
