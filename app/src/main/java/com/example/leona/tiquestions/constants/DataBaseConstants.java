package com.example.leona.tiquestions.constants;

public class DataBaseConstants {
    private DataBaseConstants(){


    }
    public static class PERGUNTAS {
        public static final String NOME_TABELA="Perguntas";
        public static class COLUNAS {
            public static final String IDPERGUNTA = "idPergunta";
            public static final String CODPERGUNTA = "codPergunta";
            public static final String ENUNCIADO = "enunciado";
            public static final String TIPO = "tipo";
            public static final String ITEMA = "itemA";
            public static final String ITEMB = "itemB";
            public static final String ITEMC = "itemC";
            public static final String ITEMD = "itemD";
            public static final String RESPOSTASUBJETIVA = "respostaSubjetiva";
            public static final String ITEMCORRETO = "itemCorreto";
            public static final String NIVEL = "nivel";
            public static final String PONTOSPERGUNTA = "pontosPergunta";
            public static final String FOISORTEADA = "foiSorteada";
            public static final String AREA = "area";
        }
    }
    public static class EQUIPE {
        public static final String NOME_TABELA="Equipes";
        public static class COLUNAS {
            public static final String IDEQUIPE = "idEquipe";
            public static final String NOMEEQUIPE = "nome";
            public static final String PONTOSEQUIPE = "pontos";

        }
    }
}
