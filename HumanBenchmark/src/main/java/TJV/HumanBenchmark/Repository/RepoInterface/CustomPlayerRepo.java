package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.PlayerDeleteDTO;
import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;

import java.util.List;
import java.util.Optional;

public interface CustomPlayerRepo {



    Optional<Player> register(RegisterPlayerDTO registerPlayerDTO);

    Optional<List<Player>> getAllPlayers();

    boolean deletePlayer(PlayerDeleteDTO playerDeleteDTO);

    Optional<Player> updatePlayer(Player player);
}
