CREATE TABLE talk(
       ID            bigint(20)   NOT NULL AUTO_INCREMENT,
       NAME          varchar(255) NOT NULL,
       DESCRIPTION   varchar(255) NOT NULL,
       SPEAKER_NAME  varchar(255) NOT NULL,
       TYPE_TALK     varchar(30)  NOT NULL,
       DT_APPLY      DATE         NOT NULL,
       CONFERENCE_ID bigint(20)   NOT NULL ,
       PRIMARY KEY (ID),
       KEY fk_talk_conference_id (CONFERENCE_ID),
       CONSTRAINT fk_talk_conference_id FOREIGN KEY (CONFERENCE_ID)
       REFERENCES conference(ID) ON DELETE CASCADE ON UPDATE NO ACTION,
       UNIQUE INDEX uk_talk_name_conference_id (NAME ASC, CONFERENCE_ID ASC)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;