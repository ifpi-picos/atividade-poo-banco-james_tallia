package bancojava.classes;

import javax.swing.*;
import java.time.LocalDate;


public class Conta {
    private static int contador = 1;
    private int numero;
    private int agencia;
    private double saldo;
    private String tipoConta;
    private Cliente cliente;

    public Conta(Cliente cliente, String tipoConta) {
        this.agencia = agencia;
        this.numero = contador;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        contador += 1;

    }

    public void sacar(double valor) {
        if (valor > 0 && this.getSaldo() >= 0) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, " Saque realizado com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar o saque! ");
        }
    }

    public void tranferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= 0) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, " Transferência realizada com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar a tranferência! ");
        }
    }

    public void deposito(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, " Deposito realizado com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o depoisito! ");
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

    public String toString() {
        return " Nome Cliente: " + getNomecliente() + "\n" +
                " Saldo: " + getSaldo() + "\n" +
                " Numero da conta: " + numero + "\n" +
                " Data Nascimento: " + getDatacliente() + "\n" +
                " Cpf: " + getCpfcliente() + "\n"  +
                " Endereço: " + "\n-Cidade: " +getClienteEnderecocidade()
                +"\n-Logradouro: " +getClienteLogradouroEndereco() +"\n-Número: "+getClienteNumeroEndereco()
                +"\n-Bairro: "+getClienteBairroEndereco()
                + "\n-Uf: " + getClienteEnderecoUf();
    }
}
