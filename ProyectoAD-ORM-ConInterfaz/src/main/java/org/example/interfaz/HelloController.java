package org.example.interfaz;

import jakarta.persistence.EntityManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.example.Connection.MyConnectionManager;
import org.example.DAOs.*;
import org.example.modelo.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class HelloController {



    @FXML
    private VBox Pane;
    @FXML
    private MenuItem about;
    @FXML
    private MenuItem close;
    @FXML
    public MenuItem crearTipo;
    @FXML
    public MenuItem crearMiembro;
    @FXML
    public MenuItem crearInscripcion;
    @FXML
    public MenuItem crearEquipo;
    @FXML
    public MenuItem crearTorneo;
    @FXML
    public MenuItem editarTipo;
    @FXML
    public MenuItem editarMiembro;
    @FXML
    public MenuItem editarInscripcion;
    @FXML
    public MenuItem editarEquipo;
    @FXML
    public MenuItem editarTorneo;
    @FXML
    public MenuItem eliminarTipo;
    @FXML
    public MenuItem eliminarMiembro;
    @FXML
    public MenuItem eliminarInscripcion;
    @FXML
    public MenuItem eliminarEquipo;
    @FXML
    public MenuItem eliminarTorneo;

    @FXML
    private Label memberID;

    @FXML
    private Label memberNombre;

    @FXML
    private Label memberApellido;

    @FXML
    private Label memberTelefono;

    @FXML
    private Label memberDestreza;

    @FXML
    private Label memberIngreso;

    @FXML
    private Label memberGenero;

    @FXML
    private Label memberEntrenador;

    @FXML
    private Label tourID;
    @FXML
    private Label tourName;
    @FXML
    private Label tourType;


    @FXML
    private Label equipoNombre;

    @FXML
    private Label equipoNochePractica;

    @FXML
    private Label equipoGerente;


    @FXML
    private ListView<String> tournamentList;
    @FXML
    private ListView<String> memberList;

    private List<Torneo> torneos;
    private List<Tipo> tipos;
    private List<Miembro> miembros;
    private List<Inscripcion> inscripcions;
    private List<Equipo> equipos;

    public void initialize(){
        EntityManager entityManager = MyConnectionManager.getInstance().getManager();
        TorneoDAO torneoDao = new TorneoDAO(entityManager);
        TipoDAO tipoDao = new TipoDAO(entityManager);
        MiembroDAO miembroDao = new MiembroDAO(entityManager);
        InscripcionDAO inscripcionDao = new InscripcionDAO(entityManager);
        EquipoDAO equipoDao = new EquipoDAO(entityManager);

        close.setOnAction(event -> System.exit(0));
        about.setOnAction(event -> abrirURL());

        crearMiembro.setOnAction(event -> crearMiembroDesdeConsola());
        crearTorneo.setOnAction(event -> crearTorneoDesdeConsola());
        crearTipo.setOnAction(event -> crearTipoDesdeConsola());
        crearInscripcion.setOnAction(event -> crearInscripcionDesdeConsola());
        crearEquipo.setOnAction(event -> crearEquipoDesdeConsola());

        eliminarMiembro.setOnAction(event -> eliminarMiembroDesdeConsola());
        eliminarTorneo.setOnAction(event -> eliminarTorneoDesdeConsola());
        eliminarTipo.setOnAction(event -> eliminarTipoDesdeConsola());
        eliminarInscripcion.setOnAction(event -> eliminarInscripcionDesdeConsola());
        eliminarEquipo.setOnAction(event -> eliminarEquipoDesdeConsola());

        editarEquipo.setOnAction(event -> editarEquipoDesdeConsola());
        editarInscripcion.setOnAction(event -> editarInscripcionDesdeConsola());
        editarMiembro.setOnAction(event -> editarMiembroDesdeConsola());
        editarTorneo.setOnAction(event -> editarTorneoDesdeConsola());
        editarTipo.setOnAction(event -> editarTipoDesdeConsola());

        torneos = torneoDao.findAll();
        tipos = tipoDao.findAll();
        miembros = miembroDao.findAll();
        inscripcions = inscripcionDao.findAll();
        equipos = equipoDao.findAll();
        System.out.println("Tipos:");
        for (Tipo tipo : tipos) {
            System.out.println(tipo);
        }

        for (Torneo torneo : torneos) {
            tournamentList.getItems().add(torneo.getNombreTorneo());
        }
        tournamentList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                        }
                    }
                };
            }

        });

        tournamentList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                // Buscar el torneo seleccionado en la lista de torneos
                Optional<Torneo> torneoSeleccionado = torneos.stream()
                        .filter(torneo -> torneo.getNombreTorneo().equals(newValue))
                        .findFirst();

                // Verificar si se encontró el torneo y actualizar las etiquetas
                torneoSeleccionado.ifPresent(torneo -> {
                    tourID.setText(String.valueOf(torneo.getIdTorneo()));
                    tourName.setText(torneo.getNombreTorneo());
                    tourType.setText(torneo.getTipoTorneo());
                });
            }

            memberList.getItems().clear();
            // Obtener el torneo seleccionado
            if(tournamentList.getSelectionModel().getSelectedIndex() == -1) {
                tournamentList.getSelectionModel().selectFirst();
            }
            Torneo selectedTournament = torneos.get(tournamentList.getSelectionModel().getSelectedIndex());

            // Filtrar inscripciones por el torneo seleccionado
            List<Inscripcion> tournamentInscriptions = inscripcions.stream()
                    .filter(inscripcion -> inscripcion.getIdTorneo() == selectedTournament.getIdTorneo())
                    .toList();

            // Utilizar un conjunto para almacenar miembros únicos
            Set<Miembro> uniqueMembers = new HashSet<>();

            // Obtener los miembros asociados a las inscripciones encontradas
            for (Inscripcion inscripcion : tournamentInscriptions) {
                miembros.stream()
                        .filter(m -> m.getIdMiembro() == inscripcion.getIdMiembro())
                        .findFirst()
                        .ifPresent(uniqueMembers::add);
            }

            // Agregar los miembros únicos a memberList
            for (Miembro uniqueMember : uniqueMembers) {
                memberList.getItems().add(uniqueMember.getNombre() + " " + uniqueMember.getApellido());
            }
        });
        memberList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Obtener el Miembro seleccionado
                Miembro miembroSeleccionado = obtenerMiembroPorNombre(newValue);

                // Llamar a la función mostrarDatosMiembro con el Miembro seleccionado
                mostrarDatosMiembro(miembroSeleccionado);

                if (miembroSeleccionado != null) {
                    // Buscar el equipo del miembro
                    Optional<Equipo> equipoDelMiembro = equipos.stream()
                            .filter(equipo -> equipo.getNombreEquipo().equals(miembroSeleccionado.getEquipo()))
                            .findFirst();

                    // Actualizar las etiquetas del equipo
                    equipoDelMiembro.ifPresentOrElse(
                            equipo -> {
                                equipoNombre.setText(equipo.getNombreEquipo());
                                equipoNochePractica.setText(equipo.getNochePractica());

                                // Obtener el gerente del equipo si el campo 'manager' no es nulo
                                Integer idGerente = equipo.getManager();
                                if (idGerente != null) {
                                    Optional<Miembro> gerenteEquipo = miembros.stream()
                                            .filter(m -> m.getIdMiembro() == idGerente)
                                            .findFirst();
                                    equipoGerente.setText(gerenteEquipo.map(gerente -> gerente.getNombre() + " " + gerente.getApellido()).orElse("N/A"));
                                } else {
                                    equipoGerente.setText("N/A");
                                }
                            },
                            () -> {
                                // Establecer "N/A" en todas las etiquetas si no se encuentra el equipo
                                equipoNombre.setText("N/A");
                                equipoNochePractica.setText("N/A");
                                equipoGerente.setText("N/A");
                            }
                    );
                }
            }
        });
        ContextMenu contextMenu = new ContextMenu();
        MenuItem eliminarMenuItem = new MenuItem("Eliminar");
        // Configurar el evento para eliminar un elemento al hacer clic en "Eliminar"
        memberList.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                Miembro selectedMiembro = obtenerMiembroPorNombre(memberList.getSelectionModel().getSelectedItem());

                if (selectedMiembro != null) {
                    // Configurar la acción de eliminación
                    eliminarMenuItem.setOnAction(e -> {
                        // Eliminar el miembro de la lista
                        memberList.getItems().remove(selectedMiembro.getNombre());

                        // Eliminar el miembro de la base de datos
                        MiembroDAO miembroDAO = new MiembroDAO(entityManager);
                        miembroDAO.delete(selectedMiembro);
                        miembros.remove(selectedMiembro);
                        actualizar();
                    });

                    // Limpiar y agregar las opciones al menú contextual
                    contextMenu.getItems().clear();
                    contextMenu.getItems().addAll(eliminarMenuItem);

                    // Mostrar el menú en la posición del ratón
                    contextMenu.show(memberList, event.getScreenX(), event.getScreenY());
                }
            }
        });


        ContextMenu contextMenuTorneo = new ContextMenu();
        MenuItem eliminarMenuItemTorneo = new MenuItem("Eliminar");
        tournamentList.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                Torneo selectedTorneo = obtenerTorneoPorNombre(tournamentList.getSelectionModel().getSelectedItem());

                if (selectedTorneo != null) {
                    // Configurar la acción de eliminación para Torneo
                    eliminarMenuItemTorneo.setOnAction(e -> {
                        // Eliminar el Torneo de la lista
                        tournamentList.getItems().remove(selectedTorneo.getNombreTorneo());

                        // Eliminar el Torneo de la base de datos
                        TorneoDAO torneoDAO = new TorneoDAO(entityManager);
                        torneoDAO.delete(selectedTorneo);
                        torneos.remove(selectedTorneo);
                        actualizar();
                    });

                    // Limpiar y agregar las opciones al menú contextual para Torneo
                    contextMenuTorneo.getItems().clear();
                    contextMenuTorneo.getItems().addAll(eliminarMenuItemTorneo);

                    // Mostrar el menú en la posición del ratón para Torneo
                    contextMenuTorneo.show(tournamentList, event.getScreenX(), event.getScreenY());
                }
            }
        });

    }

    private void mostrarDatosMiembro(Miembro miembro) {
        memberID.setText(String.valueOf(miembro.getIdMiembro()));
        memberNombre.setText(miembro.getNombre());
        memberApellido.setText(miembro.getApellido());
        memberTelefono.setText(miembro.getTelefono());
        memberDestreza.setText(String.valueOf(miembro.getHandicap()));
        memberIngreso.setText(String.valueOf(miembro.getFechaIngreso()));
        memberGenero.setText(miembro.getGenero());
        if (miembro.getCoach() != null) {
            Optional<Miembro> entrenadorOptional = miembros.stream()
                    .filter(entrenador -> entrenador.getIdMiembro() == miembro.getCoach())
                    .findFirst();
            memberEntrenador.setText(entrenadorOptional.map(entrenador -> entrenador.getNombre()).orElse("N/A"));
        } else {
            memberEntrenador.setText("N/A");
        }
    }
    private Miembro obtenerMiembroPorNombre(String nombreCompleto) {
        for (Miembro miembro : miembros) {
            // Combina el nombre y apellido del miembro para comparar con el nombre seleccionado
            String nombreApellido = miembro.getNombre() + " " + miembro.getApellido();

            if (nombreApellido.equals(nombreCompleto)) {
                return miembro;
            }
        }
        return null; // Retorna null si no se encuentra el miembro
    }
    private Torneo obtenerTorneoPorNombre(String nombre) {
        for (Torneo torneo : torneos) {
            if (torneo.getNombreTorneo().equals(nombre)) {
                return torneo;
            }
        }
        return null;
    }

    public void abrirDialogo(String fxml) {
        Dialog<ButtonType> dialog = new Dialog<>();
// por defecto, un diálogo é modal
// polo que non permitirá interaccionar con outras ventá
        dialog.initOwner(Pane.getScene().getWindow());
// engade o código para establecer o título “Engadir nova tarefa” ao diálogo
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Non se puido cargar o diálogo");
            e.printStackTrace();
            return;
        }
// engadir os botóns
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }

    private void actualizar() {
        EntityManager entityManager = MyConnectionManager.getInstance().getManager();
        TorneoDAO torneoDao = new TorneoDAO(entityManager);
        TipoDAO tipoDao = new TipoDAO(entityManager);
        MiembroDAO miembroDao = new MiembroDAO(entityManager);
        InscripcionDAO inscripcionDao = new InscripcionDAO(entityManager);
        EquipoDAO equipoDao = new EquipoDAO(entityManager);

        torneos = torneoDao.findAll();
        tipos = tipoDao.findAll();
        miembros = miembroDao.findAll();
        inscripcions = inscripcionDao.findAll();
        equipos = equipoDao.findAll();

        tournamentList.getItems().clear();
        for (Torneo torneo : torneos) {
            tournamentList.getItems().add(torneo.getNombreTorneo());
        }
        tournamentList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                        }
                    }
                };
            }

        });
    }


    private static Date parseFecha(String fechaStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void crearTorneoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del Torneo:");
        System.out.print("Nombre del Torneo: ");
        String nombreTorneo = scanner.nextLine();
        System.out.print("Tipo del Torneo: ");
        String tipoTorneo = scanner.nextLine();

        // Crear y devolver una instancia de Torneo
        Torneo torneo = new Torneo(nombreTorneo, tipoTorneo);
        TorneoDAO torneoDAO = new TorneoDAO(MyConnectionManager.getInstance().getManager());
        torneoDAO.save(torneo);
        actualizar();

    }

    public void crearTipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del Tipo:");
        System.out.print("Nombre del Tipo: ");
        String nombreTipo = scanner.nextLine();
        System.out.print("Tarifa del Tipo: ");
        int tarifaTipo = scanner.nextInt();

        // Crear y devolver una instancia de Tipo
        Tipo tipo = new Tipo(nombreTipo, tarifaTipo);
        TipoDAO tipoDAO = new TipoDAO(MyConnectionManager.getInstance().getManager());
        tipoDAO.save(tipo);
        actualizar();
    }


    public void crearInscripcionDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Miembros disponibles:");
        for (Miembro miembro : miembros) {
            System.out.println(miembro.getIdMiembro() + " - " + miembro.getNombre() + " " + miembro.getApellido());
        }
        System.out.println("Torneos disponibles:");
        for (Torneo torneo : torneos) {
            System.out.println(torneo.getIdTorneo() + " - " + torneo.getNombreTorneo());
        }

        System.out.println("Ingrese los datos de la Inscripción:");
        System.out.print("ID del Torneo: ");
        int idTorneo = scanner.nextInt();
        System.out.println("Año de la Inscripción: ");
        int año = scanner.nextInt();
        System.out.print("ID del Miembro: ");
        int idMiembro = scanner.nextInt();

        // Crear y devolver una instancia de Inscripcion
        Inscripcion inscripcion = new Inscripcion(idMiembro, idTorneo,año);
        InscripcionDAO inscripcionDAO = new InscripcionDAO(MyConnectionManager.getInstance().getManager());
        inscripcionDAO.save(inscripcion);
        actualizar();
    }

    public void crearEquipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del Equipo:");
        System.out.print("Nombre del Equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.print("Noche de Práctica: ");
        String nochePractica = scanner.nextLine();
        System.out.print("ID del Manager: ");
        int idManager = scanner.nextInt();

        // Crear y devolver una instancia de Equipo
        Equipo equipo = new Equipo(nombreEquipo, nochePractica, idManager);
        EquipoDAO equipoDAO = new EquipoDAO(MyConnectionManager.getInstance().getManager());
        equipoDAO.save(equipo);
        actualizar();
    }

    public void crearMiembroDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del Miembro:");
        System.out.print("Nombre del Miembro: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del Miembro: ");
        String apellido = scanner.nextLine();
        System.out.print("Tipo de Miembro: ");
        String tipoMiembro = scanner.nextLine();
        System.out.print("Teléfono del Miembro: ");
        String telefono = scanner.nextLine();
        System.out.print("Handicap del Miembro: ");
        int handicap = scanner.nextInt();
        System.out.print("Fecha de Ingreso del Miembro (yyyy-MM-dd): ");
        String fechaIngresoStr = scanner.next();
        Date fechaIngreso = parseFecha(fechaIngresoStr);
        System.out.print("ID del Entrenador del Miembro: ");
        int coach = scanner.nextInt();
        System.out.print("Nombre del Equipo del Miembro: ");
        String equipo = scanner.next();
        System.out.print("Género del Miembro: ");
        String genero = scanner.next();

        // Crear y devolver una instancia de Miembro
        Miembro miembro = new Miembro(apellido, nombre,  tipoMiembro, telefono, handicap, fechaIngreso, coach, equipo, genero);
        MiembroDAO miembroDAO = new MiembroDAO(MyConnectionManager.getInstance().getManager());
        miembroDAO.save(miembro);
        actualizar();

    }



    public void eliminarTipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipos disponibles:");
        for (Tipo tipo : tipos) {
            System.out.println(tipo.getIdTipo() + " - " + tipo.getTipo());
        }

        System.out.print("Ingrese el ID del Tipo que desea eliminar: ");
        int idTipoEliminar = scanner.nextInt();

        // Buscar el Tipo por ID
        Optional<Tipo> tipoAEliminar = tipos.stream()
                .filter(tipo -> tipo.getIdTipo() == idTipoEliminar)
                .findFirst();

        // Eliminar el Tipo si se encuentra
        tipoAEliminar.ifPresent(tipo -> {
            TipoDAO tipoDAO = new TipoDAO(MyConnectionManager.getInstance().getManager());
            tipoDAO.delete(tipo);
            tipos.remove(tipo);
            actualizar();
            System.out.println("Tipo eliminado correctamente.");
        });
    }

    public void eliminarInscripcionDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inscripciones disponibles:");
        for (Inscripcion inscripcion : inscripcions) {
            System.out.println("ID Miembro: " + inscripcion.getIdMiembro() + " - ID Torneo: " + inscripcion.getIdTorneo() + " - Año: " + inscripcion.getAño());
        }

        System.out.print("Ingrese el ID del Miembro para el cual desea eliminar la Inscripción: ");
        int idMiembroEliminar = scanner.nextInt();

        System.out.print("Ingrese el ID del Torneo para el cual desea eliminar la Inscripción: ");
        int idTorneoEliminar = scanner.nextInt();

        // Buscar la Inscripción por ID de Miembro y Torneo
        Optional<Inscripcion> inscripcionAEliminar = inscripcions.stream()
                .filter(inscripcion -> inscripcion.getIdMiembro() == idMiembroEliminar && inscripcion.getIdTorneo() == idTorneoEliminar)
                .findFirst();

        // Eliminar la Inscripción si se encuentra
        inscripcionAEliminar.ifPresent(inscripcion -> {
            InscripcionDAO inscripcionDAO = new InscripcionDAO(MyConnectionManager.getInstance().getManager());
            inscripcionDAO.delete(inscripcion);
            inscripcions.remove(inscripcion);
            actualizar();
            System.out.println("Inscripción eliminada correctamente.");
        });
    }

    public void eliminarEquipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Equipos disponibles:");
        for (Equipo equipo : equipos) {
            System.out.println("ID: " + equipo.getIdEquipo() + " - Nombre: " + equipo.getNombreEquipo());
        }

        System.out.print("Ingrese el ID del Equipo que desea eliminar: ");
        int idEquipoEliminar = scanner.nextInt();

        // Buscar el Equipo por ID
        Optional<Equipo> equipoAEliminar = equipos.stream()
                .filter(equipo -> equipo.getIdEquipo() == idEquipoEliminar)
                .findFirst();

        // Eliminar el Equipo si se encuentra
        equipoAEliminar.ifPresent(equipo -> {
            EquipoDAO equipoDAO = new EquipoDAO(MyConnectionManager.getInstance().getManager());
            equipoDAO.delete(equipo);
            equipos.remove(equipo);
            actualizar();
            System.out.println("Equipo eliminado correctamente.");
        });
    }

    public void eliminarMiembroDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Miembros disponibles:");
        for (Miembro miembro : miembros) {
            System.out.println("ID: " + miembro.getIdMiembro() + " - Nombre: " + miembro.getNombre() + " " + miembro.getApellido());
        }

        System.out.print("Ingrese el ID del Miembro que desea eliminar: ");
        int idMiembroEliminar = scanner.nextInt();

        // Buscar el Miembro por ID
        Optional<Miembro> miembroAEliminar = miembros.stream()
                .filter(miembro -> miembro.getIdMiembro() == idMiembroEliminar)
                .findFirst();

        // Eliminar el Miembro si se encuentra
        miembroAEliminar.ifPresent(miembro -> {
            MiembroDAO miembroDAO = new MiembroDAO(MyConnectionManager.getInstance().getManager());
            miembroDAO.delete(miembro);
            miembros.remove(miembro);
            actualizar();
            System.out.println("Miembro eliminado correctamente.");
        });
    }
    public void eliminarTorneoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Torneos disponibles:");
        for (Torneo torneo : torneos) {
            System.out.println("ID: " + torneo.getIdTorneo() + " - Nombre: " + torneo.getNombreTorneo());
        }

        System.out.print("Ingrese el ID del Torneo que desea eliminar: ");
        int idTorneoEliminar = scanner.nextInt();

        // Buscar el Torneo por ID
        Optional<Torneo> torneoAEliminar = torneos.stream()
                .filter(torneo -> torneo.getIdTorneo() == idTorneoEliminar)
                .findFirst();

        // Eliminar el Torneo si se encuentra
        torneoAEliminar.ifPresent(torneo -> {
            TorneoDAO torneoDAO = new TorneoDAO(MyConnectionManager.getInstance().getManager());
            torneoDAO.delete(torneo);
            torneos.remove(torneo);
            actualizar();
            System.out.println("Torneo eliminado correctamente.");
        });
    }
    public void editarMiembroDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Miembros disponibles:");
        for (Miembro miembro : miembros) {
            System.out.println("ID: " + miembro.getIdMiembro() + " - Nombre: " + miembro.getNombre() + " " + miembro.getApellido());
        }

        System.out.print("Ingrese el ID del Miembro que desea editar (0 para cancelar): ");
        int idMiembroEditar = scanner.nextInt();

        if (idMiembroEditar == 0) {
            System.out.println("Edición cancelada.");
            return;
        }

        // Buscar el Miembro por ID
        Optional<Miembro> miembroAEditar = miembros.stream()
                .filter(miembro -> miembro.getIdMiembro() == idMiembroEditar)
                .findFirst();

        // Editar el Miembro si se encuentra
        miembroAEditar.ifPresent(miembro -> {
            int opcion;
            do {
                System.out.println("Seleccione el campo que desea editar:");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. Tipo de Miembro");
                System.out.println("4. Teléfono");
                System.out.println("5. Handicap");
                System.out.println("6. Fecha de Ingreso (yyyy-MM-dd)");
                System.out.println("7. ID del Entrenador");
                System.out.println("8. Nombre del Equipo");
                System.out.println("9. Género");
                System.out.println("0. Finalizar edición");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.next();
                        miembro.setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.print("Nuevo apellido: ");
                        String nuevoApellido = scanner.next();
                        miembro.setApellido(nuevoApellido);
                        break;
                    case 3:
                        System.out.print("Nuevo tipo de miembro: ");
                        String nuevoTipoMiembro = scanner.next();
                        miembro.setTipoMiembro(nuevoTipoMiembro);
                        break;
                    case 4:
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.next();
                        miembro.setTelefono(nuevoTelefono);
                        break;
                    case 5:
                        System.out.print("Nuevo handicap: ");
                        int nuevoHandicap = scanner.nextInt();
                        miembro.setHandicap(nuevoHandicap);
                        break;
                    case 6:
                        System.out.print("Nueva fecha de ingreso (yyyy-MM-dd): ");
                        String nuevaFechaIngresoStr = scanner.next();
                        Date nuevaFechaIngreso = parseFecha(nuevaFechaIngresoStr);
                        miembro.setFechaIngreso(nuevaFechaIngreso);
                        break;
                    case 7:
                        System.out.print("Nuevo ID del Entrenador: ");
                        int nuevoCoach = scanner.nextInt();
                        miembro.setCoach(nuevoCoach);
                        break;
                    case 8:
                        System.out.print("Nuevo nombre del equipo: ");
                        String nuevoEquipo = scanner.next();
                        miembro.setEquipo(nuevoEquipo);
                        break;
                    case 9:
                        System.out.print("Nuevo género: ");
                        String nuevoGenero = scanner.next();
                        miembro.setGenero(nuevoGenero);
                        break;
                    case 0:
                        System.out.println("Edición finalizada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            // Actualizar el Miembro en la base de datos
            MiembroDAO miembroDAO = new MiembroDAO(MyConnectionManager.getInstance().getManager());
            miembroDAO.update(miembro);
            actualizar();
        });
    }
    public void editarTorneoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Torneos disponibles:");
        for (Torneo torneo : torneos) {
            System.out.println("ID: " + torneo.getIdTorneo() + " - Nombre: " + torneo.getNombreTorneo());
        }

        System.out.print("Ingrese el ID del Torneo que desea editar (0 para cancelar): ");
        int idTorneoEditar = scanner.nextInt();

        if (idTorneoEditar == 0) {
            System.out.println("Edición cancelada.");
            return;
        }

        // Buscar el Torneo por ID
        Optional<Torneo> torneoAEditar = torneos.stream()
                .filter(torneo -> torneo.getIdTorneo() == idTorneoEditar)
                .findFirst();

        // Editar el Torneo si se encuentra
        torneoAEditar.ifPresent(torneo -> {
            int opcion;
            do {
                System.out.println("Seleccione el campo que desea editar:");
                System.out.println("1. Nombre del Torneo");
                System.out.println("2. Tipo del Torneo");
                System.out.println("0. Finalizar edición");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo nombre del Torneo: ");
                        String nuevoNombreTorneo = scanner.next();
                        torneo.setNombreTorneo(nuevoNombreTorneo);
                        break;
                    case 2:
                        System.out.print("Nuevo tipo del Torneo: ");
                        String nuevoTipoTorneo = scanner.next();
                        torneo.setTipoTorneo(nuevoTipoTorneo);
                        break;
                    case 0:
                        System.out.println("Edición finalizada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            // Actualizar el Torneo en la base de datos
            TorneoDAO torneoDAO = new TorneoDAO(MyConnectionManager.getInstance().getManager());
            torneoDAO.update(torneo);
            actualizar();
        });
    }
    public void editarEquipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Equipos disponibles:");
        for (Equipo equipo : equipos) {
            System.out.println("ID: " + equipo.getIdEquipo() + " - Nombre: " + equipo.getNombreEquipo());
        }

        System.out.print("Ingrese el ID del Equipo que desea editar (0 para cancelar): ");
        int idEquipoEditar = scanner.nextInt();

        if (idEquipoEditar == 0) {
            System.out.println("Edición cancelada.");
            return;
        }

        // Buscar el Equipo por ID
        Optional<Equipo> equipoAEditar = equipos.stream()
                .filter(equipo -> equipo.getIdEquipo() == idEquipoEditar)
                .findFirst();

        // Editar el Equipo si se encuentra
        equipoAEditar.ifPresent(equipo -> {
            int opcion;
            do {
                System.out.println("Seleccione el campo que desea editar:");
                System.out.println("1. Nombre del Equipo");
                System.out.println("2. Noche de Práctica");
                System.out.println("3. ID del Manager");
                System.out.println("0. Finalizar edición");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo nombre del Equipo: ");
                        String nuevoNombreEquipo = scanner.next();
                        equipo.setNombreEquipo(nuevoNombreEquipo);
                        break;
                    case 2:
                        System.out.print("Nueva noche de práctica del Equipo: ");
                        String nuevaNochePractica = scanner.next();
                        equipo.setNochePractica(nuevaNochePractica);
                        break;
                    case 3:
                        System.out.print("Nuevo ID del Manager del Equipo: ");
                        int nuevoManager = scanner.nextInt();
                        equipo.setManager(nuevoManager);
                        break;
                    case 0:
                        System.out.println("Edición finalizada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            // Actualizar el Equipo en la base de datos
            EquipoDAO equipoDAO = new EquipoDAO(MyConnectionManager.getInstance().getManager());
            equipoDAO.update(equipo);
            actualizar();
        });
    }
    public void editarTipoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipos disponibles:");
        for (Tipo tipo : tipos) {
            System.out.println("ID: " + tipo.getIdTipo() + " - Nombre del Tipo: " + tipo.getTipo());
        }

        System.out.print("Ingrese el ID del Tipo que desea editar (0 para cancelar): ");
        int idTipoEditar = scanner.nextInt();

        if (idTipoEditar == 0) {
            System.out.println("Edición cancelada.");
            return;
        }

        // Buscar el Tipo por ID
        Optional<Tipo> tipoAEditar = tipos.stream()
                .filter(tipo -> tipo.getIdTipo() == idTipoEditar)
                .findFirst();

        // Editar el Tipo si se encuentra
        tipoAEditar.ifPresent(tipo -> {
            int opcion;
            do {
                System.out.println("Seleccione el campo que desea editar:");
                System.out.println("1. Nombre del Tipo");
                System.out.println("2. Tarifa del Tipo");
                System.out.println("0. Finalizar edición");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo nombre del Tipo: ");
                        String nuevoNombreTipo = scanner.next();
                        tipo.setTipo(nuevoNombreTipo);
                        break;
                    case 2:
                        System.out.print("Nueva tarifa del Tipo: ");
                        int nuevaTarifa = scanner.nextInt();
                        tipo.setTarifa(nuevaTarifa);
                        break;
                    case 0:
                        System.out.println("Edición finalizada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            // Actualizar el Tipo en la base de datos
            TipoDAO tipoDAO = new TipoDAO(MyConnectionManager.getInstance().getManager());
            tipoDAO.update(tipo);
            actualizar();
        });
    }
    public void editarInscripcionDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inscripciones disponibles:");
        for (Inscripcion inscripcion : inscripcions) {
            System.out.println("ID: " + inscripcion.getIdInscripcion() + " - ID del Miembro: " + inscripcion.getIdMiembro() + " - ID del Torneo: " + inscripcion.getIdTorneo());
        }

        System.out.print("Ingrese el ID de la Inscripción que desea editar (0 para cancelar): ");
        int idInscripcionEditar = scanner.nextInt();

        if (idInscripcionEditar == 0) {
            System.out.println("Edición cancelada.");
            return;
        }

        // Buscar la Inscripcion por ID
        Optional<Inscripcion> inscripcionAEditar = inscripcions.stream()
                .filter(inscripcion -> inscripcion.getIdInscripcion() == idInscripcionEditar)
                .findFirst();

        // Editar la Inscripcion si se encuentra
        inscripcionAEditar.ifPresent(inscripcion -> {
            int opcion;
            do {
                System.out.println("Seleccione el campo que desea editar:");
                System.out.println("1. ID del Miembro");
                System.out.println("2. ID del Torneo");
                System.out.println("3. Año");
                System.out.println("0. Finalizar edición");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo ID del Miembro: ");
                        int nuevoIdMiembro = scanner.nextInt();
                        inscripcion.setIdMiembro(nuevoIdMiembro);
                        break;
                    case 2:
                        System.out.print("Nuevo ID del Torneo: ");
                        int nuevoIdTorneo = scanner.nextInt();
                        inscripcion.setIdTorneo(nuevoIdTorneo);
                        break;
                    case 3:
                        System.out.print("Nuevo año de la Inscripción: ");
                        int nuevoAño = scanner.nextInt();
                        inscripcion.setAño(nuevoAño);
                        break;
                    case 0:
                        System.out.println("Edición finalizada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            // Actualizar la Inscripcion en la base de datos
            InscripcionDAO inscripcionDAO = new InscripcionDAO(MyConnectionManager.getInstance().getManager());
            inscripcionDAO.update(inscripcion);
            actualizar();
        });
    }


    public static void abrirURL() {
        try {
            String url = "https://github.com/a22alanbm/Proyecto-ORM";// Ejecuta el comando para abrir la URL en el navegador
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Para Windows
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Para Linux y macOS
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                System.out.println("No se puede determinar el sistema operativo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}