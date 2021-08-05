package tests;

import agenda.Agenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void preparaAgenda() {
        this.agenda = new Agenda();
        this.agenda.cadastraContato(7, "Cristiano", "Ronaldo", "7777-7777");
        this.agenda.cadastraContato(11, "Neymar", "Jr", "1111-1111");
        this.agenda.cadastraContato(10, "Lionel", "Messi", "1010-1010");
    }

    @Test
    void testGetContatos() {
        String msg = "Get contatos não está funcionando";
        assertEquals("7 - Cristiano Ronaldo\n10 - Lionel Messi\n11 - Neymar Jr\n", this.agenda.getContatos(), msg);
    }

    @Test
    void testCadastraConato() {
        String msg = "Cadastro não realizado com sucesso";

        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(9, "Ronaldo", "Nazário", "9999-9999"), msg);

        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(10, "Marta", "", "1010-1010"), msg);

        assertEquals("CONTATO JA CADASTRADO", this.agenda.cadastraContato(7, "Cristiano", "Ronaldo", "7777-7777"), msg);

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.cadastraContato(1, "", "Julius", "0000-0000"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.cadastraContato(1, "Chris", "Rock", ""));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.cadastraContato(0, "Lucas", "Lucco", "0000-0000"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.cadastraContato(101, "Lucas", "Lima", "0000-0000"));
    }

    @Test
    void testGetContato() {
        String msg = "get contato aceitando posição invalida";
        assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.getContato(5), msg);

        assertEquals("Lionel Messi\n1010-1010",this.agenda.getContato(10));
    }

    @Test
    void testFavoritarGetfavoritos(){
        String msg = "Contato não favoritado";
        assertEquals("CONTATO FAVORITADO NA POSIÇÃO 7",this.agenda.favoritar(7,6),msg);
        assertEquals("CONTATO FAVORITADO NA POSIÇÃO 10", this.agenda.favoritar(10,9),msg);

        assertEquals("6 - Cristiano Ronaldo\n9 - Lionel Messi\n",this.agenda.getFavoritos());

        assertEquals("❤ Cristiano Ronaldo\n7777-7777",this.agenda.getContato(7));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.favoritar(101,9));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.favoritar(0,9));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.favoritar(10,0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.favoritar(10,11));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.favoritar(5,9));
    }

    @Test
    void testSetTag() {
        String[] contatos = new String[]{"7","10"};
        String[] contatosVazio = new String[0];
        this.agenda.setTag(contatos,"GOAT",1);

        assertEquals("Cristiano Ronaldo\n7777-7777\nGOAT",this.agenda.getContato(7));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.setTag(contatos,"GOAT",0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.setTag(contatos,"GOAT",6));

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.setTag(contatosVazio,"GOAT",1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.setTag(contatos,"",2));

    }

    @Test
    void testEditaTelefone() {
        String msg = "não editou o telefone";
        this.agenda.editaTelefone(7, "9999-9999");

        assertEquals("Cristiano Ronaldo\n9999-9999",this.agenda.getContato(7), msg);

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.editaTelefone(7, ""));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.editaTelefone(0, "0909-0909"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.editaTelefone(101, "0909-0909"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.editaTelefone(1, "0909-0909"));
    }

    @Test
    void testRmTag() {
        String[] contatos = new String[]{"7","10"};
        this.agenda.setTag(contatos,"GOAT",1);
        assertEquals("Cristiano Ronaldo\n7777-7777\nGOAT",this.agenda.getContato(7));

        this.agenda.rmTag(7,1);

        assertEquals("Cristiano Ronaldo\n7777-7777",this.agenda.getContato(7));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.rmTag(0, 1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.rmTag(101, 1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.rmTag(7, 0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.rmTag(7, 6));
    }

    @Test
    void testDesfavoritar() {
        String msg = "não removeu dos favoritos";
        this.agenda.favoritar(7,6);
        assertEquals("6 - Cristiano Ronaldo\n",this.agenda.getFavoritos());


        assertEquals("Desfavoritado com sucesso",this.agenda.desfavorita(6), msg);

        assertEquals("",this.agenda.getFavoritos(), msg);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.desfavorita(11));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.desfavorita(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.desfavorita(1));
    }

    @Test
    void testZerarContato() {
        String msg = "não removeu o contato";
        this.agenda.favoritar(10,9);
        assertEquals("9 - Lionel Messi\n",this.agenda.getFavoritos());
        assertEquals("7 - Cristiano Ronaldo\n10 - Lionel Messi\n11 - Neymar Jr\n", this.agenda.getContatos());

        assertEquals("Contato apagado com sucesso",this.agenda.zerarContato(10), msg);

        assertEquals("",this.agenda.getFavoritos(), msg);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.zerarContato(101));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.zerarContato(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.agenda.zerarContato(12));
    }

    @Test
    void testPesquisaNome() {
        assertEquals("7 - Cristiano Ronaldo\n",this.agenda.pesquisaNome("Cristiano"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.agenda.pesquisaNome(""));
    }

    @Test
    void testPesquisaSobrenome() {
        assertEquals("10 - Lionel Messi\n",this.agenda.pesquisaSobrenome("Messi"));
    }

    @Test
    void testPesquisaTag() {
        String[] contatos = new String[]{"7","10"};
        this.agenda.setTag(contatos,"GOAT",1);

        assertEquals("7 - Cristiano Ronaldo\n10 - Lionel Messi\n", this.agenda.pesquisaTag("GOAT"));
    }
}
