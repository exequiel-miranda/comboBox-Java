

Script utilizado:
```SQL
CREATE TABLE tbDoctores(
    UUID_Doctor VARCHAR2(100) primary key,
    Nombre_Doctor VARCHAR2(50),
    Especialidad VARCHAR2(50)
);

INSERT INTO tbDoctores VALUES(SYS_GUID(), 'Daniel', 'Ortopeda');
INSERT INTO tbDoctores VALUES(SYS_GUID(), 'Carlos', 'Pediatra');
INSERT INTO tbDoctores VALUES(SYS_GUID(), 'Bryan', 'Psicologo');
INSERT INTO tbDoctores VALUES(SYS_GUID(), 'Maria', 'Medico General');
INSERT INTO tbDoctores VALUES(SYS_GUID(), 'Juan', 'Padiatra');



CREATE TABLE tbPacientes(
    UUID_Paciente VARCHAR2(100) primary key,
    Nombre_Paciente VARCHAR2(50),
    Edad int,
    UUID_Doctor VARCHAR2(100),    
    CONSTRAINT fk_doctor_paciente FOREIGN KEY (UUID_Doctor) REFERENCES tbDoctores(UUID_Doctor)
);

COMMIT;
```
