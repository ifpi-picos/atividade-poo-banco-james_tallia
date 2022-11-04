package bancojava.classes;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Conta {
    private static int contador = 1;
    private int numero;
    private int agencia;
    private double saldo;
    private int tipoConta;
    private Cliente cliente;
    Notificacao notificacao;
    LocalDate data = LocalDate.now();
    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("E, dd/MM/yyy");
    LocalTime hora = LocalTime.now();
    DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Conta(Cliente cliente, int tipoConta, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = contador;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.notificacao = notificacao;
        contador += 1;

    }

    public void sacar(double valor) {
        if (valor > 0 && this.getSaldo() > 0) {
            setSaldo(getSaldo() - valor);
            this.notificacao.enviarNotificacao("Saque", valor,data, hora);
        } else if(this.getSaldo() <= 0) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque!");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() > 0) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
        }
    }

    public void deposito(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            this.notificacao.enviarNotificacao("Depósito", valor,data, hora);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito!");
            System.exit(0);
        }
    }


    public int getNumero() {
        return numero;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public String getNomecliente() {
        return this.cliente.getNome();
    }

    public LocalDate getDatacliente() {
        return this.cliente.getDatanascimento();
    }

    public String getCpfcliente() {
        return this.cliente.getCpf();

    }

    public String getClienteEnderecocidade() {
        return this.cliente.getCidadeEndereco();
    }

    public String getClienteEnderecoUf() {
        return this.cliente.getUfEndereco();
    }

    public String getClienteLogradouroEndereco() {
        return this.cliente.getLogradouroEndereco();
    }
    public int getClienteNumeroEndereco(){
        return this.cliente.getNumeroEndereco();
    }
    public String getClienteBairroEndereco(){
        return this.cliente.getBairroEndereco();
    }
    public String getContaTipo(){
        if(getTipoConta()==0){
            return "Poupança";
        }
        else if(getTipoConta()==1){
            return "Corrente";
        }
        return null;
    }

    public String toString() {
        return " Nome Cliente: " + getNomecliente() + "\n" +
                " Conta do tipo: " + getContaTipo() + "\n" +
                " Saldo: " + getSaldo() + "\n" +
                " Numero da conta: " + numero + "\n" +
                " Data Nascimento: " + getDatacliente() + "\n" +
                " Cpf: " + getCpfcliente() + "\n"  +
                " Endereço: " + "\n-Cidade: " +getClienteEnderecocidade()
                +"\n-Logradouro: " +getClienteLogradouroEndereco() +"\n-Número: "+getClienteNumeroEndereco()
                +"\n-Bairro: "+getClienteBairroEndereco()
                + "\n-UF: " + getClienteEnderecoUf();
    }
}
