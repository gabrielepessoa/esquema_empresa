package gui;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import persistencia.Questao21Persistencia;
import javax.swing.JLabel;
import java.awt.Font;

public class Questao21GUI extends JFrame {

	Questao21Persistencia q21p=new Questao21Persistencia();
	
	private JPanel contentPane;
	String[] coluna = {"Nome"};
	
	String[][] linhas = {};

	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll = null;
	private JTable Tabela = null;
	private JButton btnVoltar;
	private JLabel lblEncontrarOsNomes;
	private JLabel lblfranklinWong;

	public JTable getTabela() {
		if (Tabela == null) {
			Tabela = new JTable(tabela);
			Tabela.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// int i = Tabela.getSelectedRow();
					// Object x = Tabela.getValueAt(i, 1);
					// String codigo="";
				}

			});
		}
		return Tabela;
	}

	private JScrollPane getScrool() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setBounds(22, 48, 500, 271);
			scroll.setBackground(SystemColor.text);
			scroll.setViewportView(getTabela());
			defineRenderers();
		}
		return scroll;
	}

	private void defineRenderers() {
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = Tabela.getTableHeader();
		header.setPreferredSize(new Dimension(200, 25));
		TableColumnModel modeloDaColuna = Tabela.getColumnModel();

		modeloDaColuna.getColumn(0).setPreferredWidth(497);


	}

	
	/**
	 * Create the frame.
	 */
	public Questao21GUI() {
		setTitle("Quest\u00E3o 21");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getBtnVoltar());
		
		contentPane.setLayout(null);
		contentPane.add(getScrool());
		try {
			q21p.preencher_tabela(Tabela);
			contentPane.add(getLblEncontrarOsNomes());
			contentPane.add(getLblfranklinWong());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PrincipalGUI p = new PrincipalGUI();
					p.setVisible(true);
					dispose();
				}
			});
			btnVoltar.setBounds(436, 330, 89, 23);
		}
		return btnVoltar;
	}

	private JLabel getLblEncontrarOsNomes() {
		if (lblEncontrarOsNomes == null) {
			lblEncontrarOsNomes = new JLabel("Encontrar os nomes de empregados que s\u00E3o diretamente supervisionados por ");
			lblEncontrarOsNomes.setFont(new Font("Arial", Font.BOLD, 12));
			lblEncontrarOsNomes.setBounds(22, 11, 521, 14);
		}
		return lblEncontrarOsNomes;
	}
	private JLabel getLblfranklinWong() {
		if (lblfranklinWong == null) {
			lblfranklinWong = new JLabel("\u201CFranklin Wong\u201D. ");
			lblfranklinWong.setFont(new Font("Arial", Font.BOLD, 12));
			lblfranklinWong.setBounds(21, 23, 124, 14);
		}
		return lblfranklinWong;
	}
}
