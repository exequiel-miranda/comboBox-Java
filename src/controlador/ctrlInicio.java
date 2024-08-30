package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Doctores;
import modelo.Pacientes;
import vista.frmInicio;

public class ctrlInicio implements MouseListener {

    private frmInicio Vista;
    private Doctores ModeloDoc;
    private Pacientes ModeloPacientes;

    public ctrlInicio(frmInicio vista, Doctores modeloDoc, Pacientes modeloPacientes) {
        this.Vista = vista;
        this.ModeloDoc = modeloDoc;
        this.ModeloPacientes = modeloPacientes;

        this.Vista.cbDoctores.addMouseListener(this);
        this.ModeloDoc.CargarComboDoctores(Vista.cbDoctores);
        this.Vista.btnAgregar.addMouseListener(this);

        //Obtener el UUID del doctor seleccionado
        Vista.cbDoctores.addActionListener(e -> {
            if (e.getSource() == Vista.cbDoctores) {
                Doctores selectedItem = (Doctores) Vista.cbDoctores.getSelectedItem();
                if (selectedItem != null) {
                    String UUID = selectedItem.getUUID_Doctor();
                    ModeloDoc.setUUID_Doctor(UUID);
                }
            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Vista.btnAgregar) {
            ModeloPacientes.setNombre_paciente(Vista.txtNombre.getText());
            ModeloPacientes.setEdad(Integer.parseInt(Vista.txtEdad.getText()));
            ModeloPacientes.setUUID_Doctor(ModeloDoc.getUUID_Doctor());
            ModeloPacientes.Guardar();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
