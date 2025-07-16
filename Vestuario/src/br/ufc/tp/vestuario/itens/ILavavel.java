package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public interface ILavavel {
		//Salva a data do computador e varia de acordo com o tipo
		public void lavar(String tipo);
		
		//O usuário registra a lavagem
		public void registrarLavagem();
		
		//Informa a ultima lavagem
		public GregorianCalendar ultima_lavagem();
}
