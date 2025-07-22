package br.ufc.tp.vestuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.tp.vestuario.itens.*;

public class BancoItens {
	
	private Map<String, Item> Itens;
	
	private static BancoItens instancia;
	
	public BancoItens() {
		Itens = new HashMap<String, Item>();
	}
	//Variavel global
	public static BancoItens getInstancia() {
        if (instancia == null) {
            instancia = new BancoItens();
        }
        return instancia;
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
	
	//FILTROS PARA AS CLASSES
	
	public List<Item> getSupInternos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof SupInterno)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getSupExternos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof SupExterno)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getInferiores() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Inferior)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getCalcados() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Calcado)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> Intimos() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Intimo)  lista.add(i);
	    }
	    return lista;
	}
	
	public List<Item> getAcessorios() {
	    List<Item> lista = new ArrayList<>();
	    for (Item i : this.Itens.values()) {
	        if (i instanceof Acessorio)  lista.add(i);
	    }
	    return lista;
	}
}
