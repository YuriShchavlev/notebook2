package notebook;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public final static String TIME_FORMAT = "HH:mm";
    public final static DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);


    static Scanner scan = new Scanner(System.in);
    static Map<Integer,Record> record = new LinkedHashMap<>();


    public static void main(String[] args) {

        while(true){
            System.out.println("Enter command (cr_pers, cr_note, cr_rem, cr_alarm, list, delete, find, show, cr_pet, help or exit):");
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
                case "cr_alarm":
                    createAlarm();
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
                case "exp":
                    expired();
                case "cr_pet":
                    create_pet();
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

    private static void createAlarm(){
        var alarm = new Alarm();
        addRecord(alarm);
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

    private static void expired(){
        for(Record record: record.values()) {
            if (record instanceof Expirable) {

            Expirable e = (Expirable)record;

            if (e.isExpired()) {
                System.out.println(record);
            }
        }
        }
    }

    private static void create_pet() {

        Pet pet = new Pet();
        addRecord(pet);
        System.out.println("Person: " + pet);
    }

    private static void help(){
        System.out.println("Thank you for asking!\n" +
                "*****************************\n"+
                ">Please, enter string 'cr_pers' to create new person with name, surname, phone and other data.\n" +
                ">Please, enter string 'cr_note' to create new note with any text.\n" +
                ">Please, enter string 'cr_rem' to create new reminder.\n" +
                ">Please, enter string 'cr_alarm' to create new alarm.\n" +
                ">Enter string 'list' to list all existing persons with their data.\n"+
                ">Enter string 'delete' to delete a person based by person's ID.\n" +
                ">Enter string 'find' to find info with a string.\n"+
                ">Enter string 'show' to show person with ID.\n"+
                ">Enter string 'cr_pet' to create new pet.\n"+
                ">Enter string 'exp' to show expired alarms and reminders.\n"+
                ">Enter 'exit' to go out off the program.\n");
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

    public static LocalTime askTime() {
        String t = askString();
        LocalTime time = LocalTime.parse(t, TIME_FORMATTER);
        return time;
    }
}
