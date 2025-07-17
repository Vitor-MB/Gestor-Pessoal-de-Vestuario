package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.BancoEmprestados;

public interface IEmprestavel {
	public Boolean isEmprestado();
	
	public GregorianCalendar getDataEmprestimo();
	
	public GregorianCalendar getDataDevolucao();
    
	public Boolean registrarEmprestimo(BancoEmprestados Emprestados, GregorianCalendar Deadline);
	
	public Boolean registrarEmprestimo(BancoEmprestados Emprestados, int qtdDiad);
	
	public int qtdDiasEmprestado();
	
	public int diasParadevolucao();
	
	public Boolean registrarDevolucao(BancoEmprestados Emprestados);
}
