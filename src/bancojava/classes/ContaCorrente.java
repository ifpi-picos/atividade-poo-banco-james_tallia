package bancojava.classes;

public class ContaCorrente extends Conta{
    private double chequeEspecial;
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
}
