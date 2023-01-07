package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.OutPlayerLoginDTO;
import TJV.HumanBenchmark.DTOs.PlayerDeleteDTO;
import TJV.HumanBenchmark.DTOs.PlayerLoginDTO;
import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerRepo playerRepo;


    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity getPlayerById(@PathVariable long id) {
        Optional<Player> player = playerRepo.findById(id);
        if (player.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(player.get());
    }
    @GetMapping
    ResponseEntity getAllPlayers() {
        Optional<List<Player>> players = Optional.of(playerRepo.findAll());
        if (players.isEmpty())  return ResponseEntity.ok("No players present!");
        return ResponseEntity.ok(players.get());
    }

    //Data stored in body for safety reasons, therefore using POST
    @PostMapping("/register")
    public ResponseEntity registerPlayer(@RequestBody RegisterPlayerDTO registerPlayerDTO) throws URISyntaxException {
        System.out.println(registerPlayerDTO.getPassword() + "OMHOMFGOMGOMOMGOMHOHMOH");
        Optional<Player> player = playerRepo.register(registerPlayerDTO);
        System.out.println(player.get().getId_player());
        if (player.isEmpty()) return ResponseEntity.badRequest().body("Email already present !");
        return ResponseEntity.created(new URI("/player/" + player.get().getId_player())).build();
    }
    //Data stored in body for safety reasons, therefore using POST
    @PostMapping("/login")
    public ResponseEntity loginPlayer(@RequestBody PlayerLoginDTO loginDTO){
        Optional<Player> player = playerRepo.loginPlayer(loginDTO);
        if (player.isEmpty()) return ResponseEntity.notFound().build();
        OutPlayerLoginDTO res = new OutPlayerLoginDTO(player.get().getId_player(),player.get().getName());
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity updatePlayer(@RequestBody Player player){
        Optional<Player> newPlayer = playerRepo.updatePlayer(player);
        if (newPlayer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(newPlayer.get());
    }

    @DeleteMapping("/{id}")

    public ResponseEntity deletePlayer(@PathVariable long id){
       boolean res = playerRepo.deletePlayer(id);
       if (!res) return ResponseEntity.notFound().build();
       return ResponseEntity.ok("Deleted");
    }
}
