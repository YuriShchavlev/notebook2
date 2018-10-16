package notebook;

import java.time.LocalTime;

public class Alarm extends Note implements Expirable{

    private LocalTime time;

    @Override
    public void askQuestions() {
        super.askQuestions();
        System.out.println("Enter alarm-time");
        time = Main.askTime();
    }

    @Override
    public boolean hasSubStr(String str) {
        return super.hasSubStr(str)
                || time.format(Main.TIME_FORMATTER).contains(str);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() + ", " +
                "text='" + getText() + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


    @Override
    public boolean isExpired() {
        LocalTime now=LocalTime.now();
        return time.isAfter(now);
    }
}
