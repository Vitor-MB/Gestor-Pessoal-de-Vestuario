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
		
		i.Emprestar(Emprestados, 15);
		
		item.Emprestar(Emprestados, 15);
		A.Emprestar(Emprestados, new GregorianCalendar(2025, GregorianCalendar.JULY, 20));
		
		Emprestados.ListarEmprestados();
		
		item.Devolucao(Emprestados);
		
		Emprestados.ListarEmprestados();
		
		Itens.ListarItens();
		
		Itens.RemoverItem("Cueca");
		
		Itens.ListarItens();
		
		Item a = Itens.getItem("Camisa Brasil");
		
		
		
		

	}

}
