public class Dog extends Animal {
    private final int MAXRUNDISTANCE = 500;
    private final int MAXSWIMDISTANCE = 10;

    public Dog(String name)
    {
        super(name);
        super.setMaxRunDistance(MAXRUNDISTANCE);
        super.setMaxSwimDistance(MAXSWIMDISTANCE);
    }
}
