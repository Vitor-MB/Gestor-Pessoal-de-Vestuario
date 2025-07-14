package br.ufc.tp.vestuario.itens.main;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import br.ufc.tp.vestuario.*;

import br.ufc.tp.vestuario.itens.*;

public class Vestuario {

	public static void main(String[] args) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Item item = new SupInterno("Camisa Ceará", "Riachuello", "Azul", ConservacaoEnum.NOVA, new GregorianCalendar(2025, GregorianCalendar.JULY, 01), TamanhoEnum.M, "Esportivo");
		
		BancoItens Itens = new BancoItens();
		
		Itens.AdicionarItem(item);		
		Itens.AdicionarItem(new SupExterno("Casaco Adidas", "Adidas", "Preto", ConservacaoEnum.RUIM, new GregorianCalendar(2025, GregorianCalendar.JUNE, 25), TamanhoEnum.M, "Casual"));
		
		Item A = Itens.getItem("Casaco Adidas");
		
		((Roupa) A).lavar();
		
		((Normal)item).registrarEmprestimo(15);
		
		System.out.println(item.getID());
		
		System.out.println("Dias para a devolução:"+((Normal) item).diasParadevolucao());
		
		

	}

}
