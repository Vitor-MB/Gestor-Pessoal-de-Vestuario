package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CadastrarItemListener implements ActionListener{
	private JFrame janela;

    // Construtor que recebe a janela principal
    public CadastrarItemListener(JFrame janela) {
        this.janela = janela;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object fonte = e.getSource();
		
		JanelaCadastroItem Cadastro = new JanelaCadastroItem();
		
		this.janela.dispose();
		
	}
	
}
