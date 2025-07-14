package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public abstract class Normal extends Roupa implements IEmprestavel {
	protected Boolean Emprestado;
	protected String Estilo;
	protected GregorianCalendar DataEmprestimo;
	
	public Normal(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho);
		Emprestado = false;
		this.Estilo = Estilo;
	}
	
	//EMPRESTIMO
	public void registrarEmprestimo(GregorianCalendar Deadline) {
		if(Emprestado) {
			System.out.println("Item já emprestado");
			
		}else {
			Emprestado = true;
			DataEmprestimo = Deadline;
			System.out.println("Item emprestado com sucesso!");
		}
	}
	
	public void registrarEmprestimo(int qtdDiad) {
		if(Emprestado) {
			System.out.println("Item já emprestado");
		}else {
			Emprestado = true;
			DataEmprestimo = new GregorianCalendar();
			DataEmprestimo.add(GregorianCalendar.DATE, qtdDiad);
			System.out.println("Item emprestado com sucesso!");
		}
	}
	
	public int qtdDiasEmprestado() {
		if(Emprestado) {
			long millis1 = DataEmprestimo.getTimeInMillis();
			long millis2 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)((millis1-millis2)/(1000*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public int diasParadevolucao() {
		if(Emprestado) {
			long Total = DataEmprestimo.getTimeInMillis();
			long millis1 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)((Total-millis1)/(1000*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public void registrarDevolucao() {
		if(Emprestado) {
			Emprestado = false;
		}
	}
	
	//GETS
	public String getEstilo() {
		return Estilo;
	}
	public Boolean getEmprestado() {
		return Emprestado;
	}

}
