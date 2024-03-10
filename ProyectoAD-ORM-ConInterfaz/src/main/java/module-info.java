module org.example.proyectoadormconinterfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.persistence;
    requires org.hibernate.orm.core;


    opens org.example.modelo to org.hibernate.orm.core;

    opens org.example.interfaz to javafx.fxml;
    exports org.example.interfaz;
}