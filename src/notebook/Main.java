package notebook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);


    static Scanner scan = new Scanner(System.in);
    static Map<Integer,Record> record = new LinkedHashMap<>();


    public static void main(String[] args) {

        while(true){
            System.out.println("Enter command (cr_pers, cr_note, cr_rem, list, delete, find, help or exit):");
            String cmd=scan.next();
            switch (cmd){
                case "cr_pers":
                    create_person();
                    break;
                case "cr_note":
                    create_note();
                    break;
                case "cr_rem":
                    createReminder();
                    break;
                case "list":
                    list_person();
                    break;
                case "delete":
                    removeById();
                    break;
                case "find":
                    find();
                    break;
                case "show":
                    showId();
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
        addRecord(person);
            System.out.println("Person: " + person);
        }

    private static void create_note() {
        Note note = new Note();
        addRecord(note);
    }

    private static void createReminder() {
        var reminder = new Reminder();
        addRecord(reminder);
    }

    private static void list_person() {
        System.out.println("List of existing persons:");

        for (Record person:record.values()){

            System.out.println(person);
        }
    }

    private static void removeById() {
        System.out.println("Enter ID to remove:");
        int id = askInt();
        record.remove(id);
    }

    private static void find(){
        System.out.println("What do you want to find?");
        String str=askString();

        for (Record r: record.values()){

            if (r.hasSubStr(str)){
                System.out.println("The record is: "+r);
            }
        }
    }

    private static void showId(){
        System.out.println("Enter ID to show:");
        int id=askInt();
        System.out.println(record.get(id));
    }

    private static void help(){
        System.out.println("Thank you asking!\n" +
                "Please, enter string 'cr_pers' to create new person with name, surname, phone and other data.\n" +
                "Please, enter string 'cr_note' to create new note with any text.\n" +
                "Enter string 'list' to list all existing persons with their data.\n"+
                "Enter string 'delete' to delete a person based by person's ID in ArrayList.\n" +
                "Enter 'exit' to go out off the program.\n");
    }

    private static int askInt() {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next(); // skip wrong input
                System.out.println("It isn't a number");
            }
        }
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        record.put(p.getId(),p);
        System.out.println("You have created this record:");
        System.out.println(p);
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

    public static String askPhone() {
        while (true) {
            String phone = askString();
            // checking if there any characters expect digits, spaces, pluses and dashes
            if (phone.chars().anyMatch(c -> !Character.isDigit(c) && c != ' ' && c != '+' && c != '-')) {
                System.out.println("Only digits, spaces, plus and dash are allowed!");
                continue;
            }

            // checking how many digits in the entered number (excluding spaces and other non-digits)
            if (phone.chars().filter(Character::isDigit).count() < 5) {
                System.out.println("At least 5 digits in phone number");
                continue;
            }

            // validation passed
            return phone;
        }
    }

    public static LocalDate askDate() {
        String d = askString();
        LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
        return date;
    }

}
