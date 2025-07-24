package br.ufc.tp.vestuario.excecoes;

public class DeletarRoupaEmLookException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeletarRoupaEmLookException(String IDitem) {
		super(IDitem + " está em um Look ");
	}
}
