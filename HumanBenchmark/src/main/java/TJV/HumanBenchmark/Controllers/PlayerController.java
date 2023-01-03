package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.PlayerDeleteDTO;
import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerRepo playerRepo;

    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @PostMapping
    public ResponseEntity registerPlayer(@RequestBody RegisterPlayerDTO registerPlayerDTO) {
        Optional<Player> player = playerRepo.register(registerPlayerDTO);
        if (player.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(player.get());
    }
    @GetMapping
    public ResponseEntity getAllPlayers(){
        Optional<List<Player>> players = playerRepo.getAllPlayers();
        if (players.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(players.get());
    }
    @PutMapping
    public ResponseEntity updatePlayer(@RequestBody Player player){
        Optional<Player> newPlayer = playerRepo.updatePlayer(player);
        if (newPlayer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(newPlayer.get());
    }
    @DeleteMapping
    public ResponseEntity deletePlayer(@RequestBody PlayerDeleteDTO playerDeleteDTO){
        boolean res = playerRepo.deletePlayer(playerDeleteDTO);
        if (!res) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("Deleted !");
    }
}

