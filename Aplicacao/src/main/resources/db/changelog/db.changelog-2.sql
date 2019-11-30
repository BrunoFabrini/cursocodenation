--liquibase formatted mysql

--changeset bruno.fabrini:2.0 dbms:mysql


--adress
INSERT INTO address (zip_code, street, number, district, city, country)
values ('123456789', 'Rua Aimorés', 1000, 'Lourdes', 'Belo Horizonte', 'Brasil');

--companies
INSERT INTO company (name, document, vacancies, site, address_id)
values('Empresa 1', '123456789', 1, 'www.empresa1.com.br', 1);

INSERT INTO company (name, document, vacancies, site, address_id)
values('Empresa 2', '3215468789', 3, 'www.empresa2.com.br', 1);

INSERT INTO company (name, document, vacancies, site, address_id)
values('Empresa 3', '87454512135', 1, 'www.empresa3.com.br', 1);

INSERT INTO company (name, document, vacancies, site, address_id)
values('Empresa 4', '987512231', 5, 'www.empresa4.com.br', 1);

INSERT INTO company (name, document, vacancies, site, address_id)
values('Empresa 5', '231545689', 10, 'www.empresa5.com.br', 1);

--users
--INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
--VALUES ('Usuário 1', 6544848956, 20, 'user1', 'user1', 2000.00, 1, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 2', 54532454353, 23, 'user2', 'user2', 2430.10, 2, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 3', 12421342134, 54, 'user3', 'user3', 5000.00, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 4', 2312342423, 32, 'user4', 'user4', 4030.80, 4, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 5', 656346431, 33, 'user5', 'user5', 5340.50, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 6', 9876202838, 43, 'user6', 'user6', 6030.00, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 7', 9876534567, 52, 'user7', 'user7', 1570.44, 2, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 8', 2356343234, 18, 'user8', 'user8', 5630.05, 3, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 9', 2343675434, 23, 'user9', 'user9', 4543.50, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 10', 2145566576, 32, 'user10', 'user10', 6216.10, 2, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 11', 8799898789, 53, 'user11', 'user11', 4805.00, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 12', 78974654632, 25, 'user12', 'user12', 7582.00, 5, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 13', 6568655453, 45, 'user13', 'user13', 5820.40, 2, 1);

INSERT INTO user (name, document, age, username, password, salary, company_id, address_id)
VALUES ('Usuário 14', 53456798726, 29, 'user14', 'user14', 2850.97, 5, 1);