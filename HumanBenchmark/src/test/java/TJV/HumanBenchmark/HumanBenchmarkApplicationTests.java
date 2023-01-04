package TJV.HumanBenchmark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HumanBenchmarkApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testController(){
		PlayerControllerTests playerControllerTests = new PlayerControllerTests();
		playerControllerTests.testCreatePlayer();
	}

}
