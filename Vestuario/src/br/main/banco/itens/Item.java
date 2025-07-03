package br.main.banco.itens;

public abstract class Item {

	private String tipo;
	private String Loja_Origem;
	private String Cor;
	private String Conservacao;
	
	public Item( String tipo, String Loja_Origem, String Cor, String Conservacao) {
		this.tipo = tipo;
		this.Loja_Origem = Loja_Origem;
		this.Cor = Cor;
		this.Conservacao = Conservacao;
		
	}
	
	//Opção do usuário de cadastrar
	public abstract boolean cadastrar();
	//Opção de editar
	public abstract boolean editar();
	//Opção de deletar
	public abstract boolean deletar();
	
	
	//Gets
	public String get_tipo(){
		return tipo;
	}
	
	public String get_cor() {
		return Cor;
	}
	
	public String get_loja() {
		return Loja_Origem;
	}
	
	public String get_conservacao() {
		return Conservacao;
	}
	
}
