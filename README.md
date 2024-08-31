

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
# Explicación:</br>

Este proyecto está desarrollado con MVC</br>
![image](https://github.com/user-attachments/assets/347987e9-b40e-4b5d-be01-4aef49264ed6)</br></br>

En la Vista está solo esta pantalla que agrega pacientes con su nombre, edad y el doctor que lo atenderá</br>
![image](https://github.com/user-attachments/assets/8448fecb-be97-4f92-b5a6-23493547169a)</br></br>

Luego, en el Modelo, está la clase de conexión y las clases para las dos tablas que se utilizan</br>
![image](https://github.com/user-attachments/assets/dd240da4-5c8f-4d7d-9abb-c90466c3cd2d)</br></br>

Para la clase de la tabla Pacientes, tenemos los parametros, getters y setter y un método para guardar los pacientes con sus datos</br>
![image](https://github.com/user-attachments/assets/a14c5550-5f20-4390-a7c3-8697f4912a16)</br>
![image](https://github.com/user-attachments/assets/d9875a40-e959-4640-ac17-6c83fb7b4e42)</br></br>

Y para la clase de la tabla Doctores, tenemos los parametros, getters y setters y el método para cargar el comboBox con el nombre de los doctores</br>
![image](https://github.com/user-attachments/assets/b2b87ba0-2aba-48d3-9f47-3aad4115f1f0)</br></br>
Como un paso extra, debemos crear dos constructores, uno vacio (para el metodo init) y uno que pida el nombre y el uuid (para llenar el comboBox) y un metodo que retorna el nombre en formato String</br>
![image](https://github.com/user-attachments/assets/c0db0df8-06ac-44f9-b35c-a01e2a312030)</br></br>

Luego, el método de cargarComboBox </br>
El cual usa el constructor que pide el nombre y el UUID </br>
![image](https://github.com/user-attachments/assets/bc941038-5dd0-42b7-8a2b-b93b25642179)
</br></br>
En el Controlador</br>
![image](https://github.com/user-attachments/assets/1b31b7ad-7844-40c9-885d-372a1e42cc4a)</br></br>

Y OJO con esto, en el constructor del Controlador, adicional a lo de siempre, debemos obtener el UUID del doctor al que le demos clic y guardarlo en el modelo con setUUID_Doctor, y eso lo hacemos con esto en el constructor:</br>
![image](https://github.com/user-attachments/assets/5524a92e-736b-42f9-8ec5-eee6fc28b8b6)</br></br>

y, al final, guardo al paciente, obteniendo el UUID del doctor seleccionado (el que guardamos con el paso anterior)</br>
![image](https://github.com/user-attachments/assets/55c7f7b7-02e0-4c11-bbd0-cd30ab9c7764)


