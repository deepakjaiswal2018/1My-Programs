--1
CREATE TABLE ACTOR(
ACTID NUMBER(3),
ACTNAME VARCHAR(20),
ACTGENDER CHAR(1),
PRIMARY KEY (ACTID));

DESC ACTOR;

--2
CREATE TABLE DIRECTOR(
DIRID NUMBER(3),
DIRNAME VARCHAR(20),
DIRPHONE NUMBER(10),
PRIMARY KEY (DIRID));

DESC DIRECTOR;

--3
CREATE TABLE MOVIES(
MOVID NUMBER(4),
MOVTITLE VARCHAR(25),
MOVYEAR NUMBER(4),
MOVLANG VARCHAR(12),
DIRID NUMBER(3),
PRIMARY KEY (MOVID),
FOREIGN KEY (DIRID) REFERENCES DIRECTOR(DIRID));

DESC MOVIES;


--4
CREATE TABLE MOVIECAST(
ACTID NUMBER(3),
MOVID NUMBER(4),
ROLE VARCHAR(10),
PRIMARY KEY (ACTID,MOVID),
FOREIGN KEY (ACTID) REFERENCES ACTOR(ACTID),
FOREIGN KEY (MOVID) REFERENCES MOVIES(MOVID));

DESC MOVIECAST;

--5
CREATE TABLE RATING(
MOVID NUMBER(3),
REVSTARS VARCHAR(25),
PRIMARY KEY(MOVID),
FOREIGN KEY (MOVID) REFERENCES MOVIES(MOVID));

DESC RATING;

--1
INSERT INTO ACTOR VALUES(301,'ANUSHKA','F');
INSERT INTO ACTOR VALUES(302,'PRABHAS','M');
INSERT INTO ACTOR VALUES(303,'PUNITH','M');
INSERT INTO ACTOR VALUES(304,'SUDEEP','M');

SELECT * FROM ACTOR;

--2
INSERT INTO DIRECTOR VALUES(60,'RAJAMOULI',9191919191);
INSERT INTO DIRECTOR VALUES(61,'HITCHCOCK',818181818);
INSERT INTO DIRECTOR VALUES(62,'FARAN',7171717171);
INSERT INTO DIRECTOR VALUES(63,'STEVEN SPIELBERG',6161616161);

SELECT * FROM DIRECTOR;

--3
INSERT INTO MOVIES VALUES(1001,'BAHUBALI-2',2017,'TELUGU',60);
INSERT INTO MOVIES VALUES(1002,'BAHUBALI-1',2015,'TELUGU',60);
INSERT INTO MOVIES VALUES(1003,'AKASH',2008,'KANADA',61);
INSERT INTO MOVIES VALUES(1004,'WAR HORSE',2011,'ENGLISH',63);

SELECT * FROM MOVIES;

--4
INSERT INTO MOVIECAST VALUES(301,1002,'HEROINE');
INSERT INTO MOVIECAST VALUES(301,1001,'HEROINE');
INSERT INTO MOVIECAST VALUES(303,1003,'HERO');
INSERT INTO MOVIECAST VALUES(303,1002,'GUEST');
INSERT INTO MOVIECAST VALUES(304,1004,'HERO');

SELECT * FROM MOVIECAST;

--5
INSERT INTO RATING VALUES(1001,4);
INSERT INTO RATING VALUES(1002,2);
INSERT INTO RATING VALUES(1003,5);
INSERT INTO RATING VALUES(1004,4);

SELECT * FROM RATING;


--QUERIES

-- QUERY 1

SELECT MOVTITLE
FROM MOVIES
WHERE DIRID IN (SELECT DIRID
FROM DIRECTOR
WHERE DIRNAME='HITCHCOCK');

-- QUERY 2

SELECT MOVTITLE
FROM MOVIES M,MOVIECAST MV
WHERE M.MOVID=MV.MOVID AND ACTID IN (SELECT ACTID
FROM MOVIECAST GROUP BY ACTID
HAVING COUNT (ACTID)>1)
GROUP BY MOVTITLE
HAVING COUNT(*)>1;

-- QUERY 3

SELECT ACTNAME,MOVTITLE,MOVYEAR
FROM ACTOR A
JOIN MOVIECAST C
ON A.ACTID=C.ACTID
JOIN MOVIES M
ON C.MOVID=M.MOVID
WHERE M.MOVYEAR NOT BETWEEN 2000 AND 2015;

--(OR)

SELECT A.ACTNAME,C.MOVTITLE,C.MOVYEAR
FROM ACTOR A,MOVIECAST B,MOVIES C
WHERE A.ACTID=B.ACTID
AND B.MOVID=C.MOVID
AND C.MOVYEAR NOT BETWEEN 2000 AND 2005;

-- QUERY 4

SELECT MOVTITLE,MAX(REVSTARS)
FROM MOVIES
INNER JOIN RATING USING (MOVID)
GROUP BY MOVTITLE
HAVING MAX (REVSTARS)>0
ORDER BY MOVTITLE;

-- QUERY 5

UPDATE RATING
SET REVSTARS=5
WHERE MOVID IN (SELECT MOVID FROM MOVIES
WHERE DIRID IN (SELECT DIRID
FROM DIRECTOR
WHERE DIRNAME='STEVEN SPIELBERG'));

SELECT * FROM RATING;