package TJV.HumanBenchmark.Services;

import TJV.HumanBenchmark.DTOs.MedalAwardDTO;
import TJV.HumanBenchmark.DTOs.MedalIdDescDTO;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.MedalRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class MedalService {
    @Autowired
    @Lazy
    PlayerRepo playerRepo;
    @Autowired
    @Lazy
    MedalRepo medalRepo;

    public int awardMedal(MedalAwardDTO medalAwardDTO){
        Optional<Medal> medal = medalRepo.findByname(medalAwardDTO.getName());
        if (medal.isEmpty()) return -1;
        Optional<Player> player = playerRepo.findById(medalAwardDTO.getId_player());
        if (player.isEmpty()) return -1;
        for (Medal lop : player.get().getMedals()){
            System.out.println(lop.getName() + " ======== " + medalAwardDTO.getName());
            if(lop.getName().equals(medalAwardDTO.getName())) return 0;
        }
        player.get().getMedals().add(medal.get());
        playerRepo.save(player.get());
        medalRepo.save(medal.get());

        return 1;



    }
}
