package modelo;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Doctores {
    
    private String UUID_Doctor;
    private String Nombre;
    private String Especialidad;

    public String getUUID_Doctor() {
        return UUID_Doctor;
    }

    public void setUUID_Doctor(String UUID_Doctor) {
        this.UUID_Doctor = UUID_Doctor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    //Extras para el ComboBox
    public Doctores(){
        
    }
    
    public Doctores(String uuid, String nombre)
    {
        this.UUID_Doctor = uuid;
        this.Nombre = nombre;
    }
    
      @Override
    public String toString()
    {
        return Nombre;
    }
    
    
    //Metodo para cargar los valores en el ComboBox
    public void CargarComboDoctores(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from tbDoctores");
            while (rs.next()) {
                String uuid = rs.getString("UUID_Doctor");
                String nombre = rs.getString("Nombre_doctor");
                comboBox.addItem(new Doctores(uuid,nombre));                
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
    }
    
}
