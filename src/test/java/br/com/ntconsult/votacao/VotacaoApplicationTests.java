package br.com.ntconsult.votacao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@WebAppConfiguration
public class VotacaoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
