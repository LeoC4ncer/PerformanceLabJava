public class Tiger extends Animal {
    private final int MAXRUNDISTANCE = 8000;
    private final int MAXSWIMDISTANCE = 0;

    public Tiger(String name)
    {
        super(name);
        super.setMaxRunDistance(MAXRUNDISTANCE);
        super.setMaxSwimDistance(MAXSWIMDISTANCE);
    }
}
