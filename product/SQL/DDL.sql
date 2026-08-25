/*
    상품번호
    상품명
    가격
    설명
    등록일자
    수정일자
*/
CREATE TABLE product (
    no          NUMBER PRIMARY KEY,
    name        VARCHAR2(100) NOT NULL,
    price       NUMBER NOT NULL DEFAULT 0 ,
    description CLOB,
    created_at  DATE NOT NULL DEFAULT SYSDATE,
    updated_at  DATE NOT NULL DEFAULT SYSDATE 
);

-- 시퀀스
CREATE SEQUENCE PRODUCT_SEQ 
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
