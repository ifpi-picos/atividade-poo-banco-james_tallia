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
        if (getSaldo() > 0) {
            System.exit(0);
        }
        if (getSaldo() < 0) {

            valor = valor + getChequeEspecial();
        }
        super.sacar(valor);
        JOptionPane.showMessageDialog(null, "O cheque especial foi acionado! ", "Cheque Especial",JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void tranferir(Conta contaParaDeposito, Double valor) {
        this.contador += 1;

        if(this.contador <= 2){
            super.tranferir(contaParaDeposito, valor);
        }
        else {
            double taxa = valor * 5 / 100;

            contaParaDeposito.setSaldo(valor + (contaParaDeposito.getSaldo() - taxa));
            valor = valor - taxa;
            super.tranferir(contaParaDeposito, valor);
            super.tranferir(contaParaDeposito, valor);
            /*this.notificacao.enviarNotificacao("Transferência", valor, data, hora);*/
        }
    }
}
