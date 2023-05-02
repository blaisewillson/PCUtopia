package com.pcutopia.pcutopia;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.util.ArrayList;

public class BuildController {
    private User currentUser;
    ObservableList<PCBuild> currentBuildsList = FXCollections.observableArrayList();

    @FXML
    private Stage stage;
    @FXML
    private Scene mainScene;
    @FXML
    private MenuItem logoutUser;
    @FXML
    private ListView buildList;
    @FXML
    private MainController mainController;
    DataManager dataManager;

    @FXML
    private void initialize() throws IOException {
        if(currentUser != null) {

        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                your_array_list );
//
//        lv.setAdapter(arrayAdapter);
    }

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    private void exportBuild() {
    }

    @FXML
    private void importBuild() {

    }

    @FXML
    private void addBuild() {
        PCBuild build = new PCBuild();
    }

    @FXML
//    private void deleteBuild(int buildID) {
//        for (int i = 0; i < this.dataManager.getBuilds().size(); i++) {
//            if (this.dataManager.getBuilds().get(i).getBuildID() == buildID) {
//                this.dataManager.getBuilds().remove(i);
//                return;
//            }
//        }
//    }

//    @FXML
    private void editBuild(ActionEvent event) {
        stage = (Stage) buildList.getScene().getWindow();
        PCBuild build = (PCBuild) buildList.getSelectionModel().getSelectedItem();
        if(build != null) {
            try{
                toEdit("Edit Build");
            }
            catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    @FXML
    private void logout() throws IOException{
        stage = (Stage) buildList.getScene().getWindow();
        currentUser = null;
        currentBuildsList = FXCollections.observableArrayList();
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        stage.setScene(new Scene(mainLoader.load(), 1280, 720));
        stage.setTitle("PC Utopia");
        stage.show();
    }

    private void updateBuild(PCBuild build) {
        for(int i = 0; i < currentBuildsList.size(); i++) {
            if(currentBuildsList.get(i).getBuildID() == build.getBuildID()) {
                currentBuildsList.set(i, build);
            }
        }
        dataManager.clearBuilds();
        dataManager.fillBuilds(currentBuildsList);
    }

    private void toEdit(String title) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("edit-view.fxml"));
        stage.setScene(new Scene(mainLoader.load(), 1280, 720));
        stage.setTitle(title);
        stage.show();
    }

    public void deleteBuild(ActionEvent event) {
//        for (int i = 0; i < this.dataManager.getBuilds().size(); i++) {
//            if (this.dataManager.getBuilds().get(i).getBuildID() == buildID) {
//                this.dataManager.getBuilds().remove(i);
//                return;
//            }
//        }
    }
}