package hm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Employee> workers = new ArrayList<Employee>();

    public static void main(String[] args) {
        Thread logs = new Thread(new AutoLog(), "Logs");
        logs.start();
        Scanner scn = new Scanner(System.in);
        Menu menu = new Menu();
        try {
            menu.greetings();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
