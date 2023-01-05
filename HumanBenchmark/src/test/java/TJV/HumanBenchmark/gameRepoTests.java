package TJV.HumanBenchmark;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.GameByNameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.GameRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class gameRepoTests {

    @Autowired
    private GameRepo gameRepo;

    @MockBean
    private GameRepo gameRepoMock;

    @BeforeEach
    public void setup() {
        // Create mock objects
        Game game1 = mock(Game.class);
        Game game2 = mock(Game.class);

        // Set up mock behavior
        when(game1.getName()).thenReturn("Game 1");
        when(game2.getName()).thenReturn("Game 2");
        when(gameRepoMock.findAll()).thenReturn(List.of(game1, game2));
    }

    @Test
    public void testGetAllGames() {
        // Act
        Optional<List<Game>> games = gameRepo.getAllGames();

        // Assert
        assertTrue(games.isPresent());
        assertEquals(2, games.get().size());
        assertEquals("Game 1", games.get().get(0).getName());
        assertEquals("Game 2", games.get().get(1).getName());
    }
}