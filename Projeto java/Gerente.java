public class Gerente extends Usuario {
    private double salario;

    public Gerente(String nome, String cpf, String telefone, double salario) {
        super(nome, cpf, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    public String mostrarMonitor() {
        return "Gerente{" +
                "nome = " + nome + 
                ", cpf = " + cpf + 
                ", telefone = " + telefone +
                ", salario = " + salario +
                '}';
    }
}
