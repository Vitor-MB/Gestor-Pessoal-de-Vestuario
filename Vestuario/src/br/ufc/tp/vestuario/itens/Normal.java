package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public abstract class Normal extends Roupa {
	
	protected String Estilo;
	
	public Normal(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho);
		this.Estilo = Estilo;
	}
	
	//EMPRESTIMO
	
	//GETS
	public String getEstilo() {
		return Estilo;
	}

}
