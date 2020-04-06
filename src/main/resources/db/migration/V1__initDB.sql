# CREATE SCHEMA dbconference DEFAULT CHARACTER SET utf8 ;

CREATE TABLE dbconference.conference (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) NOT NULL,
  TOPIC varchar(255) NOT NULL,
  DT_START DATE NOT NULL,
  DT_END  DATE NOT NULL,
  NUMBER_OF_PARTICIPANTS int(30) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO dbconference.conference (NAME, TOPIC, DT_START, DT_END, NUMBER_OF_PARTICIPANTS)
VALUES ('Startup Bootcamp 2020',
        'A startup bootcamp and crash course in business and entrepreneurship for the local and international startup community',
        '2020-09-18',
        '2020-09-23',
        '250');



