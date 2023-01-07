package TJV.HumanBenchmark.Controllers;

import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@WebMvcTest(PlayerController.class)
@RunWith(SpringRunner.class)
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepo playerRepo;
    @Test
    public void testGetPlayers() throws Exception {
        // Set up mock data
        List<Player> players = Arrays.asList(new Player("testname", "John", "Doe"), new Player("idk", "Jane", "Doe"));
        Mockito.when(playerRepo.findAll()).thenReturn(players);
        mockMvc.perform(MockMvcRequestBuilders.get("/player")).andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void testAddPlayer() throws Exception {
        RegisterPlayerDTO playerDTO = new RegisterPlayerDTO("testname", "testmail", "pass");
        Player player = new Player("testname","testmail","pass");
        String playerJson = "{\"name\": \"testname\", \"email\": \"testmail\", \"password\": \"pass\"}";
        Mockito.when(playerRepo.register(Mockito.any())).thenReturn(Optional.of(player));
        mockMvc.perform(MockMvcRequestBuilders.post("/player/register")
                        .contentType(MediaType.APPLICATION_JSON).content(playerJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}
