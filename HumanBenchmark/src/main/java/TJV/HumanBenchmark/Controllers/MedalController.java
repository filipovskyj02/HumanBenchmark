package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.MedalAwardDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.DTOs.MedalNameDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.MedalRepo;
import TJV.HumanBenchmark.Services.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
        if (medals.isEmpty()) return ResponseEntity.ok("No medals present!");
        return ResponseEntity.ok(medals.get());
    }
    @PostMapping
    ResponseEntity addMedal(@RequestBody MedalNameDescDTO medalNameDescDTO) throws URISyntaxException {
        Optional<Medal> medal = medalRepo.addMedal(medalNameDescDTO);
        if (medal.isEmpty()) return ResponseEntity.badRequest().body("Already Present !");
        return ResponseEntity.created(new URI("/medal/" + medal.get().getId_medal())).build();
    }
    @PostMapping
    @RequestMapping("/award")
    ResponseEntity awardMedal(@RequestBody MedalAwardDTO medalAwardDTO){
        int res = medalService.awardMedal(medalAwardDTO);
        if (res == -1) return ResponseEntity.badRequest().body("Not Present !");
        if (res == 0) return ResponseEntity.ok().body("Player already has the medal");
        return ResponseEntity.ok().body("Medal Awarded !");
    }
    @DeleteMapping("/{id}")
    ResponseEntity deleteMedal(@PathVariable long id ){

        if (!medalRepo.deleteMedal(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("Deleted");
    }
    @PutMapping
    ResponseEntity updateMedal(@RequestBody MedalIdDescDTO medalIdDescDTO){
        Optional<Medal> medal = medalRepo.updateMedal(medalIdDescDTO);
        if (medal.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(medal.get());
    }

}
