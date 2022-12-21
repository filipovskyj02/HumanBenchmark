package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerRepo playerRepo;

    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.playerRepo.findAll());
    }

};
