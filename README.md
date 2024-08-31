

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
Explicación:

Este proyecto está desarrollado con MVC
![image](https://github.com/user-attachments/assets/347987e9-b40e-4b5d-be01-4aef49264ed6)

En la Vista está solo esta pantalla que agrega pacientes con su nombre, edad y el doctor que lo atenderá
![image](https://github.com/user-attachments/assets/8448fecb-be97-4f92-b5a6-23493547169a)

Luego, en el Modelo, está la clase de conexión y las clases para las dos tablas que se utilizan
![image](https://github.com/user-attachments/assets/dd240da4-5c8f-4d7d-9abb-c90466c3cd2d)

Para la clase de la tabla Pacientes, tenemos los parametros, getters y setter y un método para guardar los pacientes con sus datos
![image](https://github.com/user-attachments/assets/a14c5550-5f20-4390-a7c3-8697f4912a16)
![image](https://github.com/user-attachments/assets/d9875a40-e959-4640-ac17-6c83fb7b4e42)

Y para la clase de la tabla Doctores, tenemos los parametros, getters y setters y el método para cargar el comboBox con el nombre de los doctores
![image](https://github.com/user-attachments/assets/b2b87ba0-2aba-48d3-9f47-3aad4115f1f0)
Como un paso extra, debemos crear dos constructores, uno vacio (para el metodo init) y uno que pida el nombre y el uuid (para llenar el comboBox)
![image](https://github.com/user-attachments/assets/41a5722a-afb7-4686-89e8-f75c0017b88f)
Luego, el método de cargarComboBox 
El cual usa el constructor que pide el nombre y el UUID 
![image](https://github.com/user-attachments/assets/bc941038-5dd0-42b7-8a2b-b93b25642179)

En el Controlador
![image](https://github.com/user-attachments/assets/1b31b7ad-7844-40c9-885d-372a1e42cc4a)
