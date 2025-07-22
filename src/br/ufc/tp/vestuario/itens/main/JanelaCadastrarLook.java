package br.ufc.tp.vestuario.itens.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import br.ufc.tp.vestuario.BancoItens;
import br.ufc.tp.vestuario.itens.Acessorio;
import br.ufc.tp.vestuario.itens.Calcado;
import br.ufc.tp.vestuario.itens.ConservacaoEnum;
import br.ufc.tp.vestuario.itens.EstilosEnum;
import br.ufc.tp.vestuario.itens.Inferior;
import br.ufc.tp.vestuario.itens.Intimo;
import br.ufc.tp.vestuario.itens.Item;
import br.ufc.tp.vestuario.itens.MaterialEnum;
import br.ufc.tp.vestuario.itens.SupExterno;
import br.ufc.tp.vestuario.itens.SupInterno;
import br.ufc.tp.vestuario.itens.TamanhoEnum;

public class JanelaCadastrarLook extends JFrame{
	public JanelaCadastrarLook() {
		super("Cadastre seu Look");
		
		BancoItens Itens = BancoItens.getInstancia();
		
		setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Se tentar fechar a janela
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaCadastrarLook.this,
                    "Deseja fechar a janela de Cadastrar Look",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.DEFAULT_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    dispose();
                    JanelaCadastrar Cadastro = new JanelaCadastrar();
                }
            }
        });
        
        JPanel pane = new JPanel();
        pane.setBounds(50, 30, 1100,620);
        pane.setBackground(Color.decode("#20273b"));
        pane.setLayout(null);
        
        JLabel labelAcessorio= new JLabel("Acessorio:");
        labelAcessorio.setForeground(Color.WHITE);
        labelAcessorio.setBounds(400, 30, 200, 20);
        JList<Item> Acessorios = new JList<Item>(Itens.getAcessorios().toArray(new Acessorio[0]));
        Acessorios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Acessorios.setBounds(400, 50, 150, 30);
        
        JLabel labelInterno= new JLabel("SupInterno:");
        labelInterno.setForeground(Color.WHITE);
        labelInterno.setBounds(400, 100, 200, 20);
        JComboBox<Item> SupInterno = new JComboBox<Item>(Itens.getSupInternos().toArray(new SupInterno[0]));
        SupInterno.setBounds(400, 120, 150, 30);
        
        JLabel labelExterno= new JLabel("SupExterno:");
        labelExterno.setForeground(Color.WHITE);
        labelExterno.setBounds(560, 100, 200, 20);
        JComboBox<Item> SupExterno = new JComboBox<Item>(Itens.getSupExternos().toArray(new SupExterno[0]));
        SupExterno.setBounds(560, 120, 150, 30);
        
        JLabel labelInferior= new JLabel("Inferior:");
        labelInferior.setForeground(Color.WHITE);
        labelInferior.setBounds(400, 170, 200, 20);
        JComboBox<Item> Inferior = new JComboBox<Item>(Itens.getInferiores().toArray(new Inferior[0]));
        Inferior.setBounds(400, 190, 150, 30);
        
        JLabel labelCalcado= new JLabel("Calçado::");
        labelCalcado.setForeground(Color.WHITE);
        labelCalcado.setBounds(400, 240, 200, 20);
        JComboBox<Item> Calcados = new JComboBox<Item>(Itens.getCalcados().toArray(new Calcado[0]));
        Calcados.setBounds(400, 260, 150, 30);
        
        
        
        
        
        JButton Salvar = new JButton("Salvar");
        Salvar.setBounds(10, 500, 80, 30);
        Salvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				
		        
		        
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        JButton Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(100, 500, 100, 30);
        Cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaCadastrar();
				
			}
		});
        
        JButton LimparTudo = new JButton("LimparTudo");
        LimparTudo.setBounds(210, 500, 150, 30);
        LimparTudo.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				 	
				
			}
		});
        
        
        pane.add(Salvar);
        pane.add(Cancelar);
       
        pane.add(Acessorios);
        pane.add(SupInterno);
        pane.add(SupExterno);
        pane.add(Inferior);
        pane.add(Calcados);
        pane.add(labelAcessorio);
        pane.add(labelInterno);
        pane.add(labelExterno);
        pane.add(labelInferior);
        pane.add(labelCalcado);
        add(pane);
        setVisible(true);
	}
	

}
