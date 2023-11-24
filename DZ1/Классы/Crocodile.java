public class Crocodile extends Animal {
    private final int MAXRUNDISTANCE = 100;
    private final int MAXSWIMDISTANCE = 200;

    public Crocodile(String name) {
        super(name);
        super.setMaxRunDistance(MAXRUNDISTANCE);
        super.setMaxSwimDistance(MAXSWIMDISTANCE);
    }
}
