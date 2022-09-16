package Programa;

import utilitarios.Utils;

public class Conta {

    private static int idConta = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0;

    public Conta(Pessoa pessoa, int id) {
        this.numeroConta = idConta;
        this.pessoa = pessoa;
        idConta++;

    }

    public static int getIdConta() {
        return idConta;
    }

    public static void setIdConta(int idConta) {
        Conta.idConta = idConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCpf: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.saldo) +
                "\n";
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            setSaldo(getSaldo() - valor);
        }
    }

    public void transferir(Conta contaParaDeposito, double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
        }
    }


}
