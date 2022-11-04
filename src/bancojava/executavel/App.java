package bancojava.executavel;

import bancojava.classes.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class App{
    static ArrayList<Conta> contas;//varias contas//listcontas

    public static void main(String[] args) {
        contas = new ArrayList<>();
        /*Email obj = */
        comandos();
    }
    private static void comandos() {
        String comando = JOptionPane.showInputDialog("COMANDOS:\n1-Criar conta\n2-Depositar\n3-Transferir\n4-Sacar\n5-Listar\n6-Saldo\n7-Sair");
        int comandoInteiro = Integer.parseInt(comando);

        switch (comandoInteiro) {
            case 1 -> criarConta();
            case 2 -> depositar();
            case 3 -> transferir();
            case 4 -> sacar();
            case 5 -> listar();
            case 6 -> saldo();
            case 7 -> sair();
            default -> JOptionPane.showMessageDialog(null, "Escolha uma operação válida!");
        }
            comandos();
    }

    private static void criarConta() {

        String[] options = {"Conta Poupança", "Conta Corrente"};
        int tipoConta = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta:",
                "Clique em uma opção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(tipoConta);
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
        String uf = JOptionPane.showInputDialog("Infome a UF(Unidade Federativa):");
        Endereco endereco = new Endereco(logradouro, numeroEndereco, bairro, cidade, uf);
        Cliente cliente = new Cliente(nome, datanascimento, cpf, endereco);
        Notificacao notificacao = new Email();


       if (tipoConta == 0) {
            ContaPoupanca conta = new ContaPoupanca(cliente, tipoConta, notificacao);

            contas.add(conta);

            JOptionPane.showMessageDialog(null, "Sua Conta Poupança foi criada com sucesso!");

        } else if (tipoConta == 1){

            ContaCorrente conta = new ContaCorrente(cliente, tipoConta, notificacao);

            contas.add(conta);
            JOptionPane.showMessageDialog(null, "Sua Conta Corrente foi criada com sucesso!");
        }
        comandos();
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

    private static void depositar() {
        String numero = JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            String valor =JOptionPane.showInputDialog(" Qual o valor que deseja depositar ?");
            double novoValor = Double.parseDouble(valor);
            conta.deposito(novoValor);
            /*JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");*/
        } else {
            JOptionPane.showMessageDialog(null, " Não foi possivel realizar o deposito! ");
        }
        comandos();
    }

    private static void sacar() {
        String numero =JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            String valor = JOptionPane.showInputDialog("Qual o valor do sac? ");
            double novoValor = Double.parseDouble(valor);
            conta.sacar(novoValor);
        }
        comandos();
    }

    private static void transferir() {
        String numeroRemetente = JOptionPane.showInputDialog("Numero da conta do remetente: ");
        int novoNumeroRemetente = Integer.parseInt(numeroRemetente);
        Conta contaRemetente = encontrandoContas(novoNumeroRemetente);
        /*if(contaRemetente !=  ){
            JOptionPane.showMessageDialog(null, "Conta não encontrada, não foi possível realizar a transferência!");}*/
        if (contaRemetente != null) {
            String numeroDestinatario = JOptionPane.showInputDialog("Numero da conta do destinatario: ");
            int novoNumeroDestinatario = Integer.parseInt(numeroDestinatario);
            Conta contaDestinatario = encontrandoContas(novoNumeroDestinatario);
            if (contaDestinatario != null) {
                String valor = JOptionPane.showInputDialog("Digite o valor da transferência ");
                double novoValor = Integer.parseInt(valor);
                contaRemetente.transferencia(contaDestinatario, novoValor);
            }
        }
        comandos();
    }

    private static void listar() {
        if (contas.size() > 0) {
            for (Conta conta : contas) {
                JOptionPane.showMessageDialog(null, ""+conta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há contas para listar!");
        }
        comandos();
    }



    private static void saldo() {
        String numero = JOptionPane.showInputDialog("Digite o numero da conta: ");
        int novoNumero = Integer.parseInt(numero);
        Conta conta = encontrandoContas(novoNumero);
        if (conta != null) {
            JOptionPane.showMessageDialog(null, "Saldo: "+conta.getSaldo());
        }
        comandos();
    }

    private static void sair(){
        JOptionPane.showMessageDialog(null, "Saída executada!");
        System.exit(0);
    }
}
