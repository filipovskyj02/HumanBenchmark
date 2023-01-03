package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.PlayerDeleteDTO;
import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomPlayerRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

public class PlayerRepoImpl implements CustomPlayerRepo {
    @Autowired
    @Lazy
    PlayerRepo playerRepo;
    @Override
    public Optional<Player> register(RegisterPlayerDTO registerPlayerDTO) {
         Optional<Player> player = playerRepo.findByemail(registerPlayerDTO.getEmail());
         if (player.isPresent()) return Optional.empty();
         Player newPlayer = new Player(registerPlayerDTO.getName(), registerPlayerDTO.getEmail(), registerPlayerDTO.getPassword());
         playerRepo.save(newPlayer);
         return Optional.of(newPlayer);
    }
    @Override
    public Optional<List<Player>> getAllPlayers(){
        if (playerRepo.count() == 0) return Optional.empty();
        return Optional.of(playerRepo.findAll());
    }
    @Override
    public boolean deletePlayer(PlayerDeleteDTO playerDeleteDTO){
        if(playerRepo.existsById(playerDeleteDTO.getId()) == false) return false;
        playerRepo.deleteById(playerDeleteDTO.getId());
        return true;
    }
    @Override
    public Optional<Player> updatePlayer(Player player){
        if (playerRepo.existsById(player.getId_player()) == false) return Optional.empty();
        Player newPlayer = playerRepo.getReferenceById(player.getId_player());
        newPlayer.setEmail(player.getEmail());
        newPlayer.setName(player.getName());
        newPlayer.setPassword(player.getPassword());
        playerRepo.flush();
        return Optional.of(newPlayer);
    }
}
