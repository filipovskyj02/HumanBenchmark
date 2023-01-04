package TJV.HumanBenchmark;

import TJV.HumanBenchmark.DTOs.RegisterPlayerDTO;
import TJV.HumanBenchmark.Model.Player;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreatePlayer() {

        // Set up test data
        RegisterPlayerDTO registerPlayerDTO = new RegisterPlayerDTO();
        registerPlayerDTO.setName("Jakubs kek");
        registerPlayerDTO.setEmail("f@gmaisds.com");
        registerPlayerDTO.setPassword("kek1");

        // Perform test
        ResponseEntity<Player> response = restTemplate.postForEntity("/player", registerPlayerDTO, Player.class);

        // Verify results
        Player createdPlayer = response.getBody();



    }
}
