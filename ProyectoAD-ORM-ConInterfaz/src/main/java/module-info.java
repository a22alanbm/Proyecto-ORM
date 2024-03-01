module org.example.proyectoadormconinterfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectoadormconinterfaz to javafx.fxml;
    exports org.example.proyectoadormconinterfaz;
}