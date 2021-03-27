package taskManager;

import java.io.Serializable;

public class Task implements Serializable{

    private String title;
    private String desciption;
    private String userName;

    public Task(String title, String desciption, String userName) {
        this.title = title;
        this.desciption = desciption;
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public String getDesciption() {
        return desciption;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Title:" + title + " Desciption: " + desciption + " UserName: " + userName;
    }

}
