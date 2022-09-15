package Programa;

public class Pessoa {

    private static int id;

    private String nome;
    private String cpf;
    private String email;


    public Pessoa(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Pessoa.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
                "\nCpf: " + this.getCpf() +
                "\nEmail: " + this.getEmail();
    }
}
