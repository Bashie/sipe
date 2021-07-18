CREATE TABLE PRACTICAPROFESIONAL (
	ID INTEGER NOT NULL AUTO_INCREMENT,
    DAYOFWEEK INTEGER,
    STARTTIME TIME,
    ENDTIME TIME,
    TUTOR_DNI BIGINT(20) NOT NULL,
    PROFESIONAL_DNI BIGINT(20) NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_practica_profesional FOREIGN KEY (PROFESIONAL_DNI) REFERENCES PERSONA(DNI)
);