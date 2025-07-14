package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public class Inferior extends Normal {
	public Inferior(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho, Estilo);
	}
}
