package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.ScoreRepo;
import TJV.HumanBenchmark.Services.AddScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreRepo scoreRepo;

    private final AddScoreService addScoreService;



    public ScoreController(AddScoreService addScoreService, ScoreRepo scoreRepo) {
        this.addScoreService = addScoreService;
        this.scoreRepo = scoreRepo;
    }

    @GetMapping("/{id}")
    ResponseEntity getScore(@PathVariable long id) {
        Optional<Score> score = scoreRepo.findById(id);
        if (score.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(score.get());
    }
    @GetMapping
    ResponseEntity getAllScores() {
        Optional<List<Score>> score = Optional.of(scoreRepo.findAll());
        if (score.isEmpty()) return ResponseEntity.ok("No scores!");
        return ResponseEntity.ok(score.get());
    }

    @PostMapping
    ResponseEntity addScore(@RequestBody ScoreDTO scoreDTO) {
        if (!addScoreService.addScoreToDb(scoreDTO)) return ResponseEntity.badRequest().body("Not present!");
        return ResponseEntity.ok("");
    }

    @GetMapping("/max")
    ResponseEntity getMaxScore(@RequestParam long playerId, @RequestParam long gameId) {
        MaxScoreDTO maxScoreDTO = new MaxScoreDTO(playerId, gameId);
        return ResponseEntity.ok(addScoreService.getMax(maxScoreDTO));
    }

    @GetMapping("/globalmax")
    ResponseEntity getGlobalMaxScore(@RequestParam long gameId) {
        GameByIdDTO gameByIdDTO = new GameByIdDTO(gameId);
        return ResponseEntity.ok(addScoreService.getGlobalMax(gameByIdDTO));
    }
    @DeleteMapping("/{id}")
    ResponseEntity deleteScore(@PathVariable long id) {
        boolean deleted = scoreRepo.deleteScoreById(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Deleted !");
    }
    @PutMapping("/{id}")
    ResponseEntity updateScore(@PathVariable long id,@RequestBody ScoreDTO scoreDTO) {
        Optional<Score> score= scoreRepo.update(id,scoreDTO);
        if (score.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(score.get());
    }
}