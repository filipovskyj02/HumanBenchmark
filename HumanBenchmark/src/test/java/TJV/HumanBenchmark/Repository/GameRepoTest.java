package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.DTOs.GameByNameDTO;

import TJV.HumanBenchmark.DTOs.GameIdNameDTO;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@PropertySource("classpath:/application-test.properties")
@TestPropertySource(properties = "spring.config.name=test")
public class GameRepoTest {

    @Autowired
    private GameRepo gameRepo;


    @AfterEach
    void cleanUp(){
      gameRepo.deleteAll();
    }
    @Test
    public void testAddGame(){

        //Returns class
        assertTrue(gameRepo.addGame(new GameByNameDTO("Test1")).isPresent());
        assertTrue(gameRepo.addGame(new GameByNameDTO("Test2")).isPresent());
        assertTrue(gameRepo.addGame(new GameByNameDTO("Test3")).isPresent());
        //Does not create duplicate
        assertFalse(gameRepo.addGame(new GameByNameDTO("Test1")).isPresent());
        assertTrue(gameRepo.getAllGames().isPresent());
        assertEquals(3,gameRepo.getAllGames().get().size());

    }
    @Test
    public void testDeleteGame(){
        assertTrue(gameRepo.getAllGames().isEmpty());
        assertTrue(gameRepo.addGame(new GameByNameDTO("TestDel")).isPresent());
        assertTrue(gameRepo.getAllGames().isPresent());
        assertEquals(1,gameRepo.getAllGames().get().size());
        long id = gameRepo.getAllGames().get().get(0).getId_game();
        assertTrue(gameRepo.deleteGame(id));
        assertTrue(gameRepo.getAllGames().isEmpty());
    }
    @Test
    public void testUpdateGame(){
        assertTrue(gameRepo.addGame(new GameByNameDTO("TestDel")).isPresent());
        assertTrue(gameRepo.getAllGames().isPresent());
        assertEquals(1,gameRepo.getAllGames().get().size());
        long id = gameRepo.getAllGames().get().get(0).getId_game();
        assertTrue(gameRepo.fixGameName(new GameIdNameDTO(id,"NewName")).isPresent());
        assertEquals(gameRepo.getReferenceById(id).getName(),"NewName");

    }

}
