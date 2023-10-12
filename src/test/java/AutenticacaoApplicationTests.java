import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest
public class AutenticacaoApplicationTests {
    @Autowired
    WebTestClient webTestClient;

//    @Test
//    public void testAutenticacaoSucesso(){
//        var Login = "adm@adm.com";
//        var senha ="123456";
//
//        webTestClient
//                .post()
//                .uri("/login")
//                .bodyValue(Login,senha);
//
//
//    }
}
