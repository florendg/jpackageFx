module dev.vulture.packagefx {
    requires javafx.controls;
    requires javafx.fxml;
    exports dev.vulture.packagefx;
    opens dev.vulture.packagefx.controller to javafx.fxml;
}