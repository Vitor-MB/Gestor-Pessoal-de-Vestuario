package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;


public class SupInterno extends Superior {
	protected Boolean emprestado;
	protected GregorianCalendar dataEmprestimo;
	protected GregorianCalendar dataDevolucao;
	
	public SupInterno(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, tamanho, Estilo);
		emprestado = false;
	}
	
}
