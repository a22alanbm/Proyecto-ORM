module org.example.proyectoadormconinterfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.persistence;
    requires org.hibernate.orm.core;


    opens org.example.proyectoadormconinterfaz to javafx.fxml;
    exports org.example.proyectoadormconinterfaz;
}