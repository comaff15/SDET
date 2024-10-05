package task_1.player;

import java.util.*;

public class PlayerRepositoryInMemory implements PlayerRepository{
    private final Map<UUID, Player> playerInMemory = new HashMap<>();

    @Override
    public void createPlayer(Player player) {
        playerInMemory.put(player.getID(), player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerInMemory.put(player.getID(), player);
    }

    @Override
    public Player searchPlayer(UUID playerID) {
        return playerInMemory.get(playerID);
    }


    @Override
    public List<Player> getAll() {
        return List.copyOf(playerInMemory.values());
    }

}
