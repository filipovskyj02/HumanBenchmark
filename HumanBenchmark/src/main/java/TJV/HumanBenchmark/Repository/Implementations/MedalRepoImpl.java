package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.MedalAwardDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.DTOs.MedalNameDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMedalRepo;
import TJV.HumanBenchmark.Repository.MedalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public class MedalRepoImpl implements CustomMedalRepo {

    @Autowired
    @Lazy
    MedalRepo medalRepo;
    @Override
    public Optional<Medal> addMedal(MedalNameDescDTO medalNameDescDTO){
        Optional<Medal> medal = medalRepo.findByname(medalNameDescDTO.getName());
        if (medal.isPresent()) return Optional.empty();
        return Optional.of(medalRepo.save(new Medal(medalNameDescDTO.getName(),medalNameDescDTO.getDescription())));
    }
    @Override
    public Optional<List<Medal>> getAllMedals(){
        if (medalRepo.count() == 0) return Optional.empty();
        return Optional.of(medalRepo.findAll());

    }
    @Override
    public boolean deleteMedal(long id){
        Optional<Medal> medal = medalRepo.findById(id);
        if (medal.isEmpty()) return false;
        medalRepo.deleteById(id);

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
