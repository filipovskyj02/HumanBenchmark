package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.NewGameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.CustomGameRepo;
import TJV.HumanBenchmark.Repository.GameRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class GameRepoImpl implements CustomGameRepo {
    @Autowired
    @Lazy
    GameRepo gameRepo;
    @Override
    public ResponseEntity addGame(NewGameDTO newGameDTO){
        if (gameRepo.count() > 0){
            for(Game g: gameRepo.findAll()){
                if ((g.getName().equals(newGameDTO.getName()))){
                    return ResponseEntity.badRequest().body("Game already present !");
                }
            }
        }
        Game newGame = new Game(newGameDTO.getName());
        gameRepo.save(newGame);
        return ResponseEntity.ok("Game added !");
    }
    @Override
    public ResponseEntity getAllGames(){
        if (gameRepo.count() == 0) return ResponseEntity.badRequest().body("There are no games in the db");
        else return ResponseEntity.ok(gameRepo.findAll());
    }

}
