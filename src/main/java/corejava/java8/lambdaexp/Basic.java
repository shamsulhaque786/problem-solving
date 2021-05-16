package corejava.java8.lambdaexp;

import corejava.java8.lambdaexp.beans.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Basic {

    public static void main (String [] a) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("shams", "28", "Alld"));
        personList.add(new Person("shams1", "25", "Rbl"));
        personList.add(new Person("shams2", "22", "Lko"));
        personList.add(new Person("shams3", "25", "Vns"));
        personList.add(new Person("shams4", "27", "Mzp"));

        Function<Person, String > f1 = p -> {
            return "Name : " + p.getName() + ", Age : " + p.getAge() + ", City : " + p.getCity();
        };

        for ( Person p : personList) {
            System.out.println(p.print(f1));
        }

        Map<String, Predicate<Person>> critera = new HashMap<>();
        Predicate<Person> up1 = p -> p.getCity().matches("Alld|Lko|Vns");
        Predicate<Person> up2 = p -> p.getCity().matches("Rbl|Mzp");
        critera.put("up1", up1);
        critera.put("up2", up2);
        System.out.println("\nUP1 : ");
        personList.stream().filter(critera.get("up1")).forEach(p -> System.out.println(p.print(f1)));

        System.out.println("\nUP2 : ");
        personList.stream().filter(critera.get("up2")).forEach(p -> System.out.println(p.print(f1)));

    }
}
