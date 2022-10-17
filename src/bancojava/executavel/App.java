package bancojava.executavel;

import bancojava.classes.Cliente;
import bancojava.classes.Conta;
import bancojava.classes.Endereco;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    static ArrayList<Conta> contas;//varias contas//listcontas

    public static void main(String[] args) {

        contas = new ArrayList<>();
        operacoes();
    }
    private static void operacoes() {
        String operacao = JOptionPane.showInputDialog("OPERAÇÕES:\n1-Criar conta\n2-Depositar\n3-Transferir\n4-Sacar\n5-Listar\n6-Saldo");
        int operacaoInteira = Integer.parseInt(operacao);

        switch (operacaoInteira) {
            case 1 -> CriarConta();
            case 2 -> Depositar();
            case 3 -> Transferir();
            case 4 -> Sacar();
            case 5 -> Listar();
            case 6 -> Saldo();
            default -> JOptionPane.showMessageDialog(null, "Escolha uma operação válida!");
        }

    }

    private static void CriarConta() {

        String nome = JOptionPane.showInputDialog("Informe o nome do cliente: ");
        String cpf = JOptionPane.showInputDialog("Informe o Cpf : ");
        String dataString = JOptionPane.showInputDialog("Informe a data de nascimento: ");
        String[] dataseparada = dataString.split("/");
        LocalDate datanascimento = LocalDate.of(Integer.parseInt(dataseparada[2]), Integer.parseInt(dataseparada[1]), Integer.parseInt(dataseparada[0]));
        String cidade = JOptionPane.showInputDialog("Informe sua cidade local : ");
        String logradouro = JOptionPane.showInputDialog("Informe o logradouro: ");
        String bairro = JOptionPane.showInputDialog("Informe o Bairro: ");
        String numeroEndereco1 = JOptionPane.showInputDialog("Informe o número da sua residência: ");
        int numeroEndereco = Integer.parseInt(numeroEndereco1);
        String uf = JOptionPane.showInputDialog("Infome o uf :");
        Endereco endereco = new Endereco(logradouro, numeroEndereco, bairro, cidade, uf);
        Cliente cliente = new Cliente(nome, datanascimento, cpf, endereco);
        Conta conta = new Conta(cliente);
        contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        operacoes();
    }

    private static Conta encontrandoContas(int numero) {
        Conta conta = null;
        if (contas.size() > 0) {
            for (Conta cc : contas) {
                if (cc.getNumero() == numero) {
                    conta = cc;
                }
            }
        }
        return conta;
    }

    private static void Depositar() {
        String numero = JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            String valor =JOptionPane.showInputDialog(" Qual o valor que deseja depositar ?");
            double novoValor = Double.parseDouble(valor);
            conta.Deposito(novoValor);
            JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar o deposito ");
        }
        operacoes();
    }

    private static void Sacar() {
        String numero =JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            String valor = JOptionPane.showInputDialog("Qual o valor do sac ? ");
            double novoValor = Double.parseDouble(valor);
            conta.Sacar(novoValor);

            JOptionPane.showMessageDialog(null, "\nSac realizado com sucesso ");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o sac!");
        }
        operacoes();
    }

    private static void Transferir() {
        String numeroRemetente = JOptionPane.showInputDialog("Numero da conta do remetente: ");
        int novoNumeroRemetente = Integer.parseInt(numeroRemetente);
        Conta contaRemetente = encontrandoContas(novoNumeroRemetente);
        if (contaRemetente != null) {
            String numeroDestinatario = JOptionPane.showInputDialog("Numero da conta do destinatario: ");
            int novoNumeroDestinatario = Integer.parseInt(numeroDestinatario);
            Conta contaDestinatario = encontrandoContas(novoNumeroDestinatario);
            if (contaDestinatario != null) {
                String valor = JOptionPane.showInputDialog("Digite o valor da transferência ");
                double novoValor = Integer.parseInt(valor);
                contaRemetente.Tranferir(contaDestinatario, novoValor);
                JOptionPane.showMessageDialog(null, "\nValor  transferido com suscesso  ");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel fazer a transferência! ");
            }
        }
        operacoes();
    }

    private static void Listar() {
        if (contas.size() > 0) {
            for (Conta conta : contas) {
                JOptionPane.showMessageDialog(null, ""+conta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não ha contas para listar!");
        }
    }


    private static void Saldo() {
        String numero = JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            JOptionPane.showMessageDialog(null, "Saldo: "+conta.getSaldo());
        }
        operacoes();
    }
}
