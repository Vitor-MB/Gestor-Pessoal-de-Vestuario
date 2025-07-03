package br.main.banco.itens;

//Variavel de Data
import java.util.Date;

public interface ILavavel {
	
	//Salva a data do computador e varia de acordo com o tipo
	public void lavar(String tipo);
	
	//O usuário registra a lavagem
	public void registrarLavagem();
	
	//Informa a ultima lavagem
	public Date ultima_lavagem();
	
}
