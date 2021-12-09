package hm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static hm.Main.tasks;
import static hm.Main.workers;

public class Menu {


    public void greetings() throws InterruptedException {
        View view = new View();
        Reports reports = new Reports();
        Random random = new Random();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Scanner scn = new Scanner(System.in);
        System.out.println("Добро пожаловать! Вы можете:");
        System.out.println("1. Добавить работника самостоятельно");
        System.out.println("2. Добавить задание самостоятельно");
        System.out.println("3. Посмотреть открытые и закрытые задачи");
        System.out.println("4. Просмотреть топ-3 продуктивных челиков");
        System.out.println("5. Просмотреть самое дорогое задание");
        System.out.println("6. Составить отчёт по заданиям");
        System.out.println("7. Посмотреть список сотрудников");
        System.out.println("8. Можете заставить всех работать!");
        System.out.println("ДЛЯ ВЫХОДА НАЖМИТЕ НОЛИК");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int i = scn.nextInt();
        switch (i){
            case 1:
                Scanner scanner = new Scanner(System.in);
                Log.writeInto("Пользователь выбрал пункт 1");
                String  name;
                String lastName;
                String middleName;
                Calendar date;
                String post;
                String city;
                long salary;
                System.out.println("Введите имя работника:");
                name = scanner.nextLine();
                System.out.println("Введите фамилию работника:");
                lastName= scanner.nextLine();
                System.out.println("Введите отчество работника");
                middleName = scanner.nextLine();
                date =  new GregorianCalendar(random.nextInt(1990,2001),
                        random.nextInt(1,13),random.nextInt(1,27));
                System.out.println("Введите должность:");
                post = scanner.nextLine();
                salary = (long)random.nextInt(30000,300000);
                System.out.println("Введите город:");
                city = scanner.nextLine();
                workers.add(new Employee(name,lastName,middleName,date,city,salary,post));
                greetings();

            case 2:
                Log.writeInto("Пользователь выбрал пункт 2");
                System.out.println("Время на задание: ");
                int time = scn.nextInt();
                System.out.println("Денег за задание: ");
                Long price = scn.nextLong();
                tasks.add(new Task(time, price));
                greetings();
            case 3:
                Log.writeInto("Пользователь выбрал пункт 3");
                System.out.println("Завершённые задачи:");
                view.completeTasks();
                System.out.println();
                System.out.println("Незавершённые задачи:");
                view.uncompleteTasks();
                greetings();
            case 4:
                Log.writeInto("Пользователь выбрал пункт 4");
                view.top3();
                greetings();
            case 5:
                Log.writeInto("Пользователь выбрал пункт 5");
                view.maxPrice();
                greetings();
            case 6:
                Log.writeInto("Пользователь выбрал пункт 6");
                System.out.println("Отчёт составлен!");
                reports.taskReport();
                greetings();
            case 7:
                Log.writeInto("Пользователь выбрал пункт 7");
                System.out.println("Список на вашем диске!");
                reports.listOfWorkers();
                greetings();
            case 8:
                Log.writeInto("Пользователь выбрал пункт 8");
                for (int j=0; i<100;i++){
                    tasks.add(new Task());
                }
                GenerateLogic generateLogic = new GenerateLogic();
                generateLogic.run();
                greetings();
            case 0:
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
    }


}
