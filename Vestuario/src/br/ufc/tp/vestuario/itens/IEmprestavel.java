package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public interface IEmprestavel {
		
	public void registrarEmprestimo(GregorianCalendar Deadline);
	
	public void registrarEmprestimo(int qtdDiad);
	
	public int qtdDiasEmprestado();
	
	public int diasParadevolucao();
	
	public void registrarDevolucao();
}
