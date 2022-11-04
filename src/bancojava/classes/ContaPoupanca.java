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
            double taxa = valor * 5 / 100;

            contaParaDeposito.setSaldo(valor + (contaParaDeposito.getSaldo() - taxa));
            valor = valor - taxa;
            super.transferencia(contaParaDeposito, valor);
            super.notificacao.enviarNotificacao("Transferência", valor, data, hora);
        }else if(this.getSaldo() < valor || this.getSaldo() <= 0){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
        }
    }
}
