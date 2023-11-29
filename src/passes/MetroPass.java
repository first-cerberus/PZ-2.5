package passes;

public class MetroPass {
    private static int idHolder;
    private int uid;

    public MetroPass() {
        this.uid = ++idHolder;
    }

    public int getUid() {
        return uid;
    }
}
