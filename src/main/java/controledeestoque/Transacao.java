package controledeestoque;

public class Transacao
{
    private String dataTransacao;
    private int quantidade;
    private Produto produtoDaTransacao;

    public Transacao(String dataTransacao, int quantidade, Produto produtoDaTransacao)
    {
        this.dataTransacao = dataTransacao;
        this.quantidade = quantidade;

        if(produtoDaTransacao == null)
            throw new IllegalArgumentException("Produto obrigatorio");
        else {
            this.produtoDaTransacao = produtoDaTransacao;
        }
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutoDaTransacao() {
        return produtoDaTransacao;
    }

    public void setProdutoDaTransacao(Produto produtoDaTransacao) {
        this.produtoDaTransacao = produtoDaTransacao;
    }

}
