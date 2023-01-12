package TJV.HumanBenchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class HumanBenchmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanBenchmarkApplication.class, args);
	}


}

