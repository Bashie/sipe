CREATE TABLE TUTOR (
    HIJO_DNI BIGINT,
    DNI BIGINT(20) NOT NULL,
    PRIMARY KEY (DNI),
    CONSTRAINT FK_tutor_dni FOREIGN KEY (DNI) REFERENCES PERSONA(DNI)
);


CREATE TABLE TUTORPRACTICA (
	TUTOR_DNI BIGINT(20) NOT NULL,
	PRACTICA_ID INTEGER,
	PRIMARY KEY (TUTOR_DNI, PRACTICA_ID),
	CONSTRAINT FK_tutor_practica FOREIGN KEY (TUTOR_DNI) REFERENCES PERSONA(DNI),
	CONSTRAINT FK_ppractica_tutor FOREIGN KEY (PRACTICA_ID) REFERENCES PRACTICAPROFESIONAL(ID)
);