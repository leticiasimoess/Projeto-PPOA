public class App {

  public class Main {
    public static void main(String[] args) {

        ContaBancaria minhaConta = new ContaBancaria() {

          @Override
          public void sacar(double valor) {
            throw new UnsupportedOperationException("Unimplemented method 'sacar'");
          }
          
        };         
        minhaConta.depositar(1000);
        minhaConta.consultarSaldo();
        minhaConta.sacar(500);
        minhaConta.consultarSaldo();
    }
}

  
}