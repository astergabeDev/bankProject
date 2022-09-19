package Programa;

import utilitarios.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

        contasBancarias = new ArrayList<Conta>();

        operacoes();
    }

    public static void operacoes() {

        boolean menu = true;
        while (menu) {
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
            System.out.println("|     6 - Alterar dados  |");
            System.out.println("|     7 - Sair           |");


            int operacao = input.nextInt();

            switch (operacao) {

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
                    alterarDados();
                    break;
                case 7:
                    System.out.println("Fechando programa...");
                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("...");
                    menu = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCpf: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa, Conta.getIdConta());

        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso!");
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }
    public static void depositar() {

        System.out.println("Insira o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
            System.out.println("Seu novo saldo é de: " + Utils.doubleToString(conta.getSaldo()));

        } else {
            System.out.println("Não foi possivel achar a conta para deposito");
        }
    }

    public static void sacar() {

        System.out.println("Insira o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor sacado com sucesso!");
            System.out.println("Seu novo saldo é de: " + Utils.doubleToString(conta.getSaldo()));

        } else {
            System.out.println("Não foi possivel achar a conta para saque");
        }
    }

    public static void transferir() {

        System.out.println("Insira o numero da conta remetente: ");
        int contaRemetente = input.nextInt();

        Conta remetente = encontrarConta(contaRemetente);

        if (remetente != null) {
            System.out.println("Insira o numero da conta destinataria: ");
            int contaDestinataria = input.nextInt();

            Conta destinataria = encontrarConta(contaDestinataria);

            if (destinataria != null) {
                System.out.println("Qual valor deseja transferir? ");
                double valorTrans = input.nextDouble();

                remetente.transferir(destinataria, valorTrans);
                System.out.println("Valor transferido com sucesso!");
                System.out.println("Seu novo saldo é de: " + Utils.doubleToString(remetente.getSaldo()));

            } else {
                System.out.println("Não foi possivel achar a conta destinataria");
            }
        } else {
            System.out.println("Não foi possivel achar a conta remetente");
        }
    }

    public static void listar() {

        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Nao há contas cadastradas!");
        }

    }

    public static void alterarDados(){

        System.out.println("Insira o numero da conta que deseja alterar os dados: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Quais dados você deseja alterar: ");
            System.out.println("1 - Nome");
            System.out.println("2 - Cpf");
            System.out.println("3 - Email");
            int escolha = input.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("Insira o novo nome: ");
                    String novoNome = input.next();
                    conta.getPessoa().setNome(novoNome);
                    break;
                case 2:
                    System.out.println("Insira o novo cpf: ");
                    String novoCpf = input.next();
                    conta.getPessoa().setCpf(novoCpf);
                    break;
                case 3:
                    System.out.println("Insira o novo email: ");
                    String novoEmail = input.next();
                    conta.getPessoa().setEmail(novoEmail);
                    break;
                default:
                    System.out.println("Insira uma opção valida");
                    break;
            }
        }else{
            System.out.println("Insira um numero de conta válido.");
        }

    }

}