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
                case "list":
                    list_person();
                    break;
                case "delete":
                    delete_person();
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

    private static void list_person() {
        System.out.println("List of existing persons:");

        for (Person person:record){
          /*  print ("Name"+person.getName());
            print ("Surname"+person.getSurname());
            print ("Name"+person.getName());*/

          System.out.println(person);
        }
    }

    private static void delete_person(){

        System.out.println("Please, enter id:");
        int id = scan.nextInt();

        record.remove(id);


    }

}
