package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.PlayerDeleteDTO;
import TJV.HumanBenchmark.DTOs.PlayerLoginDTO;
import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomPlayerRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

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
    public Optional<Player> loginPlayer(PlayerLoginDTO loginDTO){
        Optional<Player> player= playerRepo.findByemail(loginDTO.getEmail());
        if (player.isEmpty()) return Optional.empty();
        if (player.get().getPassword().equals(loginDTO.getPassword())) return player;
        else return Optional.empty();
    }

    @Override
    public boolean deletePlayer(long id){
        if(playerRepo.existsById(id) == false) return false;
        playerRepo.deleteById(id);
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
