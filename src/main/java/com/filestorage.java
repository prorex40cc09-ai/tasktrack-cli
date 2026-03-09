package com.tasktrack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    private String fileName = "tasks.txt";

    public void saveTasks(List<Task> tasks) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Task task : tasks) {

                String line = task.getDescription() + "|" + task.isCompleted();
                writer.write(line);
                writer.newLine();

            }

        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }

    }

    public List<Task> loadTasks() {

        List<Task> tasks = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                String description = parts[0];
                boolean completed = Boolean.parseBoolean(parts[1]);

                Task task = new Task(description);

                if (completed) {
                    task.complete();
                }

                tasks.add(task);

            }

        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }
}
