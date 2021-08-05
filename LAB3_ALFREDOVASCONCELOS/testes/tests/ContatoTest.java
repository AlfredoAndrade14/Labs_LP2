package tests;

import agenda.Contato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContatoTest {

    private Contato contatoBase;

    @BeforeEach
    void preparaContatos() {
        this.contatoBase = new Contato("Alfredo", "Vasconcelos", "9999-9999");
        this.contatoBase.setTag("UFCG",1);
    }


    @Test
    void testGetNomeSobrenome() {
        String msg = "Nome completo não é o mesmo";
        assertEquals( "Alfredo Vasconcelos", this.contatoBase.getNomeSobrenome(), msg);
    }

    @Test
    void testGetNome() {
        String msg = "Esperando obter o nome";
        assertEquals( "Alfredo", this.contatoBase.getNome(), msg);
    }

    @Test
    void testGetSobrenome() {
        String msg = "Esperando obter o sobrenome";
        assertEquals( "Vasconcelos", this.contatoBase.getSobrenome(), msg);
    }

    @Test
    void testToString() {
        String msg = "Esperando obter os atributos do contato telefone";
        assertEquals( "Alfredo Vasconcelos\n9999-9999\nUFCG", this.contatoBase.toString(), msg);
    }

    @Test
    void testSetTelefone() {
        String msg = "Não editou o telefone";
        this.contatoBase.setTelefone("8888-8888");
        assertEquals( "Alfredo Vasconcelos\n8888-8888\nUFCG", this.contatoBase.toString(), msg);
    }

    @Test
    void testRmTag() {
        String msg = "Não apagou a tag";
        this.contatoBase.rmTag(1);
        assertEquals( "Alfredo Vasconcelos\n9999-9999", this.contatoBase.toString(), msg);
    }

    @Test
    void testGetTag() {
        assertEquals("UFCG",this.contatoBase.getTag(1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.contatoBase.getTag(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.contatoBase.getTag(6));
    }

    @Test
    void testEquals() {
        Contato novoContato = new Contato("Alfredo", "Vasconcelos", "9192-9796");

        assertTrue(contatoBase.equals(novoContato));
    }
}
