public class Caixa extends Usuario {
    private double salarioCaixa;

    public Caixa(String nome, String cpf, String telefone, double salarioCaixa) {
        super(nome, cpf, telefone);
        this.salarioCaixa = salarioCaixa;
    }

    public double getSalario() {
        return salarioCaixa;
    }

    public void setSalario(double salario) {
        this.salarioCaixa = salario;
    }

    public String mostrarMonitor() {
        return "Caixa{" +
                "nome = " + nome  +
                ", cpf = " + cpf + 
                ", telefone = " + telefone +
                ", salario = " + salarioCaixa +
                '}';
    }
}
