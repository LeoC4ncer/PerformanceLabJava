public class Dolphin extends Animal{
    private final int MAXRUNDISTANCE = 0;
    private final int MAXSWIMDISTANCE = 1000;

    public Dolphin(String name)
    {
        super(name);
        super.setMaxRunDistance(MAXRUNDISTANCE);
        super.setMaxSwimDistance(MAXSWIMDISTANCE);
    }
}
