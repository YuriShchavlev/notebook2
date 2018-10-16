package notebook;

public class Alarm extends Note {

    private String time;

    @Override
    public void askQuestions() {
        super.askQuestions();
        System.out.println("Enter alarm-time");
        time = Main.askString();
    }

    @Override
    public boolean hasSubStr(String str) {
        return super.hasSubStr(str)
                || time.contains(str);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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


}
