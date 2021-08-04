package controledeestoque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompraTest
{
    @Test
    void deveRetornarMensagemCompraSemFornecedor()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                150);
        try {
            Compra compra = new Compra(
                    "02/07/1997",
                    2,
                    2.0f,
                    null,
                    p1);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Sem fornecedor, não há compra", e.getMessage());
        }
    }


    @Test
    void deveRetornarFalseParaEstoqueExcedente()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                100);

        Fornecedor fornecedor = new Fornecedor("Marcos", "123");
        Compra c1 = new Compra(
                "02/07/1997",
                60,
                22.0f,
                fornecedor,
                p1);

        assertFalse(c1.comprar(p1, c1.getQuantidade()));
    }

    @Test
    void deveRetornarTrueParaEstoqueSemExcedente()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                150);

        Fornecedor fornecedor = new Fornecedor("Marcos", "123");
        Compra c1 = new Compra(
                "02/07/1997",
                60,
                22.0f,
                fornecedor,
                p1);

        assertTrue(c1.comprar(p1, c1.getQuantidade()));
    }

}
