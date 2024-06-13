public class Cliente extends Usuario {
    private String endereco;

    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String mostrarMonitor() {
        return "Cliente{" +
                "nome = " + nome + 
                ", cpf = " + cpf +
                ", telefone = " + telefone + 
                ", endereco = " + endereco + 
                '}';
    }
}
