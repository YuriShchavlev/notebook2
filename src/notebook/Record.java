package notebook;

public abstract class Record {

    private static int count=0;
    private int id;

    public Record() {
        count++;
        id=count;
    }

    public abstract boolean hasSubStr(String str);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
