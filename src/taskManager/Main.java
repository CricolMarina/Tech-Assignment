package taskManager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start app");
        if(args.length == 0) {
            System.out.println("Error! No commands to execute");
            return;
        }

        System.out.println("Executing - " + args[0]);

        if("createUser".equals(args[0])) {
            createUser(args);
        } else if("createTask".equals(args[0])) {
            createTask(args);
        } else if("showAllUsers".equals(args[0])) {
            showAllUsers();
        } else if("showTasks".equals(args[0])) {
            showUsersTasks(args);
        }

        System.out.println("Finish app");
    }

    public static void createUser(String[] args) {
        String fileName = "User";
        User user = new User(args[1], args[2], args[3]);
        List<Object> users = readFromFile(fileName);

        users.add(user);
        writeToDisc(users, fileName);
    }

    public static void createTask(String[] args) {
        String fileName = "Task";
        Task task = new Task(args[1], args[2], args[3]);
        List<Object> tasks = readFromFile(fileName);
        tasks.add(task);
        writeToDisc(tasks, fileName);
    }

    public static void showAllUsers() {
        List<Object> users = readFromFile("User");
        for(Object user : users) {
            if(user instanceof User) {
                System.out.println(user.toString());
            }
        }
    }

    public static void showUsersTasks(String[] args) {
        String userName = args[1];
        List<Object> tasks = readFromFile("Task");
        for(Object task : tasks) {
            if(userName.equals(((Task) task).getUserName())) {
                System.out.println(task);
            }
        }
    }

    public static List<Object> readFromFile(String fileName) {
        List<Object> objects = new ArrayList<Object>();
        try {
            FileInputStream fis = new FileInputStream(fileName + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(fis.available() != 0){
                objects = (List<Object>)ois.readObject();
            }

            fis.close();
            ois.close();

        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static void writeToDisc(List<Object> object, String filename) {
        try {
            FileOutputStream f = new FileOutputStream(new File(filename + ".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(object);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}