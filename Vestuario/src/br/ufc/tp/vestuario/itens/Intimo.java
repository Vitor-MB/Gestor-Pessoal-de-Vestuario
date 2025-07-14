package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public class Intimo extends Roupa{
	public Intimo(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho);
	}
	
}
