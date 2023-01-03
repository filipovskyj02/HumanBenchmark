package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.MedalDescDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.MedalRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medal")
public class MedalController {

    private final MedalRepo medalRepo;

    public MedalController(MedalRepo medalRepo) {
        this.medalRepo = medalRepo;
    }

    @GetMapping
    ResponseEntity getAll(){
        Optional<List<Medal>> medals = medalRepo.getAllMedals();
        if (medals.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(medals.get());
    }
    @PostMapping
    ResponseEntity addMedal(@RequestBody MedalDescDTO medalDescDTO){
        Optional<Medal> medal = medalRepo.addMedal(medalDescDTO);
        if (medal.isEmpty()) return ResponseEntity.badRequest().body("Already Present !");
        return ResponseEntity.ok().body("Added !");

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
