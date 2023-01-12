package TJV.HumanBenchmark.Services;

import TJV.HumanBenchmark.Model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetWithMostService {
    @PersistenceContext
    private EntityManager em;

    public Optional<Player> findPlayerWithMostGames() {
        String jpql = "SELECT p FROM Player p JOIN p.scores s JOIN s.game g GROUP BY p.id_player ORDER BY COUNT(g) DESC";
        Query query = em.createQuery(jpql);
        query.setMaxResults(1);
        List<Player> players = query.getResultList();
        if (players.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(players.get(0));
        }
    }


}

