package bancojava.classes;

import javax.swing.*;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(Cliente cliente, int tipoConta, Notificacao notificacao) {
        super(cliente, tipoConta, notificacao);
        this.rendimento = 0.10;

    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    @Override
    public void transferencia(Conta contaParaDeposito, Double valor) {
        double v = valor;
        v = v * 5 / 100;
        super.sacar(v);
        super.transferencia(contaParaDeposito, valor);
            super.notificacao.enviarNotificacao("Transferência", valor, data, hora);

        if(this.getSaldo() < valor || this.getSaldo() <= 0){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
        }
    }

    @Override
    public void retirarPorcentagem(double valor) {
        super.retirarPorcentagem(valor);
    }

    @Override
    public void deposito(double valor) {
        super.deposito(valor);
        this.setSaldo(this.getSaldo() + this.getSaldo() * this.getRendimento());
    }

    @Override
    public void sacar(double valor) {
        if(this.getSaldo() <= 0 || this.getSaldo() < valor){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque!");
            super.retirarPorcentagem(valor);
        }
    }
}
