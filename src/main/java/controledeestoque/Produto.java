package controledeestoque;

import java.util.ArrayList;
import java.util.List;

//Trabalho 2 de Orientação a Objetos, de Samuel Paiva Bernardes

public class Produto {

    private String nome;
    private int quantidadeEstoque;
    private float precoUnitario;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    public Produto(String nome, int quantidadeEstoque, float precoUnitario, int estoqueMinimo, int estoqueMaximo) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.historico = new ArrayList<String>();

        if (quantidadeEstoque < 0)
            throw new IllegalArgumentException("O estoque deve armazenar quantidade igual ou maior a zero");
        else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    public void debitarEstoque(int quantidade) {
        setQuantidadeEstoque(getQuantidadeEstoque() - quantidade);
    }

    public void creditarEstoque(int quantidade) {
        setQuantidadeEstoque(getQuantidadeEstoque() + quantidade);;
    }

    public boolean verificarEstoqueBaixo() {
        if (getQuantidadeEstoque() < getEstoqueMinimo())
            return true;

        return false;
    }

    public boolean verificarEstoqueInsuficiente(int quantidade) {
        if (quantidade > getEstoqueMaximo())
            return true;

        return false;
    }

    public boolean verificarEstoqueExcedente(int quantidade) {
        if ((quantidade + getQuantidadeEstoque()) > getEstoqueMaximo())
            return true;

        return false;
    }

    public float calcularValorVenda(int quantidade) {
        return getPrecoUnitario() * quantidade;
    }

    public void Vender(String dataVenda, Cliente cliente, int quantidadeVendida)
    {
        if (quantidadeVendida < 0) {
            throw new IllegalArgumentException("A quantidade vendida não pode ser negativa");
        }

        //Aloca uma nova Venda
        Venda vendaDoProduto = new Venda(
                dataVenda,
                quantidadeVendida,
                cliente,
                this);

        //Chama o método vender, e se retorna true, usa o método registrarHistorico
        if (vendaDoProduto.vender(this, quantidadeVendida)) {
            registrarHistorico("Venda do produto "  + this.getNome()+  ".");
        }
    }

    public void Comprar(String dataCompra, Fornecedor fornecedor, int quantidadeComprada, float precoUnit)
    {
        if (quantidadeComprada < 0) {
            throw new IllegalArgumentException("A quantidade comprada não pode ser negativa");
        }

        //Aloca uma nova Compra
        Compra compraDoProduto =
                new Compra(dataCompra,
                        quantidadeComprada,
                        precoUnit,
                        fornecedor,
                        this);

        //Chama o método comprar, e se retorna true, usa o método registrarHistorico
        if (compraDoProduto.comprar(this, quantidadeComprada))
            registrarHistorico("Compra do produto "  + this.getNome()+  ".");

    }

    private void registrarHistorico(String nomeDaTransacao) {
        this.historico.add(nomeDaTransacao);
    }

    public void exibirHistorico()
    {
        for(String transacao: this.historico)
        {
            System.out.println(transacao);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setHistorico(List<String> historico) {
        this.historico = historico;
    }
}


