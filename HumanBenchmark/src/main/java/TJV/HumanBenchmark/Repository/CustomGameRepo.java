package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.DTOs.NewGameDTO;
import TJV.HumanBenchmark.Model.Game;
import org.springframework.http.ResponseEntity;

public interface CustomGameRepo {
    ResponseEntity addGame(NewGameDTO newGameDTO);
    ResponseEntity getAllGames();
}
