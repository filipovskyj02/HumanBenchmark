package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.CustomPlayerRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PlayerRepoImpl implements CustomPlayerRepo {

    public Player register(Player player,PlayerRepo playerRepo) {

        List<Player> a = playerRepo.findAll();
        for (Player p : a) {
            System.out.println(p.getName());
            System.out.println(player.getName());
            if (p.getEmail().equals(player.getEmail()) || (p.getName().equals( player.getName()))) {
                return p;
            }
        }
        return playerRepo.save(player);
    }
}
