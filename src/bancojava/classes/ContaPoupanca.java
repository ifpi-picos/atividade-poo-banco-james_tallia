package bancojava.classes;

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
    public void tranferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0){
            double taxa = valor * 5 / 100;

            contaParaDeposito.setSaldo(valor + (contaParaDeposito.getSaldo() - taxa));
            valor = valor - taxa;
            super.tranferir(contaParaDeposito, valor);
            super.tranferir(contaParaDeposito, valor);
            super.notificacao.enviarNotificacao("Transferência", valor, data, hora);
        }
        super.tranferir(contaParaDeposito, valor);
    }
}
