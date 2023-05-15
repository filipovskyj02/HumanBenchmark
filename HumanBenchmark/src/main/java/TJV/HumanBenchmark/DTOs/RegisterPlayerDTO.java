package TJV.HumanBenchmark.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterPlayerDTO {
    private String name;
    private String email;

    private String password;
}
