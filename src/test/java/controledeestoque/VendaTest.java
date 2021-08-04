package controledeestoque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTest
{

    @Test
    void deveRetornarMensagemVendaSemCliente()
    {
        Produto p1 = new Produto(
                "Cerveja",
                50,
                22.0f,
                20,
                150);

        try {
            Venda venda = new Venda(
                    "02/07/1997",
                    2,
                    null,
                    p1);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Sem cliente, não há venda", e.getMessage());
        }
    }

    @Test
    void deveRetornarFalseParaEstoqueInsuficiente()
    {
        Produto p1 = new Produto(
                "Cerveja",
                30,
                22.0f,
                20,
                100);

        Cliente cliente = new Cliente("Samuel", "321321");
        Venda v1 = new Venda(
                "02/07/1997",
                110,
                cliente,
                p1);

        p1.Vender("02/07/1997", cliente, 110);

        assertFalse(v1.vender(p1, v1.getQuantidade()));
    }

    @Test
    void deveRetornarTrueParaEstoqueSuficiente()
    {
        Produto p1 = new Produto(
                "Cerveja",
                30,
                22.0f,
                20,
                100);

        Cliente cliente = new Cliente("Samuel", "321321");
        Venda v1 = new Venda(
                "02/07/1997",
                50,
                cliente,
                p1);

        assertTrue(v1.vender(p1, v1.getQuantidade()));
    }

}
