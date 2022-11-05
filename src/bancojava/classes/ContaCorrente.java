package bancojava.classes;

import javax.swing.*;

public class ContaCorrente extends Conta {
    public int contador;
    private double chequeEspecial = 500;
    private double taxa;

    public ContaCorrente(Cliente cliente, int tipoConta, Notificacao notificacao) {
        super(cliente, tipoConta, notificacao);
        this.taxa = 0;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getSaldoDisponivel() {
        return super.getSaldo() + getChequeEspecial();
    }

    @Override
    public void sacar(double valor) {
        double saldocomLimite = this.getSaldo() + getChequeEspecial();
        if ((saldocomLimite - valor) >= 0) {
            JOptionPane.showMessageDialog(null, "O cheque especial será acionado!");
            this.setSaldo(this.getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "O cheque especial foi acionado com sucesso! ", "Cheque Especial", JOptionPane.ERROR_MESSAGE);
            super.sacar(valor);
        }
    }

    @Override
    public void retirarPorcentagem(double valor) {
        super.retirarPorcentagem(valor);
    }

    @Override
    public void transferencia(Conta contaParaDeposito, Double valor) {
        this.contador += 1;

        if (this.contador <= 2) {
            super.transferencia(contaParaDeposito, valor);

        } else {
            double v = valor;
            v = v * 5 / 100;
            super.retirarPorcentagem(v);
            super.transferencia(contaParaDeposito, valor);
        }
        super.notificacao.enviarNotificacao("Transferência", valor, data, hora);
    }

    }
