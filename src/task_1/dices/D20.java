package task_1.dices;

import java.util.Random;

public class D20 implements IDice{
    private final int edges = 20;
    private final String name = "D20";
    private final static Random random = new Random();

    @Override
    public int roll() {
        return random.nextInt(edges - 1) + 1;
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
