package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.*;

public abstract class Item {

	protected String id; //Nome
	protected String Loja_Origem;
	protected String Cor;
	protected ConservacaoEnum Conservacao;
	
	protected int qtdUsos;
	
	public Item(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao) {
		this.id = id;
		this.Loja_Origem = Loja_Origem;
		this.Cor = Cor;
		this.Conservacao = Conservacao;
		qtdUsos = 0;
	}
	
	//Gets
	public String getID() {
		return id;
	}
	public int getQtdUsos() {
		return qtdUsos;
	}
	public String getCor() {
		return Cor;
	}
	public String getLoja() {
		return Loja_Origem;
	}
	public ConservacaoEnum getConservacao() {
		return Conservacao;
	}
	public Boolean isEmprestavel() {
		return this instanceof IEmprestavel;
	}
	
	//EMPRESTAR
	public void Emprestar(BancoEmprestados Emprestados, int qtdDias) {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			e.registrarEmprestimo(Emprestados, qtdDias);
		}
		else {
			System.out.println("Esse item não é Emprestável!\n");
		}
	}
	public void Emprestar(BancoEmprestados Emprestados, GregorianCalendar Deadline) {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			e.registrarEmprestimo(Emprestados, Deadline);
		}
		else {
			System.out.println("Esse item não é Emprestável!\n");
		}
	}
	
	public void Devolucao(BancoEmprestados Emprestados) {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			if(e.registrarDevolucao(Emprestados)) 
				System.out.println(this.getID() + " Devolvido");
		}
		else {
			System.out.println("Esse item não é Emprestável!\n");
		}
	}
		
		
	//EDITAR ITEM
	public void Editar(BancoItens Itens, Item editado) {
		//Verifica se sao da mesma classe
		if (!this.getClass().equals(editado.getClass())) {
	        System.out.println("Itens de tipos diferentes. Não é possível editar.");
	        return;
	    }
		
		if(this instanceof Roupa) {
			Roupa modificado = ((Roupa) editado);
			Roupa i = ((Roupa) this);
			
			//Caso mude o ID, cadastrar novamente no HashMap com outro ID
			if(this.id != editado.id) {
				Itens.RemoverItem(this);
				this.id = editado.id;
				Itens.CadastrarItem(this);	
			}
			this.Cor = editado.Cor;
			this.Conservacao = editado.Conservacao;
			this.Loja_Origem = editado.Loja_Origem;
			i.tamanho = modificado.tamanho;
			System.out.println("Item editado!\n");
			
		}
		else if(this instanceof Acessorio) {
			Acessorio modificado = ((Acessorio) editado);
			Acessorio i = ((Acessorio) this);
			
			if(this.id != editado.id) {
				Itens.RemoverItem(this);
				this.id = editado.id;
				Itens.CadastrarItem(this);	
			}
			this.Cor = editado.Cor;
			this.Conservacao = editado.Conservacao;
			this.Loja_Origem = editado.Loja_Origem;
			i.material = modificado.material;
			System.out.println("Item editado!\n");
		}
		
	}
	
	
}
