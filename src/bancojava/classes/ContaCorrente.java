package bancojava.classes;

public class ContaCorrente extends Conta{
    private double chequeEspecial;
    public ContaCorrente(Cliente Cliente){
        super(Cliente);
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
}
