CREATE TABLE SESION (
	ID INTEGER NOT NULL AUTO_INCREMENT,
    START TIMESTAMP,
    END TIMESTAMP,
    NOTAS VARCHAR(255),
    PRACTICAPROFESIONAL INTEGER,
    PRIMARY KEY (ID),
    CONSTRAINT FK_practica_sesion FOREIGN KEY (PRACTICAPROFESIONAL) REFERENCES PRACTICAPROFESIONAL(ID)
);

