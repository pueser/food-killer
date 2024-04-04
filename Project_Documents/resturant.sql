CREATE TABLE member(
    nickName VARCHAR2 (30) UNIQUE,
    email VARCHAR2 (50) CONSTRAINT member_email_pk PRIMARY KEY,
    pwd VARCHAR2 (45) NOT NULL,
    memberState VARCHAR2(10) NOT NULL,
    T1 VARCHAR2(2) DEFAULT 'N',
    T2 VARCHAR2(2) DEFAULT 'N',
    T3 VARCHAR2(2) DEFAULT 'N',
    termsAgree VARCHAR2(1) DEFAULT 'N',
    termsDate DATE DEFAULT sysdate,
    regdate TIMESTAMP DEFAULT sysdate,
    updatedate TIMESTAMP DEFAULT sysdate,
    widthdrawalAgree VARCHAR2(1) DEFAULT NULL,
    widthdrawalDate TIMESTAMP DEFAULT NULL
);

CREATE TABLE memberAttach (
    uuid VARCHAR2(100) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    email VARCHAR2 (50),
    CONSTRAINT memberAttach_email_fK FOREIGN KEY(email) REFERENCES member(email),
    CONSTRAINT memberAttach_email_PK PRIMARY KEY (email)
);

CREATE TABLE restaurant (
    restId VARCHAR2 (12) CONSTRAINT restaruant_restId_pk PRIMARY KEY,
    fcltyNm VARCHAR2 (200) NOT NULL,
    ctgryTwoNm VARCHAR2 (200) NOT NULL,
    ctgryThreeNm VARCHAR2(200) NOT NULL,
    legaldongNm VARCHAR2 (200) DEFAULT 'no legaldong',
    lnbrNo VARCHAR2 (20) DEFAULT 'no lnbr',
    lcLa VARCHAR2 (20) NOT NULL,
    lcLo VARCHAR2 (20) NOT NULL,
    rdnmadrNm VARCHAR2 (200) DEFAULT 'no rdnmadr',
    lnmAddr VARCHAR2 (200) DEFAULT 'no lnm',
    telNo VARCHAR2 (50) DEFAULT 'no tel',
    workdayOperTimeDc VARCHAR2 (1000) DEFAULT 'no workday',
    wkendOperTimeDc VARCHAR2 (500) DEFAULT 'no wkend',
    freParkngAt VARCHAR2 (50) NOT NULL,
    valetParkngPosblAt VARCHAR2 (50) NOT NULL,
    infnChairLendPosblAt VARCHAR2 (50) NOT NULL,
    wchairHoldAt VARCHAR2 (50) NOT NULL,
    petPosblAt VARCHAR2 (50) NOT NULL,
    vgtrMenuHoldAt VARCHAR2 (50) NOT NULL,
    chosung VARCHAR2 (1000) NOT NULL
);

CREATE TABLE restaurantImg(
    restUuid VARCHAR2(100) PRIMARY KEY,
	restFileName VARCHAR2(100) NOT NULL,
    restId VARCHAR2 (12) NOT NULL,
	CONSTRAINT restaurantImg_restId_fK FOREIGN KEY(restId) REFERENCES restaurant(restId)
);

CREATE SEQUENCE rest_seq
    INCREMENT BY 1
    START WITH 1
    NOMINVALUE 
    NOMAXVALUE 
    NOCYCLE
    NOCACHE;
    


--PL/SQL 함수(식당과 현재 위도경도에 따른 거리 계산하는 함수)
create or replace FUNCTION DISTNACE_WGS84( H_LAT IN NUMBER, H_LNG IN NUMBER, T_LAT IN NUMBER, T_LNG IN NUMBER)
RETURN NUMBER DETERMINISTIC 
IS
BEGIN
  RETURN (
        6371.0 * ACOS(  
          COS( RADIANS( H_LAT ) ) * COS( RADIANS( T_LAT /* 위도 */ ) )
          * COS( RADIANS( T_LNG /* 경도 */ ) - RADIANS( H_LNG ) )
          +
          SIN( RADIANS( H_LAT ) ) * SIN( RADIANS( T_LAT /* 위도 */ ) )        
         ));
end DISTNACE_WGS84;


--PL/SQL 함수(초성추출하는 함수)
create or replace function fn_choSearch( str in varchar2) return varchar2 
is 
   returnStr varchar2(100);  
   cnt number := 0;  
   tmpStr varchar2(10); 
begin  
      if str is null then 
      return ''; 
      end if;  

      cnt := length(str);  

      for i in 1 .. cnt 
      loop 
        tmpStr := substr(str,i,1);        
      returnStr := returnStr || 
      case when tmpStr < 'ㄱ' then substr(tmpStr, 1, 1) 
            when ascii('ㄱ') <= ascii(tmpStr) and ascii(tmpStr) <= ascii('ㅎ') then chr(ascii(tmpStr)) 
            when tmpStr < '나' then 'ㄱ' 
            when tmpStr < '다' then 'ㄴ' 
            when tmpStr < '라' then 'ㄷ' 
            when tmpStr < '마' then 'ㄹ' 
            when tmpStr < '바' then 'ㅁ' 
            when tmpStr < '사' then 'ㅂ' 
            when tmpStr < '아' then 'ㅅ' 
            when tmpStr < '자' then 'ㅇ' 
            when tmpStr < '차' then 'ㅈ' 
            when tmpStr < '카' then 'ㅊ' 
            when tmpStr < '타' then 'ㅋ' 
            when tmpStr < '파' then 'ㅌ' 
            when tmpStr < '하' then 'ㅍ' 
            else 'ㅎ' 
      end;  
      end loop; 
      return returnStr; 
end; 