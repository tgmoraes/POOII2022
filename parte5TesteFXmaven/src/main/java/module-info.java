module br.edu.ifrs.osorio.parte5TesteFXmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.base;

    opens br.edu.ifrs.osorio.parte5TesteFXmaven.controllers to javafx.fxml;
    opens br.edu.ifrs.osorio.parte5TesteFXmaven.model to javafx.base;
    exports br.edu.ifrs.osorio.parte5TesteFXmaven;
}
