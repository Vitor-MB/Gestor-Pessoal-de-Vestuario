package br.ufc.tp.vestuario.excecoes;

public class LookComRoupaEmprestadaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LookComRoupaEmprestadaException(String ID) {
		super("Não é possível usar Look: " + ID + "está emprestado");
	}

}
