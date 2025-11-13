import br.com.unifacisa.gabriel.Conta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    // 1. Teste de criação de conta (saldo inicial válido e inválido);
    @Test
    void deveCriarConta() {
        Conta contaSaldoValido = new Conta("1","Gabriel",100);

        // O assert verifica se o valor esperado (100) de saldo é igual ao valor real (saldoInicial)
        assertEquals(100,contaSaldoValido.getSaldo());

        // O assert verifica se o valor esperado (100) de saldo é igual ao valor real (saldoInicial)
        assertThrows(IllegalArgumentException.class, () -> {
            Conta contaSaldoInvalido = new Conta("2","Gabriel",-100);
        });
    }

    // 2. Testes de depósito (um válido, um inválido);
    @Test
    void deveRealizarDeposito() {
        Conta contaGabriel = new Conta("1", "Gabriel", 200);
        Conta contaAbella = new Conta("2", "Abella", 1000);

        contaAbella.depositar(200);

        // O assert verifica se o valor do deposito foi depositado com sucesso do saldo da conta de Abella;
        assertEquals(1200, contaAbella.getSaldo());

        // O assert verifica se o valor do deposito é inválido (valor <= 0);
        assertThrows(IllegalArgumentException.class, () -> contaGabriel.depositar(0));
    }

    // 3. Testes de saque (um válido, um inválido);
    @Test
    void deveRealizarSaque() {
        Conta contaGabriel = new Conta("1","Gabriel",200);
        Conta contaAbella = new Conta("2","Abella",1000);

        contaAbella.sacar(200);

        // O assert verifica se o valor do saque foi sacado com sucesso do saldo da conta de Abella;
        assertEquals(800,contaAbella.getSaldo());

        // O assert verifica se o valor de saque é inválido (valor <= 0);
        assertThrows(IllegalArgumentException.class, () -> contaAbella.sacar(0));

        // O assert verifica se o valor de saque é maior que o valor do saldo;
        assertThrows(IllegalStateException.class, () -> contaGabriel.sacar(300));
    }

    // 4. Teste de transferência entre contas;
    @Test
    void deveTransferencia() {
        Conta contaGabriel = new Conta("1","Gabriel",200);
        Conta contaAbella = new Conta("2","Abella",1800);

        contaAbella.transferirPara(contaGabriel,800);

        // O assert verifica se o valor da transferencia foi transferido com sucesso do saldo da conta de Abella para a conta de Gabriel;
        assertEquals(1000,contaAbella.getSaldo());
        assertEquals(1000, contaGabriel.getSaldo());

        // O assert verifica se o destinatario da transferencia é inválido (destino == null);
        assertThrows(IllegalArgumentException.class, () -> contaGabriel.transferirPara(null,800));
    }

    // 5. Teste parametrizado usando @ParameterizedTest.
    @ParameterizedTest()
    @CsvSource({ //saldoInicial, valorDeposito, saldoEsperado
            "100.0, 50.0, 150.0",
            "0.01, 99.99, 100.0",
            "500.0, 0.01, 500.01"
    })
    void deveAumentarOSaldoAposDeposito(double saldoInicial, double valorDeposito, double saldoEsperado) {

        // Cria a conta com o saldo inicial do parâmetro
        Conta conta = new Conta("1", "Gabriel", saldoInicial);

        // Realiza o depósito
        conta.depositar(valorDeposito);

        // Verifica se o saldo final é o esperado
        assertEquals(saldoEsperado, conta.getSaldo(),
                "O saldo após o depósito deve ser igual ao valor esperado.");
    }
}