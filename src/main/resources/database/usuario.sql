CREATE TABLE USUARIO (
    ENCRYPTEDPASSWORD VARCHAR(50),
    PERSONA BIGINT(20) NOT NULL,
    ADMIN TINYINT(1),
    PRIMARY KEY (PERSONA),
    CONSTRAINT FK_usuario_dni FOREIGN KEY (PERSONA) REFERENCES PERSONA(DNI)
);

