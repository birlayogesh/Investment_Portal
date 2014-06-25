CREATE TABLE USERINFO
 (userId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1, NO CACHE),
firstname varchar(20),lastname varchar(20),address varchar(30),emailId varchar(30),panNum varchar(30)
);

CREATE TABLE LOGINUSER
 (userId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 500, INCREMENT BY 1, NO CACHE),
folio varchar(20),pin varchar(20)
);

CREATE TABLE STOCKCOMPANYINFO
 (cId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 500, INCREMENT BY 1, NO CACHE),
name varchar(35),sector varchar(35),bse_code varchar(35),nse_code varchar(35)
);

CREATE TABLE USER_PMT_INFO
 (uId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 500, INCREMENT BY 1, NO CACHE),
card_number varchar(35),card_holder varchar(35),cvv_number varchar(35),balance_amount varchar(35)
);

CREATE TABLE TRANSACTION_INFO
 (tId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 500, INCREMENT BY 1, NO CACHE),
folioId varchar(35),date varchar(35),company_name varchar(35),quantity varchar(35),
realTimeValue varchar(35),total_amount varchar(35),action varchar(35)
);