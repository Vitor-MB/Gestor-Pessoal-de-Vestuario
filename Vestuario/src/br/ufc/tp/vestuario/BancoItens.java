package br.ufc.tp.vestuario;

import java.util.HashMap;
import java.util.Map;

import br.ufc.tp.vestuario.itens.Item;

public class BancoItens {
	
	private Map<String, Item> Itens;
	
	public BancoItens() {
		Itens = new HashMap<String, Item>();
	}
	
	
	public void AdicionarItem(Item i) {
		if(!Itens.containsKey(i.getID())) {
			Itens.put(i.getID(), i);
			System.out.println("Item adicionado com sucesso!");
		}else {
			System.out.println("Já existe um item com esse ID");
		}
	}
	
	public void RemoverItem(Item i) {
		if(Itens.containsKey(i.getID())) {
			Itens.remove(i.getID());
			System.out.println("Item removido");
		}else {
			System.out.println("Esse item não existe");
		}
	}
	
	public void RemoverItem(String Id) {
		if(Itens.containsKey(Id)) {
			Itens.remove(Id);
			System.out.println("Item removido");
		}else {
			System.out.println("Esse item não existe");
		}
	}
	
	public Item getItem(String Id) {
		if(Itens.containsKey(Id)) {
			System.out.println("Item encontrado!");
			return Itens.get(Id);
		}else {
			System.out.println("Esse item nao existe");
			return null;
		}
	
	}
	
	
	
}
