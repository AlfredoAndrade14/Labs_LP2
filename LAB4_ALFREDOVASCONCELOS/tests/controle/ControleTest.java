package controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControleTest {
    private ControleAlunos controle;

    @BeforeEach
    void preparaControle() {
        this.controle = new ControleAlunos();
        this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
        this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
        this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
        this.controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    @Test
    void testCadastraAluno() {
        assertEquals("CADASTRO REALIZADO!",this.controle.cadastraAluno("100", "Alfredo Andrade", "CC"));
    }

    @Test
    void testCadastraAlunoCadastrado() {
        assertEquals("MATRÍCULA JÁ CADASTRADA!",this.controle.cadastraAluno("250", "Lucas Lucena", "CC"));
    }

    @Test
    void testGetAluno() {
        assertEquals("Aluno: 250 - Gabriel Reyes - Computação",this.controle.getAluno("250"));
    }

    @Test
    void testGetAlunoNaoCadastrado() {
        assertEquals("Aluno não cadastrado.",this.controle.getAluno("1"));
    }

    @Test
    void testCadastraGrupoSemLimite() {
        assertEquals("CADASTRO REALIZADO!",this.controle.cadastraGrupo("Programação OO",""));
    }

    @Test
    void testCadastraGrupoComLimite() {
        assertEquals("CADASTRO REALIZADO!",this.controle.cadastraGrupo("Listas","10"));
    }

    @Test
    void testCadastraGrupoJaCadastradoComLimite() {
        this.controle.cadastraGrupo("Listas","10");
        assertEquals("GRUPO JÁ CADASTRADO!",this.controle.cadastraGrupo("Listas","60"));
    }

    @Test
    void testCadastraGrupoJaCadastradoSemLimite() {
        this.controle.cadastraGrupo("Listas","10");
        assertEquals("GRUPO JÁ CADASTRADO!",this.controle.cadastraGrupo("Listas",""));
    }

    @Test
    void testAlocaAluno() {
        this.controle.cadastraGrupo("Programação OO","");

        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","Programação OO"));

        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("202","Programação OO"));
    }

    @Test
    void testAlocaAlunoMaiusculo() {
        this.controle.cadastraGrupo("Programação OO","");

        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","PROGRAMAÇÃO OO"));
    }

    @Test
    void testAlocaAlunoMinusculo() {
        this.controle.cadastraGrupo("Programação OO","");

        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","programação oo"));
    }

    @Test
    void testAlocaAlunoVariado() {
        this.controle.cadastraGrupo("Programação OO","");

        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","ProGraMaÇão Oo"));
    }

    @Test
    void testAlocaAlunoSegundaVez() {
        this.controle.cadastraGrupo("Programação OO","");
        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","Programação OO"));
        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("202","Programação OO"));


        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("200","Programação OO"));
    }

    @Test
    void testAlocaAlunoNaoCadastrado() {
        this.controle.cadastraGrupo("Programação OO","");
        assertEquals("Aluno não cadastrado.",this.controle.alocaAluno("100","Programação OO"));
    }

    @Test
    void testAlocaAlunoGrupoCheio() {
        this.controle.cadastraGrupo("Listas","1");
        assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("250","Listas"));
        assertEquals("GRUPO CHEIO",this.controle.alocaAluno("202","Listas"));
    }

    @Test
    void testAlocaAlunoGrupoNaoCadastrado() {
        assertEquals("Grupo não cadastrado.",this.controle.alocaAluno("200","Anatomia"));
    }

    @Test
    void testPertence() {
        this.controle.cadastraGrupo("Listas","1");
        this.controle.alocaAluno("250", "Listas");

        assertEquals("ALUNO PERTENCE AO GRUPO",this.controle.pertence("Listas","250"));
    }

    @Test
    void testPertenceMaiuscula() {
        this.controle.cadastraGrupo("Listas","1");
        this.controle.alocaAluno("250", "Listas");

        assertEquals("ALUNO PERTENCE AO GRUPO",this.controle.pertence("LISTAS","250"));
    }

    @Test
    void testPertenceMinuscula() {
        this.controle.cadastraGrupo("Listas","1");
        this.controle.alocaAluno("250", "Listas");

        assertEquals("ALUNO PERTENCE AO GRUPO",this.controle.pertence("listas","250"));
    }

    @Test
    void testPertenceVariado() {
        this.controle.cadastraGrupo("Listas","1");
        this.controle.alocaAluno("250", "Listas");

        assertEquals("ALUNO PERTENCE AO GRUPO",this.controle.pertence("LisTaS","250"));
    }

    @Test
    void testPertenceNaoPertencente() {
        this.controle.cadastraGrupo("Listas","1");

        assertEquals("ALUNO NÃO PERTENCE AO GRUPO",this.controle.pertence("Listas","202"));
    }

    @Test
    void testPertenceAlunoNaoCadastrado() {
        this.controle.cadastraGrupo("Listas","1");

        assertEquals("Aluno não cadastrado.",this.controle.pertence("Listas","100"));
    }

    @Test
    void testPertenceGrupoNaoCadastrado() {
        assertEquals("GRUPO NÃO CADASTRADO.",this.controle.pertence("Anatomia","200"));
    }

    @Test
    void testRegistraParticpacao() {
        assertEquals("ALUNO REGISTRADO!",this.controle.registraParticpacao("200"));
    }

    @Test
    void testRegistraParticpacaoAlunoNaoCadastrado() {
        assertEquals("Aluno não cadastrado.", this.controle.registraParticpacao("1"));
    }

    @Test
    void testAlunosParticipantes() {
        this.controle.registraParticpacao("200");
        this.controle.registraParticpacao("201");
        this.controle.registraParticpacao("200");

        assertEquals("1. 200 - Lili Camposh - Computação\n2. 201 - Torbjorn Lindholm - Engenharia Mecânica\n3. 200 - Lili Camposh - Computação\n",this.controle.alunosParticipantes());
    }

    @Test
    void testAlunosParticipantesVazio() {
        assertEquals("",this.controle.alunosParticipantes());
    }

    @Test
    void testGetGruposSemGrupo() {
        assertEquals("Grupos:\n",this.controle.getGrupos("202"));
    }

    @Test
    void testGetGrupos() {
        this.controle.cadastraGrupo("Programação OO","");
        this.controle.cadastraGrupo("Listas","");
        this.controle.alocaAluno("250", "Programação OO");
        this.controle.alocaAluno("250", "Listas");

        assertEquals("Grupos:\n- Programação OO\n- Listas\n",this.controle.getGrupos("250"));
    }

    @Test
    void testAlunosNaoParticiparam() {
        this.controle.registraParticpacao("200");
        this.controle.registraParticpacao("201");

        assertEquals("Alunos que não participaram:\n202 - Angela Ziegler - Medicina\n250 - Gabriel Reyes - Computação\n", this.controle.alunosNaoParticiparam());
    }

    @Test
    void testAlunosMaisChamados() {
        this.controle.registraParticpacao("200");
        this.controle.registraParticpacao("201");
        this.controle.registraParticpacao("200");
        this.controle.registraParticpacao("250");

        assertEquals("Aluno(s) mais chamado(s):\n200 - Lili Camposh - Computação- Vezes chamado: 2\n", this.controle.alunosMaisChamados());
    }

    @Test
    void testNumeroDeAlunosPorCurso() {
        this.controle.registraParticpacao("202");
        this.controle.registraParticpacao("200");
        this.controle.registraParticpacao("202");
        this.controle.registraParticpacao("250");

        assertEquals("Numero de alunos chamados por curso:\nComputação - Numero de vezes: 2\nMedicina - Numero de vezes: 2\n", controle.alunosPorCurso());
    }
}