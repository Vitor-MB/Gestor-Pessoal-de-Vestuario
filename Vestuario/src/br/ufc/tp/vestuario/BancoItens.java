package br.ufc.tp.vestuario;

import java.util.HashMap;
import java.util.Map;

import br.ufc.tp.vestuario.itens.Item;

public class BancoItens {
	
	private Map<String, Item> Itens;
	
	public BancoItens() {
		Itens = new HashMap<String, Item>();
	}
	
	public Boolean CadastrarItem(Item i) {
		if(!Itens.containsKey(i.getID())) {
			Itens.put(i.getID(), i);
			System.out.println("Item adicionado com sucesso!");
			return true;
		}else {
			System.out.println("Já existe um item com esse ID");
			return false;
		}
	}
	
	public Boolean RemoverItem(Item i) {
		if(Itens.containsKey(i.getID())) {
			Itens.remove(i.getID());
			System.out.println("Item removido");
			return true;
		}else {
			System.out.println("Esse item não existe");
			return false;
		}
	}
	
	public Boolean RemoverItem(String Id) {
		if(Itens.containsKey(Id)) {
			Itens.remove(Id);
			System.out.println("Item removido");
			return true;
		}else {
			System.out.println("Esse item não existe!");
			return false;
		}
	}
	
	public Item getItem(String Id) {
		if(Itens.containsKey(Id)) {
			System.out.println("Item encontrado!");
			return Itens.get(Id);
		}else {
			System.out.println("Esse item nao existe!");
			return null;
		}
	
	}
	
	public Map<String, Item> getBancoItens(){
		return Itens;
	}
	
	public void ListarItens() {
		System.out.println("\nLista de Itens:");
		for(Item i : this.Itens.values()) {
			System.out.println("ID:\"" + i.getID() +"\"/ Conservação: "+ i.getConservacao()+" /Loja: " + i.getLoja()+" /Cor: " + i.getCor());
		}
		System.out.println();
	}
	
	
}
