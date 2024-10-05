package task_1.dices;

import java.util.Random;

public class D6 implements IDice{
    private final int edges = 6;
    private final Random random = new Random();
    private final static String name = "D6";

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
