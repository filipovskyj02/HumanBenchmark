package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.ScoreRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreRepo scoreRepo;

    ScoreController(ScoreRepo scoreRepo){this.scoreRepo = scoreRepo;}
    @PostMapping
    ResponseEntity addScore(@RequestBody ScoreDTO scoreDTO){
        return scoreRepo.addScore(scoreDTO);


    }
}
