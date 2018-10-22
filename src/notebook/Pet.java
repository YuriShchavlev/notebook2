package notebook;

import java.util.ArrayList;
import java.util.List;

public class Pet extends Record{
    private String name;

    static List<Record> record = new ArrayList<>();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean hasSubStr(String str) {
        return name.contains(str);
    }

    public void askQuestions() {
        System.out.println("Enter name:");
        name = Main.askString();
    }

    private static void create_pet() {

        Pet pet = new Pet();
        addRecord(pet);
        System.out.println("Person: " + pet);
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        record.add(p);
        System.out.println("You have created this record:");
        System.out.println(p);
    }
}
