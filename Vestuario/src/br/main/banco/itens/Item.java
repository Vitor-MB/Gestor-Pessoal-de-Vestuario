package br.main.banco.itens;

public abstract class Item {

	protected String tipo;
	protected String Loja_Origem;
	protected String Cor;
	protected String Conservacao;
	protected int vezes_usado;
	
	public Item( String tipo, String Loja_Origem, String Cor, String Conservacao, int vezes_usado) {
		this.tipo = tipo;
		this.Loja_Origem = Loja_Origem;
		this.Cor = Cor;
		this.Conservacao = Conservacao;
		this.vezes_usado = vezes_usado;
		
	}
	
	//Opção do usuário de cadastrar
	public abstract boolean cadastrar();
	//Opção de editar
	public abstract boolean editar();
	//Opção de deletar
	public abstract boolean deletar();
	
	
	//Gets
	public String getTipo(){
		return tipo;
	}
	
	public String getCor() {
		return Cor;
	}
	
	public String getLoja() {
		return Loja_Origem;
	}
	
	public String getConservacao() {
		return Conservacao;
	}
	
}
