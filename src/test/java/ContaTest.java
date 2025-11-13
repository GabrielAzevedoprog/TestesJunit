import br.com.unifacisa.gabriel.Conta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    // 1. Teste para atestar os requisitos de criação de Conta;
    @Test
    void deveCriarConta() {
        Conta contaTest = new Conta("1","Gabriel",100);

        // O assert verifica se o valor esperado (5) é igual ao valor real (resultado)
        assertEquals("1",contaTest.getNumero());
    }
}