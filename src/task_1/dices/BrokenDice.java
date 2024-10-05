package task_1.dices;

public class BrokenDice implements IDice{
    private final int edges = 12;
    private final static String name = "Broken dice";

    @Override
    public int roll() {
        return 1;
    }

    @Override
    public int getEdgesCount() {
        return edges;
    }

    @Override
    public String getName() {
        return name;
    }
}
