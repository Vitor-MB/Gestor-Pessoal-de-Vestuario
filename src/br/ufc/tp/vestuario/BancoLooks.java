package br.ufc.tp.vestuario;

import java.util.List;
import java.util.ArrayList;

public class BancoLooks {
	
	private List<Look> Looks;
	
	public BancoLooks() {
		Looks = new ArrayList<Look>();
	}
	
	public boolean salvar(Look l) {
		if(l.isLookValido()) {
			if(!Looks.contains(l)) {
				System.out.println("Look salvo");
				Looks.add(l);
				return true;
			}else {
				System.out.println("Esse look já existe");
				return false;
			}
		}else{
			System.out.println("Look inválido!");
			return false;
		}
	}
	
	public boolean deletar(Look l) {
		if(Looks.contains(l)) {
			Looks.remove(l);
			System.out.println("Look removido!");
			return true;
		}else {
			System.out.println("Look não existe");
			return false;
		}
	}

}
