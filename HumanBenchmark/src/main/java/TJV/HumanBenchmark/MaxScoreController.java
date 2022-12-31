
package TJV.HumanBenchmark;

import TJV.HumanBenchmark.DTOs.GameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maxscore")
public class MaxScoreController {
    private final MaxScoreRepo maxScoreRepo;

    public MaxScoreController(MaxScoreRepo maxScoreRepo) {
        this.maxScoreRepo = maxScoreRepo;
    }
    /*
    @RequestMapping("/byid")
    @GetMapping
    ResponseEntity getPlayerHighscore(@RequestBody MaxScoreDto maxScoreDto){
        return ResponseEntity.ok(maxScoreRepo.getMaxScoreById(maxScoreDto));
    }
    @RequestMapping("/bygame")
    @GetMapping
    ResponseEntity getGameHighscore(@RequestBody GameDTO gameDTO){
        return ResponseEntity.ok(maxScoreRepo.getMaxScoreForGame(gameDTO));
    }
    */

}
