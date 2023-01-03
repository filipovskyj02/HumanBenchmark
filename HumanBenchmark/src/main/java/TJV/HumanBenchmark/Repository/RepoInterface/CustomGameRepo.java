package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.GameByNameDTO;
import TJV.HumanBenchmark.DTOs.GameIdNameDTO;
import TJV.HumanBenchmark.Model.Game;

import java.util.List;
import java.util.Optional;

public interface CustomGameRepo {
    Optional<Game> addGame(GameByNameDTO gameByNameDTO);
    Optional<List<Game>> getAllGames();
    Boolean deleteGame(GameByIdDTO gameByIdDTO);

    Optional<Game> fixGameName(GameIdNameDTO gameIdNameDTO);
}
