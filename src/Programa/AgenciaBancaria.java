package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

        contasBancarias = new ArrayList<Conta>();

        operacoes();


    }

    public static void operacoes(){

        System.out.println("--------------------------------------");
        System.out.println("------Bem vindos a nossa Agência------");
        System.out.println("--------------------------------------");
        System.out.println("******* Selecione uma operação *******");
        System.out.println("--------------------------------------");
        System.out.println("|     1 - Criar conta    |");
        System.out.println("|     2 - Depositar      |");
        System.out.println("|     3 - Sacar          |");
        System.out.println("|     4 - Transferir     |");
        System.out.println("|     5 - Listar         |");
        System.out.println("|     6 - Sair           |");

        int operacao = input.nextInt();

        switch (operacao){

            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Fechando programa...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida");
                operacoes();
                break;
        }
    }
    public static void criarConta(){

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCpf: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for (Conta c: contasBancarias) {
                if (c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar(){

        System.out.println("Insira o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Qual valor deseja depositar? ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        }else {
            System.out.println("Não foi possivel achar a conta para deposito");
        }
        operacoes();
    }

    public static void sacar(){

        System.out.println("Insira o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Qual valor deseja sacar? ");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor sacado com sucesso!");
        }else {
            System.out.println("Não foi possivel achar a conta para saque");
        }
        operacoes();
    }

    public static void transferir(){

        System.out.println("Insira o numero da conta remetente: ");
        int contaRemetente = input.nextInt();

        Conta remetente = encontrarConta(contaRemetente);

        if (remetente != null){
            System.out.println("Insira o numero da conta destinataria: ");
            int contaDestinataria = input.nextInt();

            Conta destinataria = encontrarConta(contaDestinataria);

            if (destinataria != null) {
                System.out.println("Qual valor deseja transferir? ");
                double valorTrans = input.nextDouble();

                remetente.transferir(destinataria, valorTrans);
                System.out.println("Valor transferido com sucesso!");
            }
        }else {
            System.out.println("Não foi possivel concluir a transferencia");
        }



    }

}