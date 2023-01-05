package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.GameByNameDTO;
import TJV.HumanBenchmark.DTOs.GameIdNameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomGameRepo;
import TJV.HumanBenchmark.Repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

public class GameRepoImpl implements CustomGameRepo {
    @Autowired
    @Lazy
    GameRepo gameRepo;
    @Override
    public Optional<Game> addGame(GameByNameDTO gameByNameDTO) {
        if (gameRepo.findByname(gameByNameDTO.getName()).isPresent()) return Optional.empty();
        Game newGame = new Game(gameByNameDTO.getName());
        return Optional.of(gameRepo.save(newGame));
    }
    @Override
    public Optional<List<Game>> getAllGames(){
        if (gameRepo.count() == 0) return Optional.empty();
        else return Optional.of(gameRepo.findAll());
    }
    @Override
    public Boolean deleteGame(long id){
        if (!gameRepo.existsById(id)) return false;
        gameRepo.deleteById(id);
        return true;

    }
    @Override
    public Optional<Game> fixGameName(GameIdNameDTO gameIdNameDTO){
        if (!gameRepo.existsById(gameIdNameDTO.getId_game())) return Optional.empty();
        Game game = gameRepo.getReferenceById(gameIdNameDTO.getId_game());
        game.setName(gameIdNameDTO.getName());
        gameRepo.flush();
        return Optional.of(game);
    }


}
