package modelo;

import java.sql.*;
import java.util.UUID;

public class Pacientes {

    //1-Parametros
    private String UUID_Pacientes;
    private String Nombre_paciente;
    private int Edad;
    private String UUID_Doctor;

    //2- Getteres y Setters
    public String getUUID_Pacientes() {
        return UUID_Pacientes;
    }

    public void setUUID_Pacientes(String UUID_Pacientes) {
        this.UUID_Pacientes = UUID_Pacientes;
    }

    public String getNombre_paciente() {
        return Nombre_paciente;
    }

    public void setNombre_paciente(String Nombre_paciente) {
        this.Nombre_paciente = Nombre_paciente;
    }

    public String getUUID_Doctor() {
        return UUID_Doctor;
    }

    public void setUUID_Doctor(String UUID_Doctor) {
        this.UUID_Doctor = UUID_Doctor;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    //3- Metodos
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addpaciente = conexion.prepareStatement("INSERT INTO tbPacientes(UUID_Paciente, Nombre_paciente, Edad, UUID_Doctor) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addpaciente.setString(1, UUID.randomUUID().toString());
            addpaciente.setString(2, getNombre_paciente());
            addpaciente.setInt(3, getEdad());
            addpaciente.setString(4, getUUID_Doctor());

            //Ejecutar la consulta
            addpaciente.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

}
