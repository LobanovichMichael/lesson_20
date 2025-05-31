module org.example.lesson_20 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lesson_20 to javafx.fxml;
    exports org.example.lesson_20;
}