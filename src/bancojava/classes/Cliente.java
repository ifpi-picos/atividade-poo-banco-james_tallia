package bancojava.classes;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private final LocalDate datanascimento;
    private final String cpf;
    private Endereco endereco;

    public Cliente(String nome, LocalDate datanascimento, String cpf, Endereco endereco) {
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.endereco = endereco;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;

    }
    public String getCidadeEndereco(){
        return this.endereco.getCidade();
    }
    public String getUfEndereco(){
        return this.endereco.getUf();
    }
    public String getLogradouroEndereco (){
        return this.endereco.getLogradouro();
    }
    public int getNumeroEndereco(){
        return this.endereco.getNumeroEndereco();
    }
    public String getBairroEndereco(){
        return this.endereco.getBairro();
    }
}
