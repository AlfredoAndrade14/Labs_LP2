package controle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    private Aluno aluno;

    @BeforeEach
    void preparaAluno() {
        this.aluno = new Aluno("123","Alfredo", "CC");
    }

    @Test
    void testAluno() {
        this.aluno = new Aluno("456","Cainã", "CC");
    }

    @Test
    void testAlunoNomeVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.aluno = new Aluno("456","", "CC"));
    }

    @Test
    void testAlunoMatriculaVazia() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.aluno = new Aluno("","Teste", "CC"));
    }

    @Test
    void testAlunoCursoVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.aluno = new Aluno("000","Teste", ""));
    }

    @Test
    void testToString() {
        assertEquals("123 - Alfredo - CC",this.aluno.toString());
    }

    @Test
    void testAdicionaparticipacaoEGetParticipacao() {
        this.aluno.cadastraParticipacao();
        assertEquals(1,this.aluno.getParticipacao());
    }

    @Test
    void testGetCurso() {
        assertEquals("CC", this.aluno.getCurso());
    }
}
