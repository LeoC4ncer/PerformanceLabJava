public class Cat extends Animal {
    private final int MAXRUNDISTANCE = 200;
    private final int MAXSWIMDISTANCE = 0;

    public Cat(String name)
    {
        super(name);
        super.setMaxRunDistance(MAXRUNDISTANCE);
        super.setMaxSwimDistance(MAXSWIMDISTANCE);
    }
}
