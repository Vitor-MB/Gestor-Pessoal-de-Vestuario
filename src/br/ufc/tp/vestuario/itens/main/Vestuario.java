package br.ufc.tp.vestuario.itens.main;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import br.ufc.tp.vestuario.*;
import br.ufc.tp.vestuario.excecoes.NaoEmprestavelException;
import br.ufc.tp.vestuario.excecoes.NaoLavavelException;
import br.ufc.tp.vestuario.itens.*;

import javax.swing.*;
import java.awt.*;
import br.ufc.tp.vestuario.itens.AcessoriosEnum;

public class Vestuario {

	public static void main(String[] args) {
		/*
		// Criar janela
        JFrame frame = new JFrame("Selecionar Acessório");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Ordenar os enums em ordem alfabética
        AcessoriosEnum[] ordenados = Arrays.stream(AcessoriosEnum.values())
                                           .sorted((a, b) -> a.name().compareToIgnoreCase(b.name()))
                                           .toArray(AcessoriosEnum[]::new);

        // Criar JComboBox com os valores ordenados
        JComboBox<AcessoriosEnum> comboBox = new JComboBox<>(ordenados);

        // Label para mostrar resultado
        JLabel resultado = new JLabel("Parte do corpo: ");

        // Adiciona ação ao selecionar um item
        comboBox.addActionListener(e -> {
            AcessoriosEnum selecionado = (AcessoriosEnum) comboBox.getSelectedItem();
            if (selecionado != null) {
                resultado.setText("Parte do corpo: " + selecionado.getParteCorpo());
            }
        });

        // Adicionar componentes à janela
        frame.add(comboBox);
        frame.add(resultado);

        // Tornar visível
        frame.setVisible(true);
		 */
		
		BancoEmprestados emprestados = new BancoEmprestados();
		BancoItens Itens = new BancoItens();
		
		
		try{
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Não foi possével usar esse Look and Feel:" + e);
		}
			
		SwingUtilities.invokeLater(() -> {
		        JanelaPrincipal janela = new JanelaPrincipal();
		        
		});	

		
	
	}

}
