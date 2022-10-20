package bancojava.classes;

import javax.swing.*;
import java.time.LocalDate;

public class Conta {
    private static int contador = 1;
    private int numero;
    private int agencia;
    private double saldo;
    private Cliente Cliente;

    public Conta(Cliente Cliente) {
        this.agencia = agencia;
        this.numero = contador;
        this.saldo = saldo;
        this.Cliente = Cliente;
        contador += 1;

    }

    public void Sacar(double valor) {
        if (valor > 0 && this.getSaldo() >= 0) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, " Saque realizado com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar o saque! ");
        }
    }

    public void Tranferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= 0) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, " Transferência realizada com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar a tranferência! ");
        }
    }

    public void Deposito(double valor) {
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
        return Cliente;
    }

    public String getNomecliente() {
        return this.Cliente.getNome();
    }

    public LocalDate getDatacliente() {
        return this.Cliente.getDatanascimento();
    }

    public String getCpfcliente() {
        return this.Cliente.getCpf();

    }

    public String getClienteEnderecocidade() {
        return this.Cliente.getCidadeEndereco();
    }

    public String getClienteEnderecoUf() {
        return this.Cliente.getUfEndereco();
    }

    public String getClienteLogradouroEndereco() {
        return this.Cliente.getLogradouroEndereco();
    }
    public int getClienteNumeroEndereco(){
        return this.Cliente.getNumeroEndereco();
    }
    public String getClienteBairroEndereco(){
        return this.Cliente.getBairroEndereco();
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
