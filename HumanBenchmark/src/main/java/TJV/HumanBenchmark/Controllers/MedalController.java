package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.MedalAwardDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.DTOs.MedalNameDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.MedalRepo;
import TJV.HumanBenchmark.Services.MedalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medal")
public class MedalController {

    private final MedalRepo medalRepo;
    private final MedalService medalService;

    public MedalController(MedalRepo medalRepo, MedalService medalService) {
        this.medalRepo = medalRepo;
        this.medalService = medalService;
    }

    @GetMapping
    ResponseEntity getAll(){
        Optional<List<Medal>> medals = medalRepo.getAllMedals();
        if (medals.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(medals.get());
    }
    @PostMapping
    ResponseEntity addMedal(@RequestBody MedalNameDescDTO medalNameDescDTO){
        Optional<Medal> medal = medalRepo.addMedal(medalNameDescDTO);
        if (medal.isEmpty()) return ResponseEntity.badRequest().body("Already Present !");
        return ResponseEntity.ok().body("Added !");

    }
    @PostMapping
    @RequestMapping("/award")
    ResponseEntity awardMedal(@RequestBody MedalAwardDTO medalAwardDTO){
        int res = medalService.awardMedal(medalAwardDTO);
        if (res == -1) return ResponseEntity.badRequest().body("Not Present !");
        if (res == 0) return ResponseEntity.ok().body("Player already has the medal");
        return ResponseEntity.ok().body("Medal Awarded !");

    }
    @DeleteMapping
    ResponseEntity deleteMedal(@RequestBody MedalIdDTO medalIdDTO){
        if (!medalRepo.deleteMedal(medalIdDTO)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("Deleted");

    }
    @PutMapping
    ResponseEntity updateMedal(@RequestBody MedalIdDescDTO medalIdDescDTO){
        Optional<Medal> medal = medalRepo.updateMedal(medalIdDescDTO);
        if (medal.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(medal.get());
    }
}
