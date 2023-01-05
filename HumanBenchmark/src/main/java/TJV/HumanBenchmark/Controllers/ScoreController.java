package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Services.AddScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final AddScoreService addScoreService;

    public ScoreController(AddScoreService addScoreService) {
        this.addScoreService = addScoreService;
    }


    @PostMapping
    ResponseEntity addScore(@RequestBody ScoreDTO scoreDTO){
        if ( addScoreService.addScoreToDb(scoreDTO)  == false ) return ResponseEntity.badRequest().body("Not present !");
        return ResponseEntity.ok().body(scoreDTO);

    }
    @RequestMapping("/max")
    @PostMapping
    ResponseEntity getMaxScore(@RequestBody MaxScoreDTO maxScoreDTO){
        return ResponseEntity.ok(addScoreService.getMax(maxScoreDTO));
    }
    @RequestMapping("/globalmax")
    @PostMapping
    ResponseEntity getGlobalMaxScore(@RequestBody GameByIdDTO gameByIdDTO){
        return ResponseEntity.ok(addScoreService.getGlobalMax(gameByIdDTO));
    }
}
