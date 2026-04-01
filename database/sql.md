## 表

### LY_ORDER_INFO

~~~sql
CREATE TABLE HR.LY_ORDER_INFO(
	ORDER_SERIAL VARCHAR2(64),
	ORDER_AMT DECIMAL(12,2),
	ORDER_RCV_NO VARCHAR2(64),
	PRIMARY key(ORDER_SERIAL)
)
~~~

### LY_EMPLOYEE_INFO

~~~sql
CREATE TABLE HR.LY_EMPLOYEE_INFO AS SELECT * FROM EMPLOYEES;
ALTER TABLE HR.LY_EMPLOYEE_INFO ADD CONSTRAINT PK_EMPLOYEEID PRIMARY KEY(EMPLOYEE_ID);
~~~

### 查看所有表

~~~sql
SELECT * FROM ALL_TABLES WHERE TABLE_NAME = 'LY_EMPLOYEE_INFO';
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'LY_EMPLOYEE_INFO';
~~~

## 序列

~~~sql
--创建序列: 从1到999999999999，步长为1，缓存40，不保证序列值有序
CREATE SEQUENCE HR.LY_SEQ INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999999999 CYCLE CACHE 40 NOORDER 
~~~

## 存储过程

### 创建序列优化

增加并发创建异常处理 todo

~~~sql

~~~

### 创建序列

这版有缺陷，并发创建时有几率报错

~~~sql
CREATE OR REPLACE PROCEDURE HR.ADD_SEQ( SEQ_NAME IN VARCHAR2, SEQ_NUM OUT NUMBER, MSG OUT VARCHAR2) IS
    selectSqlStr VARCHAR2(1024);
    createSqlStr VARCHAR2(1024);
    seqName VARCHAR2(128);
BEGIN
    MSG := '';
    seqName := SEQ_NAME;
    selectSqlStr := 'select ' || seqName || '.nextval from dual';
    EXECUTE IMMEDIATE selectSqlStr INTO SEQ_NUM;

EXCEPTION WHEN OTHERS THEN
    MSG := 'call ADD_SEQ error selectSqlStr=' || selectSqlStr || ', SQLCODE=' || SQLCODE() || ', sqlerrm=' || sqlerrm(SQLCODE());
    IF SQLCODE() = -2289 THEN
        BEGIN
            createSqlStr := 'CREATE SEQUENCE ' || seqName || ' START WITH 1 INCREMENT BY 1 CACHE 20 MINVALUE 1 MAXVALUE 33554432 CYCLE NOORDER';
            MSG := MSG || ',seq no exists do create ' || createSqlStr;
            EXECUTE IMMEDIATE createSqlStr;
            EXECUTE IMMEDIATE selectSqlStr INTO SEQ_NUM;
            --createSqlStr := 'grant all on ' || seqName || ' to HR'; 授权操作，这里简化不需要
            --EXECUTE IMMEDIATE createSqlStr;
        END;
    END IF;
END ADD_SEQ;
~~~