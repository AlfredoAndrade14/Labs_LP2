package biblitex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformaTextoTest {
    private TransformaTexto tt;

    @BeforeEach
    void preparaTransformaTexto() {
        tt = new TransformaTexto();
    }

    @Test
    void testTransformaNaoexiste() {
        assertEquals("Transformação não cadastrada",this.tt.transforma("Teste","bola"));
    }

    @Test
    void testTransformaCamelCaseFY() {
        assertEquals("OlÁ, tUdO BeM?",this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?"));
    }

    @Test
    void testTransformaClean() {
        assertEquals("Olá tudo bem",this.tt.transforma("clean", "Olá, tudo bem?"));
    }

    @Test
    void testTransformaInterrogaPraPontos() {
        assertEquals("Olá, tudo bem.",this.tt.transforma("interrogaPraPontos", "Olá, tudo bem?"));
    }

    @Test
    void testTransformaUpperCase() {
        assertEquals("OLÁ, TUDO BEM?",this.tt.transforma("upperCase", "Olá, tudo bem?"));
    }

    @Test
    void testTransformaCleanSpaces() {
        assertEquals("Olá,tudobem?",this.tt.transforma("CleanSpaces", "Olá, tudo bem?"));
    }

    @Test
    void testRemoveVogais() {
        assertEquals("l, td bm?",this.tt.transforma("RemoveVogais", "Olá, tudo bem?"));
    }

    @Test
    void testContaTransformacoes() {
        this.tt.transforma("upperCase", "Olá, tudo bem?");
        this.tt.transforma("RemoveVogais", "Olá, tudo bem?");

        assertEquals(2, this.tt.contaTransformacao());
    }

    @Test
    void testHistorico() {
        this.tt.transforma("CleanSpaces", "Olá, tudo bem?");
        this.tt.transforma("upperCase", "Olá, tudo bem?");

        assertEquals("Olá, tudo bem? upperCase -> OLÁ, TUDO BEM?", this.tt.historico(1));
    }

    @Test
    void testHistoricoErroPosicaoMenor() {
        this.tt.transforma("CleanSpaces", "Olá, tudo bem?");
        this.tt.transforma("upperCase", "Olá, tudo bem?");

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.tt.historico(-1));
    }

    @Test
    void testHistoricoErroPosicaoMaior() {
        this.tt.transforma("CleanSpaces", "Olá, tudo bem?");
        this.tt.transforma("upperCase", "Olá, tudo bem?");

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.tt.historico(10));
    }

    @Test
    void testListarOriginais() {
        this.tt.transforma("interrogaPraPontos", "Olá, tudo bem?");
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");

        assertEquals("Olá, tudo bem?\n", this.tt.listarOriginais());
    }

    @Test
    void testListaTransformacoes() {
        assertEquals("CaMeLcAsEfY\nclean\ncleanSpaces\nInterrogaPraPontos\nRemoveVogais\nupperCase\n", this.tt.listarTransformacoes());
    }
}