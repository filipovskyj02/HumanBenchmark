package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.NewGameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.GameRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameRepo gameRepo;

    public GameController(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }
    @PostMapping
    ResponseEntity addGame(@RequestBody NewGameDTO newGameDTO){
       return gameRepo.addGame(newGameDTO);
    }
    @GetMapping
    ResponseEntity getAllGames(){
        return gameRepo.getAllGames();
    }
}
