public class Vendedor extends Usuario {
    private double comissao;

    public Vendedor(String nome, String cpf, String telefone, double comissao) {
        super(nome, cpf, telefone);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }


    public String mostrarMonitor() {
        return "Vendedor{" +
                "nome = " + nome + 
                ", cpf = " + cpf + 
                ", telefone = " + telefone + 
                ", comissao = " + comissao +
                '}';
    }
}
