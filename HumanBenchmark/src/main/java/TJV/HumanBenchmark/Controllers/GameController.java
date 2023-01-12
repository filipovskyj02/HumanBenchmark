package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.GameByNameDTO;
import TJV.HumanBenchmark.DTOs.GameIdNameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.GameRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameRepo gameRepo;

    public GameController(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @GetMapping
    public ResponseEntity getAllGames(){
        Optional<List<Game>> games = gameRepo.getAllGames();
        if (games.isEmpty())  return ResponseEntity.ok("No games present!");
        return ResponseEntity.ok(games.get());
    }
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getGameById(@PathVariable long id) {
        Optional<Game> game = gameRepo.findById(id);
        if (game.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(game.get());
    }

    @PostMapping
    public ResponseEntity addGame(@RequestBody GameByNameDTO gameByNameDTO) throws URISyntaxException {
       Optional<Game> game = gameRepo.addGame(gameByNameDTO);
       if (game.isEmpty()) return ResponseEntity.badRequest().body("Already Present!");
        return ResponseEntity.created(new URI("/game/" + game.get().getId_game())).build();

    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteGame(@PathVariable long id){
        boolean res = gameRepo.deleteGame(id);
        if (!res) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Deleted !");
    }
    @PutMapping
    ResponseEntity fixGameName(@RequestBody GameIdNameDTO gameIdNameDTO){
        Optional<Game> game = gameRepo.fixGameName(gameIdNameDTO);
        if (game.isEmpty()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok("Updated !");
    }
}
