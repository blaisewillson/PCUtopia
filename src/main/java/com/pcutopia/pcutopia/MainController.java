package com.pcutopia.pcutopia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.event.ActionEvent;
import java.util.StringTokenizer;
import javafx.scene.Node;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

public class MainController{
    private Stage stage;
    BuildController buildController;
    EditController editController;
    SelectController selectController;
    DataManager dataManager;

    @FXML
    private Scene mainControllerScene, buildScene, editScene, selectScene;
    @FXML
    private TextField emailBox, usernameRegBox, passwordRegBox, confirmBox, usernameBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private Button loginButton;
    @FXML
    private Label error;
    ArrayList<User> users = new ArrayList<User>();

    @FXML
    private void initialize() throws IOException {
        dataManager = new DataManager();
        users = dataManager.getUsers();
        System.out.println(users.size());

        FXMLLoader buildLoader = new FXMLLoader(Main.class.getResource("build-view.fxml"));
        this.buildScene = new Scene(buildLoader.load(), 1280, 720);
        buildController = buildLoader.getController();
        buildController.setMainController(this);

//        FXMLLoader editLoader = new FXMLLoader(Main.class.getResource("edit-view.fxml"));
//        this.editScene = new Scene(editLoader.load(), 1280, 720);
//        editController = editLoader.getController();
//        editController.setMainController(this);

        FXMLLoader selectLoader = new FXMLLoader(Main.class.getResource("select-view.fxml"));
        this.selectScene = new Scene(selectLoader.load(), 1280, 720);
        selectController = selectLoader.getController();
        selectController.setMainController(this);
        error.setText("");
    }

    //PC Utopia - [username]'s Builds
    @FXML
    private void loginMember(ActionEvent event) {
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        System.out.println(users.size());
        boolean check = false;
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUsername() + " vs. " + username + " || " + users.get(i).getPassword() + " vs. " + password);
            if(users.get(i).getUsername().equals(username)) {
                if(users.get(i).getPassword().equals(password)) {
                    check = true;
                    buildController.setCurrentUser(users.get(i));
                    try{
                        toBuild("PC Utopia");
                    }
                    catch(IOException e){
                        System.out.println("File Not Found");
                    }
                }
            }
            else {
                error.setText("Wrong Password");
            }
        }
        if(check = false) {
            error.setText("Username not in database");
        }
    }

    @FXML
    private void registerMember(ActionEvent event) {
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String username = usernameRegBox.getText();
        String password = passwordRegBox.getText();
        String email = emailBox.getText();
        String confirm = confirmBox.getText();
        boolean check = true;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/data/Users.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                StringTokenizer x = new StringTokenizer(str, " ");
                if(x.nextToken().equals(username)) {
                    check = false;
                    error.setText("Username already in Database");
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("File Not Found");
        }
        if(check == true) {
            if(confirm.equals(password)){
                User user = new User(username, email, password);
                users.add(user);
                try {
                    FileWriter fWriter = new FileWriter("src/main/data/Users.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
                    printWriter.println(user.toString());
                    printWriter.close();
                }
                catch (IOException e) {
                    System.out.println("File Not Found");
                }
                buildController.setCurrentUser(user);
                try{
                    toBuild("PC Utopia");
                }
                catch(IOException e){
                    System.out.println("File Not Found");
                }
            }
            else {
                System.out.println("test");
                error.setText("Passwords Do Not Match");
            }
        }
    }

    public Stage getStage() {
        return this.stage;
    }

    public void toMain(String title) {
        stage.setScene(mainControllerScene);
        stage.setTitle(title);
        stage.show();
    }

    public void toBuild(String title) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("build-view.fxml"));
        stage.setScene(new Scene(mainLoader.load(), 1280, 720));
        stage.setTitle(title);
        stage.show();
    }

    public void toEdit(String title) {
        stage.setScene(editScene);
        stage.setTitle(title);
        stage.show();
    }

    public void toSelect(String title) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("build-view.fxml"));
        stage.setScene(new Scene(mainLoader.load(), 1280, 720));
        stage.setTitle(title);
        stage.show();
    }
}