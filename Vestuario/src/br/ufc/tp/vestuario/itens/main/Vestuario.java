package br.ufc.tp.vestuario.itens.main;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import br.ufc.tp.vestuario.*;

import br.ufc.tp.vestuario.itens.*;

public class Vestuario {

	public static void main(String[] args) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//Possibilidade do usuario criar lojas(Usar um hashmao pra armazenar ai cadastra a loja de origem de acordo com esses caras
		
		BancoItens Itens = new BancoItens();
		BancoEmprestados Emprestados = new BancoEmprestados();
		
		
		Item item = new SupInterno("Camisa Ceará", "Riachuello", "Azul", ConservacaoEnum.NOVA, new GregorianCalendar(2025, GregorianCalendar.JULY, 01), TamanhoEnum.M, "Esportivo");
		Itens.CadastrarItem(item);		
		
		Itens.CadastrarItem(new SupExterno("Casaco Adidas", "Adidas", "Preto", ConservacaoEnum.RUIM, new GregorianCalendar(2025, GregorianCalendar.JUNE, 25), TamanhoEnum.M, "Casual"));
		
		Item A = Itens.getItem("Casaco Adidas");
		
		Itens.CadastrarItem(new Intimo("Cueca", "Adidas", "Preto", ConservacaoEnum.BOA, new GregorianCalendar(2025, GregorianCalendar.JULY, 12), TamanhoEnum.M));
		
		Item i = Itens.getItem("Cueca");
		
		
		item.Emprestar(Emprestados, 15);
		
		
		Itens.ListarItens();
		i.Editar(Itens, new Intimo("Cueca", "CK", "Azul", ConservacaoEnum.RUIM, new GregorianCalendar(2025, GregorianCalendar.JULY, 12), TamanhoEnum.PP));
		item.Editar(Itens, new SupInterno("Camisa Ceará", "Vozão", "Preta", ConservacaoEnum.BOA, new GregorianCalendar(2025, GregorianCalendar.JULY, 01), TamanhoEnum.M, "Esportivo"));
		Itens.ListarItens();
		
		Item B = new SupInterno("Camisa Basica", "Riachuello", "Preta", ConservacaoEnum.NOVA, new GregorianCalendar(2025, GregorianCalendar.JULY, 01), TamanhoEnum.M, "Casual");
		B.Emprestar(Emprestados, 15);
		
		Emprestados.ListarEmprestados();
		Itens.ListarItens();
		

		

	}

}
