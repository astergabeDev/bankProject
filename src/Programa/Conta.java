package Programa;

public class Conta {

    private static int idConta = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0;

    public Conta(int numeroConta, Pessoa pessoa, double saldo) {
        this.numeroConta = numeroConta;
        this.pessoa = pessoa;
        this.saldo = saldo;
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
}
