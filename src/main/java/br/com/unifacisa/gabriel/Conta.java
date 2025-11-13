package br.com.unifacisa.gabriel;

public class Conta {
    private final String numero;
    private final String titular;
    private double saldo;

    public Conta(String numero, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
    }

    public void transferirPara( Conta destino, double valor) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta destino inválida");
        }
        this.sacar(valor);
        destino.depositar(valor);
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }
}