package notebook;

import java.time.LocalDate;

public class Reminder extends Alarm{
    private LocalDate date;


    @Override
    public void askQuestions() {
        super.askQuestions();
        System.out.println("Enter reminder date");
        date = Main.askDate();
        System.out.println("Enter reminder time");
    }

    @Override
    public boolean hasSubStr(String str) {
        return super.hasSubStr(str)
                || date.format(Main.DATE_FORMATTER).contains(str);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() + ", " +
                "text='" + getText() + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
