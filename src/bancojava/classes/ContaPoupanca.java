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
}
