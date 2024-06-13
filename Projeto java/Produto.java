public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private Fornecedor fornecedor;

    public Produto(int id, String nome, double preco, int quantidade, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String mostrarMonitor() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", fornecedor=" + fornecedor.getNome() +
                '}';
    }
}
