package org.example.interfaz.ventanas;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Connection.MyConnectionManager;
import org.example.DAOs.MiembroDAO;
import org.example.modelo.Miembro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MiembroController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField tipoMiembroField;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextField handicapField;

    @FXML
    private TextField fechaIngresoField;

    @FXML
    private TextField coachField;

    @FXML
    private TextField equipoField;

    @FXML
    private TextField generoField;

    @FXML
    private void crearMiembro() {
        // Obtener los valores de los campos
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String tipoMiembro = tipoMiembroField.getText();
        String telefono = telefonoField.getText();
        Integer handicap = Integer.parseInt(handicapField.getText());
        Date fechaIngreso = parseFecha(fechaIngresoField.getText());
        Integer coach = Integer.parseInt(coachField.getText());
        String equipo = equipoField.getText();
        String genero = generoField.getText();

        // Crear una nueva instancia de Miembro
        Miembro nuevoMiembro = new Miembro();
        nuevoMiembro.setNombre(nombre);
        nuevoMiembro.setApellido(apellido);
        nuevoMiembro.setTipoMiembro(tipoMiembro);
        nuevoMiembro.setTelefono(telefono);
        nuevoMiembro.setHandicap(handicap);
        nuevoMiembro.setFechaIngreso(fechaIngreso);
        nuevoMiembro.setCoach(coach);
        nuevoMiembro.setEquipo(equipo);
        nuevoMiembro.setGenero(genero);

        // Guardar el nuevo miembro en la base de datos
        EntityManager entityManager = MyConnectionManager.getInstance().getManager();
        MiembroDAO miembroDAO = new MiembroDAO(entityManager);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            miembroDAO.save(nuevoMiembro);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        // Limpiar los campos después de crear el miembro
        limpiarCampos();
    }

    // Método para convertir una cadena de texto a un objeto Date
    private Date parseFecha(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para limpiar los campos después de crear el miembro
    private void limpiarCampos() {
        nombreField.clear();
        apellidoField.clear();
        tipoMiembroField.clear();
        telefonoField.clear();
        handicapField.clear();
        fechaIngresoField.clear();
        coachField.clear();
        equipoField.clear();
        generoField.clear();
    }
}
