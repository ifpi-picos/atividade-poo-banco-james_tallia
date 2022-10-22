package bancojava.classes;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(Cliente Cliente) {
        super(Cliente);


    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }
}
