package hm;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class View {

    public void completeTasks(){
        for (int i = 0; i < Main.tasks.stream().count(); i++){
            if(Main.tasks.get(i).isTaskDone() == true)
                System.out.println("Задание номер "+i+" обошлось в " + Main.tasks.get(i).getTaskPrice().toString() + "\n");
        }
    }

    public void uncompleteTasks(){
        for (int i = 0; i < Main.tasks.stream().count(); i++){
            if(Main.tasks.get(i).isTaskDone() == false)
                System.out.println("Задание номер "+i+" не решено");
        }
    }

    public void top3(){
        var result = Main.workers.stream().filter(x->x.getCount()>=3).sorted(Comparator.comparing(x->x.getCount())).limit(3).toList().stream();
        result.forEach(x->x.showInfo());
    }

    public void maxPrice(){
        Task maxPrice = Main.tasks.stream().max(Comparator.comparing(x -> x.getTaskPrice())).orElseThrow(NoSuchElementException::new);
        System.out.println("Самое дорогое задание стоило: " + maxPrice.getTaskPrice());
    }

}
