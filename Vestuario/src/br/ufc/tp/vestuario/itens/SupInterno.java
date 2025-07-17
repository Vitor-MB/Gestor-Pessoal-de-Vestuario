package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.BancoEmprestados;

public class SupInterno extends Superior implements IEmprestavel {
	protected Boolean emprestado;
	protected GregorianCalendar dataEmprestimo;
	protected GregorianCalendar dataDevolucao;
	
	public SupInterno(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho, Estilo);
		emprestado = false;
	}
	
	// ------------------------ METODOS EMPRESTIMO ------------------------------
	
	public Boolean registrarEmprestimo(BancoEmprestados Emprestados, GregorianCalendar Deadline) {
		if(emprestado) {
			System.out.println("Item já emprestado");
			return false;
			
		}else {
			emprestado = true;
			dataEmprestimo = new GregorianCalendar();
			dataDevolucao = Deadline;
			Emprestados.adicionar(this);
			System.out.println("Item emprestado com sucesso!");
			return true;
		}
	}
	
	public Boolean registrarEmprestimo(BancoEmprestados Emprestados, int qtdDiad) {
		if(emprestado) {
			System.out.println("Item já emprestado");
			return false;
		}else {
			emprestado = true;
			dataDevolucao = new GregorianCalendar();
			dataEmprestimo = new GregorianCalendar();
			dataDevolucao.add(GregorianCalendar.DATE, qtdDiad);
			Emprestados.adicionar(this);
			System.out.println("Item emprestado com sucesso!");
			return true;
		}
	}
	
	public GregorianCalendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public GregorianCalendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	public int qtdDiasEmprestado() {
		if(emprestado) {
			long millis1 = dataEmprestimo.getTimeInMillis();
			long millis2 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)Math.ceil((millis2-millis1)/(1000.0*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public int diasParadevolucao() {
		if(emprestado) {
			long Total = dataDevolucao.getTimeInMillis();
			long millis1 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)Math.ceil((Total-millis1)/(1000.0*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public Boolean registrarDevolucao(BancoEmprestados Emprestados) {
		if(emprestado) {
			emprestado = false;
			Emprestados.remover(this);
			return true;
		}else {
			System.out.println("Item não está Emprestado");
			return false;
		}
	}
	
	public Boolean isEmprestado() {
		return emprestado;
	}

}
