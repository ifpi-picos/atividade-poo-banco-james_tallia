package bancojava.classes;

import javax.swing.*;

public class ContaCorrente extends Conta{
    public int contador =0;
    private double chequeEspecial = 500;
    public ContaCorrente(Cliente cliente, int tipoConta, Notificacao notificacao){
        super(cliente, tipoConta, notificacao);
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public double getSaldoDisponivel(){
        return super.getSaldo() + getChequeEspecial();
    }

    @Override
    public void sacar(double valor) {
        if (this.getSaldo() > 0 && this.getSaldo() > valor) {
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        }
        else if (this.getSaldo() < 0 || this.getSaldo() < valor) {
            JOptionPane.showMessageDialog(null,"O cheque especial será acionado!");
            valor = valor + getChequeEspecial();
            JOptionPane.showMessageDialog(null, "O cheque especial foi acionado com sucesso! ", "Cheque Especial",JOptionPane.ERROR_MESSAGE);

        }
        super.sacar(valor);
    }

    @Override
    public void transferencia(Conta contaParaDeposito, Double valor) {
        this.contador += 1;

        if(this.contador <= 2){
            super.transferencia(contaParaDeposito, valor);
        }
        else {
            double taxa = valor * 5 / 100;

            contaParaDeposito.setSaldo(valor + (contaParaDeposito.getSaldo() - taxa));
            valor = valor - taxa;
            super.transferencia(contaParaDeposito, valor);
            super.notificacao.enviarNotificacao("Transferência", valor, data, hora);
        }
    }
}
