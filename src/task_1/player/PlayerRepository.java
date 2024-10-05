package task_1.player;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository {
    void createPlayer(Player player);
    void updatePlayer(Player player);
    Player searchPlayer(UUID playerID);
    List<Player> getAll();
}
