public abstract class ContaBancaria {
    protected double saldo;
    
    public void depositar(double valor) {
        this.saldo += valor;
    }
    
    public abstract void sacar(double valor);
}
public aspect VerificarSaldoAspect {
    pointcut todasAsChamadasParaSacar(ContaBancaria conta, double valor) :
        call(* ContaBancaria.sacar(double)) && target(conta) && args(valor);

    before(ContaBancaria conta, double valor) : todasAsChamadasParaSacar(conta, valor) {
        if (conta.saldo < valor) {
            System.out.println("Saldo insuficiente para realizar o saque na conta " + conta.getClass().getSimpleName());
        }
    }
}
public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;
    
    public ContaCorrente(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    
    @Override
    public void sacar(double valor) {
        double valorTotal = valor + (valor * 0.1);
        
        if (valorTotal > (saldo + limiteChequeEspecial)) {
            System.out.println("Saldo insuficiente para realizar o saque na conta corrente");
        } else {
            this.saldo -= valorTotal;
        }
    }
}
