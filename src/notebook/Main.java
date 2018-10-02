package notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);
    static List<Person> record = new ArrayList<>();


    public static void main(String[] args) {

        while(true){
            System.out.println("Enter command (create, list, delete, help or exit):");
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
                case "help":
                    help();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void create() {

        Person person = new Person();

        System.out.println("Your name?");
        String name = scan.next();

        String name_string = new String(name);
        if ((name_string.startsWith("\'")) && (name_string.endsWith("\'"))){
            person.setName(name_string);
        }
        else{
            person.setName(name);
        }

        System.out.println("Your surname?");
        String surname = scan.next();
        person.setSurname(surname);

        System.out.println("Your e-mail?");
        String email = scan.next();
        person.setEmail(email);

        System.out.println("Your phone-number?");
        String phone = scan.next();

        String phone_string = new String(phone);
        if (phone_string.length() >= 5) {
            person.setPhone(phone);
            record.add(person);
            System.out.println("Person: " + person);
        } else {

            System.out.println("Phone-number should contain at least 5 symbols! Please, enter the number again: ");
            phone = scan.next();
            person.setPhone(phone);
            record.add(person);
            System.out.println("Person: " + person);
        }

    }
    private static void list_person() {
        System.out.println("List of existing persons:");

        for (Person person:record){

          System.out.println(person);
        }
    }

    private static void delete_person(){

        System.out.println("Please, enter id:");
        int id = scan.nextInt();

        if (id>0){
            record.remove(id-1);
            System.out.println("Person with id="+id+" is deleted!");
        }
        else {
            System.out.println("You have just one person left!, who's ID is different from the data entered");
        }


    }

    private static void help(){
        System.out.println("Thank you for entering string help!\n" +
                "Please, enter string 'create' to create new person with name, surname, phone and other data.\n" +
                "Enter string 'list' to list all existing persons witg their data.\n"+
                "Enter string 'delete' to delete a person based by person's ID in ArrayList.\n" +
                "Enter 'exit' to go out off the program.\n");
    }

}
