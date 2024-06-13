/*
 As funcionalidades básicas do sistema devem ser:
 ------------------------------(Feito)------------------------------------------------

 • Adicionar novos usuários (gerente, vendedor, caixa, cliente, fornecedor):

 ------------------------------(Feito)------------------------------------------------
• Gerenciar produtos:
Atributos essenciais de um produto: nome, categoria, fornecedor, preço, quantidadeEmEstoque,
descrição (Outros atributos podem ser colocados):

Coloquei ID  no lugar de categoria!!!

OBS: falta adicionar a descrição !!!

------------------------------(EM PROCESSO)------------------------------------------------
• Registrar vendas;
Atributos essenciais de uma venda: data, produto(s), vendedor, cliente, valorTotal (Outros atributos
podem ser colocados):"feito"

• Pesquisar produtos; "feito"

• Oferta de descontos;

• Gerar relatórios de vendas e de estoque.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Fornecedor> fornecedores = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Menu Produto");
            System.out.println("2. Menu Usuário");
            System.out.println("3. Menu Venda");
            System.out.println("4. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    menuProduto();
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 3:
                    menuVenda();
                    break;
                case 4:
                    System.out.println("SAINDO!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuProduto() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Pesquisar produtos");
            System.out.println("4. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    pesquisarProdutos();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuUsuario() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Adicionar fornecedor");
            System.out.println("4. Listar fornecedores");
            System.out.println("5. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    adicionarFornecedor();
                    break;
                case 4:
                    listarFornecedores();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuVenda() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registrar venda");
            System.out.println("2. Listar vendas");
            System.out.println("3. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    registrarVenda();
                    break;
                case 2:
                    listarVendas();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.println("Digite o ID do produto:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        System.out.println("Fornecedores disponíveis:");
        for (int i = 0; i < fornecedores.size(); i++) {
            System.out.println((i + 1) + ". " + fornecedores.get(i).mostrarMonitor());
        }
        System.out.println("Escolha o fornecedor pelo número:");
        int fornecedorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome a nova linha

        if (fornecedorIndex < 0 || fornecedorIndex >= fornecedores.size()) {
            System.out.println("Fornecedor inválido. Produto não registrado.");
            return;
        }
        Fornecedor fornecedor = fornecedores.get(fornecedorIndex);

        Produto produto = new Produto(id, nome, preco, quantidade, fornecedor);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.mostrarMonitor());
            }
        }
    }

    private static void adicionarUsuario() {
        System.out.println("Digite o tipo de usuário (gerente, vendedor, cliente ou caixa):");
        String tipo = scanner.nextLine();
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do usuário:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o telefone do usuário:");
        String telefone = scanner.nextLine();

        Usuario usuario;
        switch (tipo.toLowerCase()) {
            case "gerente":
                System.out.println("Digite o salário do gerente:");
                double salarioGerente = scanner.nextDouble();
                usuario = new Gerente(nome, cpf, telefone, salarioGerente);
                break;
            case "vendedor":
                System.out.println("Digite a comissão do vendedor:");
                double comissao = scanner.nextDouble();
                usuario = new Vendedor(nome, cpf, telefone, comissao);
                break;
            case "cliente":
                System.out.println("Digite o endereço do cliente:");
                String endereco = scanner.nextLine();
                usuario = new Cliente(nome, cpf, telefone, endereco);
                break;
            case "caixa":
                System.out.println("Digite o salário do caixa:");
                double salarioCaixa = scanner.nextDouble();
                usuario = new Caixa(nome, cpf, telefone, salarioCaixa);
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.mostrarMonitor());
            }
        }
    }

    private static void adicionarFornecedor() {
        System.out.println("Digite o nome do fornecedor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do fornecedor:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do fornecedor:");
        String endereco = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(nome, telefone, endereco);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }

    private static void listarFornecedores() {
        if (fornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
        } else {
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println(fornecedor.mostrarMonitor());
            }
        }
    }

    private static void registrarVenda() {
        System.out.println("Digite a data da venda:");
        String data = scanner.nextLine();

        List<Produto> produtosVenda = new ArrayList<>();
        while (true) {
            System.out.println("Produtos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + ". " + produtos.get(i).mostrarMonitor());
            }
            System.out.println("Escolha o produto pelo número (ou digite 0 para finalizar a seleção):");
            int produtoIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consome a nova linha

            if (produtoIndex == -1) {
                break;
            }

            if (produtoIndex < 0 || produtoIndex >= produtos.size()) {
                System.out.println("Produto inválido.");
                continue;
            }

            produtosVenda.add(produtos.get(produtoIndex));
        }

        if (produtosVenda.isEmpty()) {
            System.out.println("Nenhum produto selecionado. Venda não registrada.");
            return;
        }

        System.out.println("Vendedores disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Vendedor) {
                System.out.println((i + 1) + ". " + usuarios.get(i).mostrarMonitor());
            }
        }
        System.out.println("Escolha o vendedor pelo número:");
        int vendedorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome a nova linha

        if (vendedorIndex < 0 || vendedorIndex >= usuarios.size() || !(usuarios.get(vendedorIndex) instanceof Vendedor)) {
            System.out.println("Vendedor inválido. Venda não registrada.");
            return;
        }
        Vendedor vendedor = (Vendedor) usuarios.get(vendedorIndex);

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Cliente) {
                System.out.println((i + 1) + ". " + usuarios.get(i).mostrarMonitor());
            }
        }
        System.out.println("Escolha o cliente pelo número:");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome a nova linha

        if (clienteIndex < 0 || clienteIndex >= usuarios.size() || !(usuarios.get(clienteIndex) instanceof Cliente)) {
            System.out.println("Cliente inválido. Venda não registrada.");
            return;
        }
        Cliente cliente = (Cliente) usuarios.get(clienteIndex);

        double valorTotal = produtosVenda.stream().mapToDouble(Produto::getPreco).sum();

        Venda venda = new Venda(data, produtosVenda, vendedor, cliente, valorTotal);
        vendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    private static void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda venda : vendas) {
                System.out.println(venda.mostrarMonitor());
            }
        }
    }

    private static void pesquisarProdutos() {
        System.out.println("Digite o nome ou parte do nome do produto:");
        String nome = scanner.nextLine();

        List<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(produto);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto produto : resultados) {
                System.out.println(produto.mostrarMonitor());
            }
        }
    }
}
