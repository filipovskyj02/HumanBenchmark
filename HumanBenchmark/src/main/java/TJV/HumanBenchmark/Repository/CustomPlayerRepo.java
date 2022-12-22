package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomPlayerRepo {
    Player register(Player player,PlayerRepo playerRepo);
}
