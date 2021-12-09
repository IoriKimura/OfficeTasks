package hm;

import java.io.FileWriter;
import java.io.IOException;

public class Reports {

    public void listOfWorkers(){
        try(FileWriter fileWriter = new FileWriter("Список сотрудников.txt")){
            for (Employee emp : Main.workers) {
                fileWriter.append(emp.getName() + " " + emp.getLastName() + " " + emp.getMiddleName() + " из города " + emp.getCity() +" день рождения которого: "
                        +emp.getDate().getTime());
                fileWriter.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void taskReport(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try(FileWriter fileWriter = new FileWriter("Список выполненных заданий за месяц.txt")){
            for (int i = 0; i < Main.tasks.stream().count(); i++){
                if(Main.tasks.get(i).isTaskDone() == true)fileWriter.write("Задание номер "+i+" обошлось в " + Main.tasks.get(i).getTaskPrice().toString() + "\n");
                else
                    fileWriter.write("Задание номер "+i+" не выполнено, но может обойтись в " + Main.tasks.get(i).getTaskPrice().toString() + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
