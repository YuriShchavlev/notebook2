package notebook;

public class Note extends Record {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", note='" + text + '\'' +
                '}';
    }

    @Override
    public boolean hasSubStr(String str) {
        return text.contains(str);
    }
}
