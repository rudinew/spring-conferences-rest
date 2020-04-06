ALTER TABLE dbconference.talk
 ADD UNIQUE INDEX uk_name_conference (NAME ASC, CONFERENCE_ID ASC);
