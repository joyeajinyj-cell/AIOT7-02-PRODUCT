ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER aloha IDENTIFIED BY 123456;
ALTER USER aloha DEFAULT TABLESPACE users;
ALTER USER aloha QUOTA UNLIMITED ON users;
GRANT DBA TO aloha;

/*
상품 번호 no
상품명 name
가격 pricd
설명 description
등록일자 created_at
수정일자 updated_at
*/
CREATE TABLE product(
    no NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    price int NOT NULL,
    description CLOB,
    created_at DATE DEFAULT sysdate,
    updated_at DATE DEFAULT sysdate

);

