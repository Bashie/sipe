CREATE TABLE PROFESIONAL (
    AREADESARROLLO VARCHAR(255),
    DNI INTEGER NOT NULL,
    PRIMARY KEY (PERSONA_DNI),
    CONSTRAINT FK_profesional_dni FOREIGN KEY (DNI) REFERENCES PERSONA(DNI)
);
