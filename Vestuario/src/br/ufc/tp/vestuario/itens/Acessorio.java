package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public class Acessorio extends Item implements IEmprestavel {

	protected MaterialEnum material;
	protected Boolean Emprestado;
	protected GregorianCalendar DataEmprestimo;
	
	public Acessorio(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, MaterialEnum Material) {
		super(id, Loja_Origem,Cor, Conservacao);
		this.material = Material;
		Emprestado = false;
	}
	
	public String getMaterial() {
		return material.getCode();
	}
	
	public void registrarEmprestimo(GregorianCalendar Deadline) {
		if(Emprestado) {
			System.out.println("Item já emprestado");
			
		}else {
			Emprestado = true;
			DataEmprestimo = Deadline;
			System.out.println("Item empretado");
		}
	}
	
	public void registrarEmprestimo(int qtdDiad) {
		if(Emprestado) {
			System.out.println("Item já emprestado");
		}else {
			Emprestado = true;
			DataEmprestimo = new GregorianCalendar();
			DataEmprestimo.add(GregorianCalendar.DATE, qtdDiad);
			System.out.println("Item empretado");
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
	

}
