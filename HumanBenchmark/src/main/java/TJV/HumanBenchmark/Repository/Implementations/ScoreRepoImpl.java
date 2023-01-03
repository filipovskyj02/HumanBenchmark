package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.*;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ScoreRepoImpl implements CustomScoreRepo {
    @Autowired
    @Lazy
    ScoreRepo scoreRepo;
    @Autowired
    @Lazy
    MaxScoreRepo maxScoreRepo;

    @Autowired
    @Lazy
    GameRepo gameRepo;
    @Autowired
    @Lazy
    PlayerRepo playerRepo;
    @Override
    public ResponseEntity addScore (ScoreDTO scoreDTO)  {
        Optional<Player> player = playerRepo.findById(scoreDTO.getId_player());
        System.out.println(scoreDTO.getId_player() + " JE USER ID");
        if (!player.isPresent()) return ResponseEntity.badRequest().body("User not present!");

        Optional<Game> game = gameRepo.findById(scoreDTO.getId_game());
        System.out.println(scoreDTO.getId_game() + " JE GAME ID");
        if (!game.isPresent()) return ResponseEntity.badRequest().body("Game not present !");
        Score fullScore = new Score(scoreDTO.getScore(),player.get(),game.get());

        player.get().addScore(fullScore);
        game.get().addScore(fullScore);
        scoreRepo.save(fullScore);

        if (maxScoreRepo.checkScore(fullScore,player.get(),game.get()) == 1)
            return ResponseEntity.ok("Highscore set !");



        return ResponseEntity.ok("Score added !");
        }


    }

