package controledeestoque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest
{
    @Test
    void deveRetornarMensagemQuantidadeNegativaDoEstoque()
    {
        try {
            Produto p1 = new Produto(
                    "Cerveja",
                    -20,
                    22.0f,
                    20,
                    150);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("O estoque deve armazenar quantidade igual ou maior a zero", e.getMessage());
        }
    }

    @Test
    void deveRetornarMensagemTransacaoSemProduto()
    {
        try {
            Transacao transacao = new Transacao("02/07/1997", 2, null);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Produto obrigatorio", e.getMessage());
        }
    }

    @Test
    void deveRetornarMensagemQuantidadeNegativaEmVenda()
    {
        Produto p1 = new Produto(
                "Cerveja",
                20,
                22.0f,
                20,
                150);
        try {
            p1.Vender("02/07/1997", new Cliente("Samuel", "123123"), -21);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("A quantidade vendida não pode ser negativa", e.getMessage());
        }
    }

    @Test
    void deveRetornarMensagemQuantidadeNegativaEmCompra()
    {
        Produto p1 = new Produto(
                "Cerveja",
                20,
                22.0f,
                20,
                150);
        try {
            p1.Comprar("02/07/1997", new Fornecedor("Samuel", "123"), -21, 5.0f);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("A quantidade comprada não pode ser negativa", e.getMessage());
        }
    }

    @Test
    void deveDebitarEstoque()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                150);

        p1.debitarEstoque(15);

        assertEquals(35,p1.getQuantidadeEstoque());
    }

    @Test
    void deveCreditarEstoque()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                150);

        p1.creditarEstoque(15);

        assertEquals(65, p1.getQuantidadeEstoque());

    }

    @Test
    void deveRetornarVerdadeiroParaEstoqueBaixo()
    {
        Produto p1 = new Produto(
                "Cerveja",
                18,
                22.0f,
                20,
                150);

        assertTrue(p1.verificarEstoqueBaixo());
    }

    @Test
    void deveRetornarFalsoParaEstoqueBaixo()
    {
        Produto p1 = new Produto(
                "Cerveja",
                25,
                22.0f,
                20,
                150);

        assertFalse(p1.verificarEstoqueBaixo());
    }


    @Test
    void deveRetornarValorCalculadoDeVenda()
    {
        Produto p1 = new Produto(
                "Cerveja",
                25,
                22.2f,
                20,
                150);

        assertEquals(44.4f, p1.calcularValorVenda(2));
    }

    @Test
    void deveExibirHistorico()
    {
        Produto p1 = new Produto(
                "Biscoito",
                25,
                22.2f,
                20,
                150);


        p1.Vender("04/08/2021", new Cliente("Samuel", "123456"), 5);
        p1.Vender("04/08/2021", new Cliente("LeBron James", "111111"), 2);
        p1.Comprar("04/08/2021", new Fornecedor("Neymar Jr", "222"), 3, 2.0f);
        p1.exibirHistorico();
    }

}
