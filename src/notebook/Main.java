package notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static List<Person> record = new ArrayList<>();


    public static void main(String[] args) {

        while(true){
            System.out.println("Enter command:");
            String cmd=scan.next();
            switch (cmd){
                case "create":
                    create();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void create() {

        Person person =new Person();
        System.out.println("Your name?");
        String name = scan.next();
        person.setName(name);

        System.out.println("Your surname?");
        String surname = scan.next();
        person.setSurname(surname);


        System.out.println("Your phone-number?");
        String phone = scan.next();
        person.setPhone(phone);

        record.add(person);

        System.out.println("Person: "+person);


    }
}
