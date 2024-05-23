package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskStorage taskStorage = new TaskStorage();
        ResultStorage resultStorage = new ResultStorage();

        //liczba threadów
        int numOfThreads = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        for (int i = 0; i < numOfThreads; i++) {
            CalcThread calcThread = new CalcThread(taskStorage, resultStorage);
            calcThread.start();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Liczby do sprawdzenia ('x' zeby zakończyć):");
        int id = 0;

        while (true) {
            String input = scanner.nextLine();

            if ("x".equalsIgnoreCase(input)) {
                //Skończ apke
                break;
            }
            try {
                int n = Integer.parseInt(input);
                Task task = new Task(n, id);
                taskStorage.addTask(task);
                id++;
            } catch (NumberFormatException e) {
                System.out.println("Zła liczba");
            }
        }

        scanner.close();
        //resultStorage.showResults();
        System.out.println("Zamykanie apki...");

        //System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        Thread.currentThread().getThreadGroup().interrupt();
        //System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }
}
