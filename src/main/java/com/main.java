package com.tasktrack;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        manager.addTask("Learn GitHub");
        manager.addTask("Finish Java project");

        manager.listTasks();
    }
}
