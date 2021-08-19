package controle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {
    private Grupo grupo;

    @BeforeEach
    void preparaGrupo() {
        this.grupo = new Grupo("Lista", 2);
        Aluno aluno = new Aluno("123", "Alfredo Vasconcelos", "CC");
        this.grupo.alocaAluno("123", aluno);
    }

    @Test
    void GrupoComLimiteMaiorQue0() {
       this.grupo = new Grupo("Programação OO", 10);
    }

    @Test
    void GrupoComLimite0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.grupo = new Grupo("Programação OO", 0));
    }

    @Test
    void GrupoComLimiteMenorQue0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.grupo = new Grupo("Programação OO", -1));
    }

    @Test
    void GrupoComNomeVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.grupo = new Grupo("", 10));
    }

    @Test
    void GrupoSemLimite() {
        this.grupo = new Grupo("Programação OO");
    }

    @Test
    void GrupoSemLimiteComNomeVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.grupo = new Grupo(""));
    }

    @Test
    void testAlocaAluno() {
        Aluno aluno2 = new Aluno("456", "Cainã", "CC");
        assertEquals("ALUNO ALOCADO!",this.grupo.alocaAluno("456",aluno2));
    }

    @Test
    void testAlocaAlunoMatriculaVazia() {
        Aluno aluno2 = new Aluno("456", "Cainã", "CC");
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.grupo.alocaAluno("",aluno2));
    }

    @Test
    void testAlocaAlunoGrupoCheio() {
        Aluno aluno2 = new Aluno("456", "Cainã", "CC");
        this.grupo.alocaAluno("456",aluno2);
        Aluno aluno3 = new Aluno("789", "Eduardo", "Psicologia");

        assertEquals("GRUPO CHEIO",this.grupo.alocaAluno("789",aluno3));
    }
}
