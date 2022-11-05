package bancojava.classes;

import javax.swing.*;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(Cliente cliente, int tipoConta, Notificacao notificacao) {
        super(cliente, tipoConta, notificacao);


    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    @Override
    public void transferencia(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() > valor){
            double taxa = valor * 0.05;

            contaParaDeposito.setSaldo(valor + (contaParaDeposito.getSaldo() - taxa));
            valor = valor - taxa;
            super.transferencia(contaParaDeposito, valor);
            super.notificacao.enviarNotificacao("Transferência", valor, data, hora);
        }else if(this.getSaldo() < valor || this.getSaldo() <= 0){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
        }
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
            super.sacar(valor);
        }
    }
}
