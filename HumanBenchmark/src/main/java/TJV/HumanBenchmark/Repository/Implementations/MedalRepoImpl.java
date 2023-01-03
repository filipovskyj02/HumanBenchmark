package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.MedalDescDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMedalRepo;
import TJV.HumanBenchmark.Repository.MedalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

public class MedalRepoImpl implements CustomMedalRepo {

    @Autowired
    @Lazy
    MedalRepo medalRepo;
    @Override
    public Optional<Medal> addMedal(MedalDescDTO medalDescDTO){
        Optional<Medal> medal = medalRepo.findBydescription(medalDescDTO.getDescription());
        if (medal.isPresent()) return Optional.empty();
        return Optional.of(medalRepo.save(new Medal(medalDescDTO.getDescription())));
    }
    @Override
    public Optional<List<Medal>> getAllMedals(){
        if (medalRepo.count() == 0) return Optional.empty();
        return Optional.of(medalRepo.findAll());

    }
    @Override
    public boolean deleteMedal(MedalIdDTO medalIdDTO){
        Optional<Medal> medal = medalRepo.findById(medalIdDTO.getId_medal());
        if (medal.isEmpty()) return false;
        medalRepo.deleteById(medalIdDTO.getId_medal());
        return true;

    }
    @Override
    public Optional<Medal> updateMedal(MedalIdDescDTO medalIdDescDTO){
       Optional<Medal> medal =  medalRepo.findById(medalIdDescDTO.getId_medal());
       if (medal.isEmpty()) return Optional.empty();
       Medal medalRef = medalRepo.getReferenceById(medalIdDescDTO.getId_medal());
       medalRef.setDescription(medalIdDescDTO.getDescription());
       medalRepo.flush();
       return Optional.of(medalRef);

    }


}
