package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.*;
import TJV.HumanBenchmark.Model.Medal;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CustomMedalRepo {


    Optional<Medal> addMedal(MedalNameDescDTO medalNameDescDTO);

    Optional<List<Medal>> getAllMedals();

    boolean deleteMedal(MedalIdDTO medalIdDTO);

    Optional<Medal> updateMedal(MedalIdDescDTO medalIdDescDTO);


}
