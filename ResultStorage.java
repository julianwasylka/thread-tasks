package org.example;

import java.util.ArrayList;
import java.util.List;

public class ResultStorage {
    private List<Task> numbers = new ArrayList<>();

    public synchronized void addResult(Task task) {
        numbers.add(task);
        System.out.println("\nID:"+ task.getId() + ", " + task.getPi() + " - " + task.getPercent() + "%");
    }
}

