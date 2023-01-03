package TJV.HumanBenchmark.Controllers;

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
}
