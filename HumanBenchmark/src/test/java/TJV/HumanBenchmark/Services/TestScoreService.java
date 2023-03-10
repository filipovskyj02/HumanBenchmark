package TJV.HumanBenchmark.Services;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Repository.MaxScoreRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestScoreService {
    @Autowired
    private AddScoreService addScoreService;
    @MockBean
    private MaxScoreRepo maxScoreRepo;


    @Test
    public void checkAndUpdateTest(){
        MaxScore currMaxScore = new MaxScore(100,1L,1L);
        Mockito.when(maxScoreRepo.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(maxScoreRepo.getReferenceById(Mockito.any())).thenReturn(currMaxScore);
        addScoreService.checkAndUpdateMax(new ScoreDTO(1,1,150));
        int res = maxScoreRepo.getReferenceById(new MaxScore.MaxScoreId(1L,1L)).getScore();
        assertEquals(res,150);



    }
}
