package com.pcutopia.pcutopia;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataManager {
    private ArrayList<User> usersList = new ArrayList<>();
    private ArrayList<PCBuild> buildsList = new ArrayList<PCBuild>();
    private PartDatabase partDatabase = new PartDatabase();

    public DataManager() throws IOException {
        populateUsers();
        //populateBuilds();
    }

    private void populateUsers() throws IOException {
        usersList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/data/Users.txt"));
        File inputFile = new File("src/main/data/Users.txt");
        if (inputFile.length() == 0) {
            System.out.println("No users found in the database.");
            return;
        }
        String readLine;
        User tempUser = new User();
        int i = 0;
        while ((readLine = bufferedReader.readLine()) != null) {
            if (i == 0) {
                int userID = Integer.parseInt(readLine);
                tempUser.setUserID(userID);
                i++;
            } else if (i == 1) {
                String username = readLine;
                tempUser.setUsername(username);
                i++;
            } else if (i == 2) {
                String email = readLine;
                tempUser.setEmail(email);
                i++;
            } else if (i == 3) {
                String password = readLine;
                tempUser.setPassword(password);
                i++;
            }
            if (readLine.equals("-------")) {
                System.out.println(tempUser);
                usersList.add(tempUser);
                tempUser = new User();
                i = 0;
            }
        }
    }

    private void populateBuilds() throws IOException {
        buildsList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/data/Builds.txt"));
        File inputFile = new File("src/main/data/Builds.txt");
        if (inputFile.length() == 0) {
            System.out.println("No builds found in the database.");
            return;
        }
        String readLine;
        PCBuild tempBuild = new PCBuild();
        int i = 0;
        while ((readLine = bufferedReader.readLine()) != null) {
            String readLineValue = readLine.split("\\| ")[1];
            if (i == 0) {
                int userID = Integer.parseInt(readLineValue);
                tempBuild.setUserID(userID);
                i++;
            } else if (i == 1) {
                int buildID = Integer.parseInt(readLineValue);
                tempBuild.setBuildID(buildID);
                i++;
            } else if (i == 2) {
                String buildName = readLineValue;
                tempBuild.setBuildName(buildName);
                i++;
            } else if (i == 3) {
                String CPU = readLineValue;
                tempBuild.setCPU(findCPU(CPU));
                i++;
            }
            if (readLine.equals("-------")) {
                System.out.println(tempBuild);
                buildsList.add(tempBuild);
                tempBuild = new PCBuild();
                i = 0;
            }
        }
    }

    private CPUPart findCPU(String name) {
        ArrayList<CPUPart> parts = partDatabase.getCPUs();
        CPUPart found = null;
        for(CPUPart part : parts) {
            if(part.getName().equals(name)) {
                return part;
            }
        }
        return found;
    }

    public void clearBuilds() {
        try {
            PrintWriter writer = new PrintWriter("src/main/data/Builds.txt");
            writer.print("");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public void fillBuilds(ObservableList<PCBuild> buildList) {
        try {
            PrintWriter writer = new PrintWriter("src/main/data/Builds.txt");
            for(int i = 0; i < buildList.size(); i++) {
                writer.print(buildList.get(i).toString());
                writer.println("-------");
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public ArrayList<User> getUsers() {
        return usersList;
    }

    public ArrayList<PCBuild> getBuilds() {
        return buildsList;
    }
}
