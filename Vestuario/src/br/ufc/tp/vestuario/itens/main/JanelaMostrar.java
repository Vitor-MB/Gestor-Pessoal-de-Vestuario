package br.ufc.tp.vestuario.itens.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import br.ufc.tp.vestuario.*;
import br.ufc.tp.vestuario.excecoes.ItemNaoExistenteException;
import br.ufc.tp.vestuario.excecoes.PreenchimentoInvalidoExcption;
import br.ufc.tp.vestuario.itens.*;

public class JanelaMostrar extends JFrame{
	public JanelaMostrar() {
		super("Inventário");
		
		BancoItens Itens =  BancoItens.getInstancia();
		BancoLooks Looks = BancoLooks.getInstancia();
		BancoEmprestados Emprestados = BancoEmprestados.getInstancia();
		
		Map<String, Item> ItensH = (HashMap<String,Item>) Itens.getBancoItens();
		List<Look> LooksH = (ArrayList<Look>) Looks.getLooks();
		
		setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Aqui vai voltar pra tela principal
            public void windowClosing(WindowEvent e) {
                JanelaPrincipal Principal = new JanelaPrincipal();
            }
        });
        
        
         
        
        String[] colunas = {"Id", "Cor", "Loja", "Conservação"};    
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
   
        for(Item i : ItensH.values()) {
        	modelo.addRow(new Object[] {i.getID() , i.getCor() , i.getLoja() , i.getConservacao().getString()});
        }
        
        JPanel MostrarItens = new JPanel();
        MostrarItens.setLayout(new BoxLayout(MostrarItens, BoxLayout.Y_AXIS));
        
        JTable TabelaItens = new JTable(modelo);
        //Formatacao da tabela
        TabelaItens.setRowHeight(20);
        TabelaItens.getColumnModel().getColumn(0).setPreferredWidth(200); // parte do Id
        TabelaItens.getColumnModel().getColumn(1).setPreferredWidth(80); // '' Cor
        TabelaItens.getColumnModel().getColumn(2).setPreferredWidth(90); // '' Loja
        TabelaItens.getColumnModel().getColumn(3).setPreferredWidth(150); // '' Conservação
        
        SimpleDateFormat DataFormato = new SimpleDateFormat("dd/MM/yyyy");
        
        JButton bExcluir = new JButton("Excluir");
		JButton bEditar = new JButton("Editar");
		JButton bLavar = new JButton("Lavar");
		
		JButton Emprestar = new JButton("Emprestar");
		JButton Devolucao = new JButton("Devolução");
		
		JButton RegistrarUso = new JButton("Registrar Uso");
		JButton RegistrarUsoL = new JButton("Registrar Uso Look");
		
		JButton Infos = new JButton("Info");
		JButton InfosL = new JButton("Info");
		
		
		Infos.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaItens.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
						
						
						String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
						Item i = Itens.getItem(Id);
						JPanel painel = new JPanel(new GridLayout(0, 2));
			            painel.add(new JLabel("Qtd Usos:"));
			            painel.add(new JLabel(String.valueOf(i.getQtdUsos())));
			            painel.add(new JLabel("Emprestado:"));
			            painel.add(new JLabel(String.valueOf(i.isEmprestado())));
			            
			            if(i.isEmprestado()) {
			            	 painel.add(new JLabel("Data para Devolução:"));
					         painel.add(new JLabel(String.valueOf(DataFormato.format(((IEmprestavel) i).getDataDevolucao().getTime())) +" Faltam:"+ String.valueOf(((IEmprestavel) i ).diasParadevolucao()) + " dias"));
					         painel.add(new JLabel("Dias Emprestado:"));
					         painel.add(new JLabel(String.valueOf(((IEmprestavel) i).qtdDiasEmprestado())));
			            }
			            
			            if(i.isLavavel()) {
			            	painel.add(new JLabel("Ultima Lavagem"));
			            	if(((ILavavel) i).getUltimaLavagem() == null)
			            		painel.add(new JLabel("Não registrado uma lavagem"));
			            	else {
			            		painel.add(new JLabel(String.valueOf(((ILavavel) i).getUltimaLavagem().getTime())));
			            	}
			            }
			           
			            JOptionPane.showConfirmDialog(null, painel, "Digite a data", JOptionPane.OK_CANCEL_OPTION);
			            
			          
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
					}
			}
			}
		});
		
		
		
		Devolucao.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaItens.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
					String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
					Item i = Itens.getItem(Id);
		
	                i.Devolucao(Emprestados);
	                JOptionPane.showMessageDialog(null, "Item Devolvido");
		     
		            
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				}
			}
				
		});
		
		bLavar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaItens.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
					String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
					Item i = Itens.getItem(Id);
		
	                if(i.isLavavel()) {
	                	((ILavavel) i).lavar();
	                	JOptionPane.showMessageDialog(null, "Lavagem registrada");
	                }else {
	                	JOptionPane.showMessageDialog(null, "Item não lavável");
	                }
		     
		            
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				}
			}
				
		});
		bLavar.setBounds(200, 315 , 100, 30);
		add(bLavar);
		
		Emprestar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaItens.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
					String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
					Item i = Itens.getItem(Id);
					
					MaskFormatter diaMask = new MaskFormatter("##");
		            MaskFormatter anoMask = new MaskFormatter("####");
		            diaMask.setPlaceholderCharacter('_');
		            anoMask.setPlaceholderCharacter('_');
	
		            JFormattedTextField cDia = new JFormattedTextField(diaMask);
		            JFormattedTextField cMes = new JFormattedTextField(diaMask);
		            JFormattedTextField cAno = new JFormattedTextField(anoMask);
	
		            JPanel painel = new JPanel(new GridLayout(0, 2));
		            painel.add(new JLabel("Dia:"));
		            painel.add(cDia);
		            painel.add(new JLabel("Mês:"));
		            painel.add(cMes);
		            painel.add(new JLabel("Ano:"));
		            painel.add(cAno);
	
		            int opcao = JOptionPane.showConfirmDialog(null, painel, "Digite a data", JOptionPane.OK_CANCEL_OPTION);
		            
		            if (opcao == JOptionPane.OK_OPTION) {
		                int dia = Integer.parseInt(cDia.getText().trim());
		                int mes = Integer.parseInt(cMes.getText().trim());
		                int ano = Integer.parseInt(cAno.getText().trim());
	
		                validarData(dia, mes, ano);
		                GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
		                i.Emprestar(Emprestados, data);
		                JOptionPane.showMessageDialog(null, "Item Emprestado");
		     
		            }
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				}
			}
		});
		 
		 bExcluir.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 try {
					int linhaSelecionada = -1;
					linhaSelecionada = TabelaItens.getSelectedRow();
					if (linhaSelecionada >= 0) {
						String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
						Itens.RemoverItem(Id);
						modelo.removeRow(linhaSelecionada);
					} else {
						JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
					}
				 }catch(Exception e1) {
					 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		 
		 RegistrarUso.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int linhaSelecionada = -1;
					linhaSelecionada = TabelaItens.getSelectedRow();
					if (linhaSelecionada >= 0) {
						try {
						String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
						Item i = Itens.getItem(Id);
					    i.registrarUso();
						
						JOptionPane.showMessageDialog(null, "Uso registrado");
						}
						catch(Exception e1) {
							 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
						 }
					}else {
						JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
					}
					
				}
			});
		 
		 
		 bEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					int linhaSelecionada = -1;
					linhaSelecionada = TabelaItens.getSelectedRow();
					if (linhaSelecionada >= 0) {
						String Id = (String)TabelaItens.getValueAt(linhaSelecionada, 0);
						Item i = Itens.getItem(Id);
						
						if(i instanceof Acessorio) {
							JTextField cId = new JTextField();
							JTextField cLoja = new JTextField();
							JTextField cCor = new JTextField();
							
							
							JComboBox<ConservacaoEnum> cConser = new JComboBox<ConservacaoEnum>(ConservacaoEnum.values());
							JComboBox<MaterialEnum> cMaterial = new JComboBox<MaterialEnum>(MaterialEnum.values());
							cId.setText(i.getID());
							cLoja.setText(i.getLoja());
							cCor.setText(i.getCor());
							cConser.setSelectedItem(i.getConservacao());
							cMaterial.setSelectedItem(((Acessorio) i).getMaterial());
	
							JPanel editor = new JPanel(new GridLayout(0, 1));
							editor.add(new JLabel("Id:"));
							editor.add(cId);
							editor.add(new JLabel("Loja:"));
							editor.add(cLoja);
							editor.add(new JLabel("Cor:"));
							editor.add(cCor);
							editor.add(new JLabel("Conservação:"));
							editor.add(cConser);
							editor.add(new JLabel("Material:"));
							editor.add(cMaterial);
							
	
							int conf = JOptionPane.showConfirmDialog(null, editor, "Edite seu Item", JOptionPane.OK_CANCEL_OPTION);
	
							if (conf == JOptionPane.OK_OPTION) {
							    String id = cId.getText();
							    String loja = cLoja.getText();
							    String cor = cCor.getText();
							    ConservacaoEnum conservacao = (ConservacaoEnum) cConser.getSelectedItem();
							    MaterialEnum material = (MaterialEnum) cMaterial.getSelectedItem();
							    
							    validarPreenchimento(id, cor, loja);
							   
								i.Editar(Itens, new Acessorio(id, loja, cor, conservacao, material));
							    
							}
							
						}else if(i instanceof Intimo){
							
							JTextField cId = new JTextField();
							JTextField cLoja = new JTextField();
							JTextField cCor = new JTextField();
							
							JComboBox<ConservacaoEnum> cConser = new JComboBox<ConservacaoEnum>(ConservacaoEnum.values());
							JComboBox<TamanhoEnum> cTamanho = new JComboBox<TamanhoEnum>(TamanhoEnum.values());
							

							cId.setText(i.getID());
							cLoja.setText(i.getLoja());
							cCor.setText(i.getCor());
							cConser.setSelectedItem(i.getConservacao());
							cTamanho.setSelectedItem(i.getTamanhoRoupa());
	
							JPanel editor = new JPanel(new GridLayout(0, 1));
							editor.add(new JLabel("Id:"));
							editor.add(cId);
							editor.add(new JLabel("Loja:"));
							editor.add(cLoja);
							editor.add(new JLabel("Cor:"));
							editor.add(cCor);
							editor.add(new JLabel("Conservação:"));
							editor.add(cConser);
							editor.add(new JLabel("Tamanho:"));
							editor.add(cTamanho);
							
							int conf = JOptionPane.showConfirmDialog(null, editor, "Edite seu Item", JOptionPane.OK_CANCEL_OPTION);
							
							if (conf == JOptionPane.OK_OPTION) {
							    String id = cId.getText();
							    String loja = cLoja.getText();
							    String cor = cCor.getText();
							    
							    validarPreenchimento(id, cor, loja);
							    ConservacaoEnum conservacao = (ConservacaoEnum) cConser.getSelectedItem();
							    TamanhoEnum tamanho = (TamanhoEnum) cTamanho.getSelectedItem();
							  
							    i.Editar(Itens, new Intimo(id, loja, cor, conservacao, tamanho));
								
							}
						}else if(i instanceof Calcado) {
							JTextField cId = new JTextField();
							JTextField cLoja = new JTextField();
							JTextField cCor = new JTextField();
							
							MaskFormatter mascara = new MaskFormatter("##");
							JFormattedTextField cTamanho = new JFormattedTextField(mascara);
							
							JComboBox<EstilosEnum> cEstilo = new JComboBox<EstilosEnum>(EstilosEnum.values());
							JComboBox<ConservacaoEnum> cConser = new JComboBox<ConservacaoEnum>(ConservacaoEnum.values());
							
							
							cId.setText(i.getID());
							cLoja.setText(i.getLoja());
							cCor.setText(i.getCor());
							cEstilo.setSelectedItem(((Calcado) i).getEstilo());
							cConser.setSelectedItem(i.getConservacao());
							cTamanho.setText(i.getTamanhoCalcado());
							
	
							JPanel editor = new JPanel(new GridLayout(0, 1));
							editor.add(new JLabel("Id:"));
							editor.add(cId);
							editor.add(new JLabel("Loja:"));
							editor.add(cLoja);
							editor.add(new JLabel("Cor:"));
							editor.add(cCor);
							editor.add(new JLabel("Estilo:"));
							editor.add(cEstilo);
							editor.add(new JLabel("Conservação:"));
							editor.add(cConser);
							editor.add(new JLabel("Tamanho:"));
							editor.add(cTamanho);
							
	
							int conf = JOptionPane.showConfirmDialog(null, editor, "Edite seu Item", JOptionPane.OK_CANCEL_OPTION);
	
							if (conf == JOptionPane.OK_OPTION) {
							    String id = cId.getText();
							    String loja = cLoja.getText();
							    String cor = cCor.getText();
							    EstilosEnum estiloe = (EstilosEnum) cEstilo.getSelectedItem();
							    String estilo = estiloe.getEstilo();
							    ConservacaoEnum conservacao = (ConservacaoEnum) cConser.getSelectedItem();
							    String tamanho = cTamanho.getText();
							    
							    validarPreenchimento(id, cor, loja, estilo, tamanho);
							    
								i.Editar(Itens, new Calcado(id, loja, cor, conservacao, tamanho, estilo));
							    
							}
						}
						else {
						
							
							JTextField cId = new JTextField();
							JTextField cLoja = new JTextField();
							JTextField cCor = new JTextField();
							JComboBox<EstilosEnum> cEstilo = new JComboBox<EstilosEnum>(EstilosEnum.values());
							JComboBox<ConservacaoEnum> cConser = new JComboBox<ConservacaoEnum>(ConservacaoEnum.values());
							JComboBox<TamanhoEnum> cTamanho = new JComboBox<TamanhoEnum>(TamanhoEnum.values());
							
							cId.setText(i.getID());
							cLoja.setText(i.getLoja());
							cCor.setText(i.getCor());
							cEstilo.setSelectedItem(((Normal) i).getEstilo());
							cConser.setSelectedItem(i.getConservacao());
							cTamanho.setSelectedItem(i.getTamanhoRoupa());
							
	
							JPanel editor = new JPanel(new GridLayout(0, 1));
							editor.add(new JLabel("Id:"));
							editor.add(cId);
							editor.add(new JLabel("Loja:"));
							editor.add(cLoja);
							editor.add(new JLabel("Cor:"));
							editor.add(cCor);
							editor.add(new JLabel("Estilo:"));
							editor.add(cEstilo);
							editor.add(new JLabel("Conservação:"));
							editor.add(cConser);
							editor.add(new JLabel("Tamanho:"));
							editor.add(cTamanho);
							
	
							int conf = JOptionPane.showConfirmDialog(null, editor, "Edite seu Item", JOptionPane.OK_CANCEL_OPTION);
	
							if (conf == JOptionPane.OK_OPTION) {
							    String id = cId.getText();
							    String loja = cLoja.getText();
							    String cor = cCor.getText();
							    EstilosEnum estiloe = (EstilosEnum) cEstilo.getSelectedItem();
							    String estilo = estiloe.getEstilo();
							    ConservacaoEnum conservacao = (ConservacaoEnum) cConser.getSelectedItem();
							    TamanhoEnum tamanho = (TamanhoEnum) cTamanho.getSelectedItem();
							    
							    validarPreenchimento(id, cor, loja, estilo);
							    
							    if(i instanceof SupInterno) {
									i.Editar(Itens, new SupInterno(id, loja, cor, conservacao, tamanho, estilo));
								}
							    else if(i instanceof SupExterno) {
							    	i.Editar(Itens, new SupExterno(id, loja, cor, conservacao, tamanho, estilo));
							    }
							    else if(i instanceof Inferior){
							    	i.Editar(Itens, new Inferior(id, loja, cor, conservacao, tamanho, estilo));
							    }
							    
							}
							
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
					}
				 }catch(Exception e1) {
					 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				 }
				
			}
		});
		 
		 
		
        
        JScrollPane PainelItens = new JScrollPane(TabelaItens);
        MostrarItens.add(PainelItens, BorderLayout.CENTER);
        
        MostrarItens.setBounds(10, 10, 1150, 300);
        
        Devolucao.setBounds(550, 315, 100, 30);
        Emprestar.setBounds(700, 315, 100, 30);
        bEditar.setBounds(900, 315, 100, 30);
        bExcluir.setBounds(1050, 315, 100, 30);
        RegistrarUso.setBounds(400, 315, 150, 30);
        RegistrarUsoL.setBounds(400, 600 , 150, 30);
        Infos.setBounds(300, 315 , 100, 30);
        InfosL.setBounds(300, 600 , 100, 30);
        
        
      //LOOKS
    	
        
        String[] colunasL = {"Id", "Qtd de Usos"};    
        
        

        DefaultTableModel modeloL = new DefaultTableModel(colunasL, 0);

        for (Look l : LooksH) {
            modeloL.addRow(new Object[] {l.getID(), l.getQtdUsos()});
        }
        
        JButton bExcluirL = new JButton("Excluir");
		JButton bEditarL = new JButton("Editar");
		JButton bOlharL = new JButton("Ver Look");
		
		bExcluirL.setBounds(1050, 600, 100, 30);
		bOlharL.setBounds(600, 600, 100, 30);
		bEditarL.setBounds(900, 600, 100, 30);

        JPanel MostrarLooks = new JPanel();
       
        MostrarLooks.setLayout(new BoxLayout(MostrarLooks, BoxLayout.Y_AXIS));

        JTable TabelaLooks = new JTable(modeloL);
        
        TabelaLooks.setRowHeight(30);

        JScrollPane PainelLooks = new JScrollPane(TabelaLooks);
        MostrarLooks.add(PainelLooks);

        MostrarLooks.setBounds(10, 370, 1150, 200);
        
        bExcluirL.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 try {
					int linhaSelecionada = -1;
					linhaSelecionada = TabelaLooks.getSelectedRow();
					if (linhaSelecionada >= 0) {
						String Id = (String)TabelaLooks.getValueAt(linhaSelecionada, 0);
						Looks.deletar(Id);
						modeloL.removeRow(linhaSelecionada);
					} else {
						JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
					}
				 }catch(Exception e1) {
					 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
        
        
        RegistrarUsoL.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaLooks.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
					String Id = (String)TabelaLooks.getValueAt(linhaSelecionada, 0);
					Look l = Looks.getLook(Id);
					
					JTextField Evento = new JTextField();
					JPanel registrarEvento = new JPanel(new GridLayout(0, 1));
					
					registrarEvento.add(new JLabel("Evento:"));
					registrarEvento.add(Evento);
					
					int conf = JOptionPane.showConfirmDialog(null, registrarEvento, "Edite seu Item", JOptionPane.OK_CANCEL_OPTION);
					
					
					if (conf == JOptionPane.OK_OPTION) {
					    String evento = Evento.getText();
					    l.registrarUso(evento);
					}
					
					}
					catch(Exception e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
					 }
				}else {
					JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				}
				
			}
		});
        
        bOlharL.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaLooks.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
						String Id = (String)TabelaLooks.getValueAt(linhaSelecionada, 0);
						Look l = Looks.getLook(Id);
						
						 JLabel labelInterno= new JLabel("SupInterno:");
						 JComboBox<Item> SupInterno= new JComboBox<Item>();
						 SupInterno.addItem(l.getSupInterno());
						 SupInterno.setEnabled(false);
						 
						 JLabel labelInferior= new JLabel("Inferior:");
						 JComboBox<Item> Inferior= new JComboBox<Item>();
						 Inferior.addItem(l.getInferior());
						 Inferior.setEnabled(false);
						 
						 JLabel labelCalcado= new JLabel("Calcado:");
						 JComboBox<Item> Calcado= new JComboBox<Item>();
						 Calcado.addItem(l.getSupInterno());
						 Calcado.setEnabled(false);
						 
						 JPanel painel = new JPanel(new GridLayout(0, 1));
						 JLabel labelAcessorio= new JLabel("Acessorios:");
						 painel.add(labelAcessorio);
						 
						 for(Acessorio i:l.getAcessorios()) {
							 painel.add(new JLabel(i.getID()));
						 }
						 
				         painel.add(labelInterno);
				         painel.add(SupInterno);
				         painel.add(labelInferior);
				         painel.add(Inferior);
				         painel.add(labelCalcado);
				         painel.add(Calcado);
						
				        JOptionPane.showConfirmDialog(null, painel, "Seu Look", JOptionPane.OK_OPTION);
						
					}catch(Exception e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
					 }
				}else {
					JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				}
				
			}
		});
        
        bEditarL.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 try {
					int linhaSelecionada = -1;
					linhaSelecionada = TabelaLooks.getSelectedRow();
					if (linhaSelecionada >= 0) {
						String Id = (String)TabelaLooks.getValueAt(linhaSelecionada, 0);
						
						Look l = Looks.getLook(Id);
						
						JLabel labelInterno= new JLabel("SupInterno:");
				        JComboBox<Item> SupInterno = new JComboBox<Item>(Itens.getSupInternos().toArray(new SupInterno[0]));
				        
				        JLabel labelExterno= new JLabel("SupExterno:");
				        JComboBox<Item> SupExterno = new JComboBox<Item>();
				        SupExterno.addItem(null);
				        for (Item item : Itens.getSupExternos()) {
				            SupExterno.addItem(item);
				        }
				        
				        JLabel labelInferior= new JLabel("Inferior:");
				        JComboBox<Item> Inferior = new JComboBox<Item>(Itens.getInferiores().toArray(new Inferior[0]));
				        
				        JLabel labelCalcado= new JLabel("Calçado:");
				        JComboBox<Item> Calcados = new JComboBox<Item>(Itens.getCalcados().toArray(new Calcado[0]));
				        
				        
				        JLabel labelAcessorio= new JLabel("Acessorio:");
				        JPanel AcessoriosCheck = new JPanel();
				        AcessoriosCheck.setLayout(new BoxLayout(AcessoriosCheck, BoxLayout.Y_AXIS));
				        List<JCheckBox> ItensAcessorio = new ArrayList<JCheckBox>();
				        
				        for(Item i : Itens.getAcessorios()) {
				        	JCheckBox c = new JCheckBox(i.getID() + "-" + i.getLoja());
				        	ItensAcessorio.add(c);
				        	AcessoriosCheck.add(c);
				        }
				        
				        JScrollPane PainelAcessorios = new JScrollPane(AcessoriosCheck);
				        PainelAcessorios.setPreferredSize(new Dimension(200, 100));
				        
				        JTextField Idc = new JTextField();
				        JLabel labelId= new JLabel("Nome do look:");
				        
				        Idc.setText(l.getID());
				        
				        
				        SupInterno.setSelectedItem(l.getSupInterno());
			            SupExterno.setSelectedItem(l.getSupExterno());
			            Inferior.setSelectedItem(l.getInferior());
			            Calcados.setSelectedItem(l.getCalcado());
				        
				        JPanel editor = new JPanel();
				        editor.setLayout(new BoxLayout(editor, BoxLayout.Y_AXIS));
				        
			            editor.add(labelId);
			            editor.add(Idc);
			            editor.add(labelInterno);
			            editor.add(SupInterno);
			            editor.add(labelExterno);
			            editor.add(SupExterno);
			            editor.add(labelInferior);
			            editor.add(Inferior);
			            editor.add(labelCalcado);
			            editor.add(Calcados);
			            editor.add(labelAcessorio);
			            editor.add(PainelAcessorios);

			            int conf = JOptionPane.showConfirmDialog(null, editor, "Edite seu Look", JOptionPane.OK_CANCEL_OPTION);

			            if (conf == JOptionPane.OK_OPTION) {
			            	String id = Idc.getText();
			                SupInterno si = (SupInterno) SupInterno.getSelectedItem();
			                SupExterno se = (SupExterno) SupExterno.getSelectedItem();
			                Inferior inf = (Inferior) Inferior.getSelectedItem();
			                Calcado cal = (Calcado) Calcados.getSelectedItem();
			                
			                validarPreenchimento(id);
			                
			                
			                l.editarId(id);
			                l.editar(si.getClass(), si);
			                l.editar(se.getClass(), se);
			                l.editar(inf.getClass(), inf);
			                l.editar(cal.getClass(), cal);
			            }
						
					} else {
						JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
					}
				 }catch(Exception e1) {
					 JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
        
        InfosL.addActionListener(new ActionListener() {
			
        	
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = TabelaLooks.getSelectedRow();
				if (linhaSelecionada >= 0) {
					try {
						String Id = (String)TabelaLooks.getValueAt(linhaSelecionada, 0);
						Look l = Looks.getLook(Id);
						JPanel painel = new JPanel(new GridLayout(0, 2));
			            painel.add(new JLabel("Qtd Usos:"));
			            painel.add(new JLabel(String.valueOf(l.getQtdUsos())));
			            painel.add(new JLabel("Ultimo Evento:"));
			            if(l.getUltimoUso() != null) {
			            	painel.add(new JLabel(String.valueOf(l.getUltimoUso().getEvento())));
			            }else {
			            	painel.add(new JLabel("Não usado"));
			            }
			            painel.add(new JLabel("Ultimo uso(Data):"));
			            
			            if(l.getUltimoUso() != null) {
			            	 painel.add(new JLabel(String.valueOf(l.getUltimoUso().getData().getTime())));
			            }else {
			            	painel.add(new JLabel("Não usado"));
			            }
			            
			            
			            
			            JOptionPane.showConfirmDialog(null, painel, "Informações", JOptionPane.OK_OPTION);
			            
			          
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
					}
			}
			}
		});
        
        add(bOlharL);
        add(Infos);
        add(RegistrarUso);
        add(RegistrarUsoL);
        add(Devolucao);
        add(Emprestar);
        add(bEditarL);
        add(bExcluirL);
        add(MostrarLooks);
        add(MostrarItens);
        add(bExcluir);
        add(bEditar);
        add(InfosL);
        
        setVisible(true);
	}
	
	public void validarPreenchimento(String Id) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("ID");
	}
	
	public void validarPreenchimento(String Id, String cor, String loja) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("ID");
    	
    	if(cor.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("Cor");
    	
    	if(loja.isBlank())
    		throw new PreenchimentoInvalidoExcption("Loja");
    	
    }
	
	public void validarPreenchimento(String Id, String cor, String loja, String Estilo) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("ID");
    	
    	if(cor.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("Cor");
    	
    	if(loja.isBlank())
    		throw new PreenchimentoInvalidoExcption("Loja");
    	
    	if(Estilo.isBlank())
    		throw new PreenchimentoInvalidoExcption("Estilo");
    	
    }
	public void validarPreenchimento(String Id, String cor, String loja, String Estilo, String tamanho) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("ID");
    	
    	if(cor.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("Cor");
    	
    	if(loja.isBlank())
    		throw new PreenchimentoInvalidoExcption("Loja");
    	
    	if(Estilo.isBlank())
    		throw new PreenchimentoInvalidoExcption("Estilo");
    	
    	if(tamanho.isBlank())
    		throw new PreenchimentoInvalidoExcption("Tamanho");
    	
    }
	public void validarData(Integer dia, Integer mes,Integer ano) throws PreenchimentoInvalidoExcption {
		if( 0 > dia )
			throw new PreenchimentoInvalidoExcption("dia");
		if( 0 > mes )
			throw new PreenchimentoInvalidoExcption("mes");
		if( 31 < dia )
			throw new PreenchimentoInvalidoExcption("dia");
		if( 12 < mes )
			throw new PreenchimentoInvalidoExcption("mes");
		if (ano <2025) {
			throw new PreenchimentoInvalidoExcption("ano");
		}
	}
	
    
}

