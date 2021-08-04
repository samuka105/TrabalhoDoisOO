package controledeestoque;

public class Compra extends Transacao {
    private float precoUnitario;
    private Fornecedor fornecedorDaCompra;

    public Compra(String dataTransacao, int quantidade, float precoUnitario, Fornecedor fornecedorDaCompra, Produto produto)
    {
        super(dataTransacao, quantidade, produto);
        this.precoUnitario = precoUnitario;

        if(fornecedorDaCompra == null)
            throw new IllegalArgumentException("Sem fornecedor, não há compra");
        else {
            this.fornecedorDaCompra = fornecedorDaCompra;
        }
    }

    public boolean comprar(Produto produto, int quantidade) {

        if (produto.verificarEstoqueExcedente(quantidade)) {
            System.out.println("O estoque não suporta a compra");
            return false;
        }

        produto.creditarEstoque(quantidade);
        System.out.println("Creditado no estoque o valor de " + quantidade);
        return true;

    }


}



