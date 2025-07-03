package br.main.banco.itens;

import java.util.Date;

public abstract class Roupa extends Item implements ILavavel {
	protected Date ultima_lavagem;
	
	public Roupa(String tipo, String Loja_Origem, String Cor, String Conservacao, int vezes_usado) {
		super(tipo, Loja_Origem, Cor, Conservacao, vezes_usado);
		this.ultima_lavagem = null;
	}
	
	
	//Salva a data do computador e varia de acordo com o tipo
		public void lavar() {
			ultima_lavagem.setTime(System.currentTimeMillis()); // Vai atualizar a data da ultima lavagem automaticamente
		}
		
		//O usuário registra a lavagem
		
		@SuppressWarnings("deprecation")
		public void registrarLavagem(String data) {
			String Data[] = data.split(data);
			
			//Registra a data mês e ano
			ultima_lavagem.setDate(Integer.parseInt(Data[0]));
			ultima_lavagem.setMonth(Integer.parseInt(Data[1]));
			ultima_lavagem.setYear(Integer.parseInt(Data[2]));
			
		}
		
		//Informa a ultima lavagem
		public Date getUltima_lavagem() {
			return ultima_lavagem;
		}
	
	
}
