package controledeestoque;

public class Venda extends controledeestoque.Transacao
{
    private Cliente clienteDaVenda;

    public Venda(String dataTransacao, int quantidade, Cliente clienteDaVenda, Produto produto)
    {
        super(dataTransacao, quantidade, produto);

        if(clienteDaVenda == null)
            throw new IllegalArgumentException("Sem cliente, não há venda");
        else {
            this.clienteDaVenda = clienteDaVenda;
        }
    }

    public boolean vender(Produto produto, int quantidade)
    {

        if(produto.verificarEstoqueInsuficiente(quantidade)) {
            System.out.println("O estoque não possui material para venda");
            return false;
        }

        produto.debitarEstoque(quantidade);
        System.out.println("Debitado no estoque o valor de " + quantidade);
        return true;
    }

    public Cliente getClienteDaVenda() {
        return clienteDaVenda;
    }

    public void setClienteDaVenda(Cliente clienteDaVenda) {
        this.clienteDaVenda = clienteDaVenda;
    }
}
