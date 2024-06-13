import java.util.List;

public class Venda {
    private String data;
    private List<Produto> produtos;
    private Vendedor vendedor;
    private Cliente cliente;
    private double valorTotal;

    public Venda(String data, List<Produto> produtos, Vendedor vendedor, Cliente cliente, double valorTotal) {
        this.data = data;
        this.produtos = produtos;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String mostrarMonitor() {
        StringBuilder produtosStr = new StringBuilder();
        for (Produto produto : produtos) {
            produtosStr.append(produto.getNome()).append(", ");
        }

        return "Venda{" +
                "data='" + data + '\'' +
                ", produtos=[" + (produtosStr.length() > 0 ? produtosStr.substring(0, produtosStr.length() - 2) : "") + "]" +
                ", vendedor=" + vendedor.getNome() +
                ", cliente=" + cliente.getNome() +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
