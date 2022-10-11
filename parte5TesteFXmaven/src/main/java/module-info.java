module br.edu.ifrs.osorio.parte5TesteFXmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.edu.ifrs.osorio.parte5TesteFXmaven to javafx.fxml;
    exports br.edu.ifrs.osorio.parte5TesteFXmaven;
}
