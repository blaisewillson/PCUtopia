package com.pcutopia.pcutopia;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class EditController {
    private MainController mainController;

    private void initialize() throws IOException {
        FXMLLoader buildLoader = new FXMLLoader(Main.class.getResource("build-view.fxml"));

    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }
}
