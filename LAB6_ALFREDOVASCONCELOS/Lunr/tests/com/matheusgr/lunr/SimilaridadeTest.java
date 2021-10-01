package com.matheusgr.lunr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimilaridadeTest extends BaseTest{
    @Test
    void testSimilaridade(){
        assertEquals(0.5,this.similaridadeController.similaridade(TEXTO1_ID,TEXTO2_ID),"");
    }

    @Test
    void testSimilaridadeDiferentes(){
        this.documentoController.adicionaDocumentoTxt(TEXTO4_ID,"Testar a similaridade com diferença.\r");
        assertEquals(0,this.similaridadeController.similaridade(TEXTO1_ID,TEXTO4_ID),"");
    }

    @Test
    void testSimilaridadeIguais(){
        this.documentoController.adicionaDocumentoTxt(TEXTO3_ID,"um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
        assertEquals(1.0,this.similaridadeController.similaridade(TEXTO1_ID,TEXTO3_ID),"");
    }
}
