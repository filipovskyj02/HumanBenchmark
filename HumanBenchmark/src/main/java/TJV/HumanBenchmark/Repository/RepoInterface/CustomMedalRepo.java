package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.*;
import TJV.HumanBenchmark.Model.Medal;

import java.util.List;
import java.util.Optional;

public interface CustomMedalRepo {


    Optional<Medal> addMedal(MedalNameDescDTO medalNameDescDTO);

    Optional<List<Medal>> getAllMedals();

    boolean deleteMedal(long id);

    Optional<Medal> updateMedal(MedalIdDescDTO medalIdDescDTO);


}
