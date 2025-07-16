package br.ufc.tp.vestuario;

import br.ufc.tp.vestuario.itens.IEmprestavel;
import br.ufc.tp.vestuario.itens.Item;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BancoEmprestados {
	
	private List<IEmprestavel> Emprestados;


	public BancoEmprestados() {
		Emprestados = new ArrayList<IEmprestavel>();
	}
	
	public Boolean adicionar(Item i) {
		IEmprestavel e = (IEmprestavel) i;
		
		if(Emprestados.contains(e)) {
			System.out.println(i.getID() + " já está registrado no Banco de emprestimos");
			return false;
		}
		else {
			Emprestados.add(e);
			System.out.println(i.getID() + " registrado no Banco de Emprestimos");
			return true;
		}
	}
	
	public Boolean remover(Item i) {
		IEmprestavel e = (IEmprestavel) i;
		if(Emprestados.contains(e)) {
			System.out.println(i.getID() +  " removido do Banco de Emprestimos!");
			Emprestados.remove(e);
			return true;
		}else {
			System.out.println(i.getID() + " não está no Banco de emprestimo");
			return false;
		}
	}	
	
	public void ListarEmprestados() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\nLista de Itens Emprestados:");
		for(IEmprestavel e : Emprestados) {
			Item i = (Item) e;
				System.out.println(i.getID() + " (Emprestado em: " + formato.format(e.getDataEmprestimo().getTime()) + " - Data de devolução: " + formato.format(e.getDataDevolucao().getTime()) + ") " + e.diasParadevolucao() + " Dias para a devolução");
			}
		System.out.println();
		}
	
}

