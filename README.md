# 🧪 Atividade 1 — Testes com JUnit 5 para a Classe Conta

## 📜 Descrição do Projeto

Este projeto consiste no desenvolvimento de uma suíte de testes unitários para a classe `Conta` (br.com.unifacisa.gabriel.Conta), utilizando o framework **JUnit 5 (JUnit Jupiter)**.

O objetivo é garantir a integridade e o comportamento correto dos métodos de gerenciamento da conta (criação, depósito, saque e transferência), validando cenários de sucesso (positivos) e falha (negativos/lançamento de exceções).

## ✨ Requisitos Mínimos Atendidos

O arquivo `ContaTest.java` foi estruturado para cumprir todos os requisitos propostos na atividade:

| Requisito | Método de Teste | Descrição |
| :--- | :--- | :--- |
| **Criação de Conta** | `deveCriarConta()` | Valida saldo inicial positivo (sucesso) e saldo negativo (lança `IllegalArgumentException`). |
| **Depósito** | `deveRealizarDeposito()` | Valida depósito com valor positivo (sucesso) e depósito com valor nulo/negativo (lança `IllegalArgumentException`). |
| **Saque** | `deveRealizarSaque()` | Valida saque com valor positivo e suficiente (sucesso). Testa saque de valor inválido (`IllegalArgumentException`) e saque maior que o saldo (`IllegalStateException`). |
| **Transferência** | `deveTransferencia()` | Valida transferência bem-sucedida entre duas contas e verifica a exceção ao tentar transferir para um destino nulo (`IllegalArgumentException`). |
| **`assertThrows`** | **Integrado** | O `assertThrows` é utilizado em múltiplos testes (`deveCriarConta`, `deveRealizarDeposito`, `deveRealizarSaque`, `deveTransferencia`) para verificar o lançamento de `IllegalArgumentException` e `IllegalStateException`. |
| **Teste Parametrizado** | `deveAumentarOSaldoAposDeposito()` | Utiliza **`@ParameterizedTest`** e **`@CsvSource`** para validar diversos cenários de depósito com uma única lógica de teste. |

---

## ⚙️ Configuração e Execução

Para rodar os testes, siga os passos abaixo.

### Pré-requisitos

* **Java Development Kit (JDK)** versão 8 ou superior.
* Um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA, Eclipse ou VS Code com suporte a Maven/Gradle.

### Dependências (Maven)

Se você estiver usando **Maven**, certifique-se de que as seguintes dependências estejam presentes no seu arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.1</version> <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.10.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
