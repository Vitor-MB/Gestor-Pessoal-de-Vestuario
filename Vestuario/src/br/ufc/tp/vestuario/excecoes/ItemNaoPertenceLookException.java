package br.ufc.tp.vestuario.excecoes;

public class ItemNaoPertenceLookException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public ItemNaoPertenceLookException() {
		
		super("Esse item não pertence ao Look");
	}
}
