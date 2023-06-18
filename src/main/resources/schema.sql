CREATE TABLE country (
  code VARCHAR(15) PRIMARY KEY,
  name VARCHAR(100)
) AS SELECT admin0Pcode, admin0Name_en FROM CSVREAD('classpath:phl_admgz_adm0.csv');

CREATE TABLE region (
  code VARCHAR(15) PRIMARY KEY,
  name VARCHAR(100),
  alt_name VARCHAR(100),
  country_code VARCHAR(15),
  FOREIGN KEY (country_code) references country(code)
) AS SELECT admin1Pcode, admin1Name_en, admin1AltName1_en, admin0Pcode FROM CSVREAD('classpath:phl_admgz_adm1.csv');
