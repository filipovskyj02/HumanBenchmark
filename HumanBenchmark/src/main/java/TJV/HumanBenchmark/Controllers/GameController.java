package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.GameByNameDTO;
import TJV.HumanBenchmark.DTOs.GameIdNameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.GameRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameRepo gameRepo;

    public GameController(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }
    @PostMapping
    ResponseEntity addGame(@RequestBody GameByNameDTO gameByNameDTO){
       Optional<Game> game = gameRepo.addGame(gameByNameDTO);
       if (game.isEmpty()) return ResponseEntity.badRequest().body("Game already present !");
       return ResponseEntity.ok().body("Game created !");
    }
    @GetMapping
    ResponseEntity getAllGames(){
        Optional<List<Game>> games = gameRepo.getAllGames();
        if (games.isEmpty())  return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(games.get());
    }
    @DeleteMapping
    ResponseEntity deleteGame(@RequestBody GameByIdDTO gameByIdDTO){
        boolean res = gameRepo.deleteGame(gameByIdDTO);
        if (!res) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("Succesfuly deleted !");
    }
    @PutMapping
    ResponseEntity fixGameName(@RequestBody GameIdNameDTO gameIdNameDTO){
        Optional<Game> game = gameRepo.fixGameName(gameIdNameDTO);
        if (game.isEmpty()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body("Updated !");
    }
}
