package notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);
    static List<Record> record = new ArrayList<>();


    public static void main(String[] args) {

        while(true){
            System.out.println("Enter command (cr_pers, cr_note, list, delete, help or exit):");
            String cmd=scan.next();
            switch (cmd){
                case "cr_pers":
                    create_person();
                    break;
                case "cr_note":
                    create_note();
                    break;
                case "list":
                    list_person();
                    break;
                case "delete":
                    delete_person();
                    break;
                case "find":
                    find();
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

    private static void create_person() {

        Person person = new Person();

        System.out.println("Your name?");
        String name = askString();
        person.setName(name);

        System.out.println("Your surname?");
        String surname = askString();
        person.setSurname(surname);

        System.out.println("Your e-mail?");
        String email = askString();
        person.setEmail(email);

        System.out.println("Your phone-number?");
        String phone = askString();

        String phone_string = new String(phone);
        if (phone_string.length() >= 5) {
            person.setPhone(phone);
            record.add(person);
            System.out.println("Person: " + person);
        } else {

            System.out.println("Phone-number should contain at least 5 symbols! Please, enter the number again: ");
            phone = askString();
            person.setPhone(phone);
            record.add(person);
            System.out.println("Person: " + person);
        }

    }

    private static void create_note(){
        Note note=new Note();

        System.out.println("Your note-text?");
        String text = askString();
        note.setText(text);
        record.add(note);
        System.out.println("Note: " + note);

    }
    private static void list_person() {
        System.out.println("List of existing persons:");

        for (Record person:record){

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

    // add cycle to check, if id exists
    }

    private static void find(){
        System.out.println("What do you want to find?");
        String str=askString();

        for (Record r: record){

            if (r.hasSubStr(str)){
                System.out.println("The record is: "+r);
            }
        }


    }
    private static void help(){
        System.out.println("Thank you asking!\n" +
                "Please, enter string 'cr_pers' to create new person with name, surname, phone and other data.\n" +
                "Please, enter string 'cr_note' to create new note with any text.\n" +
                "Enter string 'list' to list all existing persons with their data.\n"+
                "Enter string 'delete' to delete a person based by person's ID in ArrayList.\n" +
                "Enter 'exit' to go out off the program.\n");
    }

    public static String askString (){
        var result =new ArrayList<String>();
        var word=scan.next();
        if (word.startsWith("\'")){
            do {
                result.add(word);
                if (word.endsWith("\'")) {
                    String str = String.join(" ", result);
                    return str.substring(1,str.length()-1);
                }
                word = scan.next();
            }
            while (true);
        }
        else{
            return word;
        }
    }

}
