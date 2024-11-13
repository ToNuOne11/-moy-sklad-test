# Подключение к БД
### В application.properties указать datasource.url (поменять на url своей БД)
### В Intelij EDEA Run -> edit configuration -> modify options -> environment variables указать DB_PASSWORD и DB_USER (пароль и логин пользователя БД)
# GET /api/products
### Описание: Получить список всех продуктов.
### Параметры: Нет
### Пример:
![image](https://github.com/user-attachments/assets/10cfd956-cf12-4857-bc08-75a43468add7)


## GET /api/product/{product_id}
### Описание: Получить продукт по id.
### Параметры: {product_id} - поменять на id продукта
### Пример:
![image](https://github.com/user-attachments/assets/9169cd36-5d39-4739-a1d8-bee17903a20a)


## POST /api/product
### Описание: Добавить продукт.
### Параметры: JSON Product
### Пример:
![image](https://github.com/user-attachments/assets/7ebfd031-33fe-4d8b-a2ed-23d6cc3e22d0)


## PATCH /api/product/{product_id}
### Описание: Обновить продукт по id.
### Параметры: JSON product, {product_id} - поменять на id продукта
### Пример:
![image](https://github.com/user-attachments/assets/28fb2b3b-a3a9-4406-aa17-15d59f3006f9)


## DELETE /api/product/{product_id}
### Описание: Удалить продукт по id.
### Параметры: {product_id} - поменять на id продукта
### Пример: 
![image](https://github.com/user-attachments/assets/980b79ac-bd01-4169-9dbf-6e1b84198290)

