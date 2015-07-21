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

import persistencia.Questao19Persistencia;
import javax.swing.JLabel;
import java.awt.Font;

public class Questao19GUI extends JFrame {

	Questao19Persistencia q19p=new Questao19Persistencia();
	
	private JPanel contentPane;
	String[] coluna = { "Nome", "CPF", "Data de Inicio"};
	
	String[][] linhas = {};

	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll = null;
	private JTable Tabela = null;
	private JButton btnVoltar;
	private JLabel lblSelecioneOSsn;
	private JLabel lblNewLabel;

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

		modeloDaColuna.getColumn(0).setPreferredWidth(198);
		modeloDaColuna.getColumn(1).setPreferredWidth(199);
		modeloDaColuna.getColumn(2).setPreferredWidth(100);

	}

	
	/**
	 * Create the frame.
	 */
	public Questao19GUI() {
		setTitle("Quest\u00E3o 19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getBtnVoltar());
		
		contentPane.setLayout(null);
		contentPane.add(getScrool());
		try {
			q19p.preencher_tabela(Tabela);
			contentPane.add(getLblSelecioneOSsn());
			contentPane.add(getLblNewLabel());
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

	private JLabel getLblSelecioneOSsn() {
		if (lblSelecioneOSsn == null) {
			lblSelecioneOSsn = new JLabel("Selecione o ssn (CPF) e nome dos empregados que gerenciam um departamento,");
			lblSelecioneOSsn.setFont(new Font("Arial", Font.BOLD, 12));
			lblSelecioneOSsn.setBounds(22, 11, 491, 14);
		}
		return lblSelecioneOSsn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("cuja ger\u00EAncia se deu a partir de 1985.");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel.setBounds(22, 23, 491, 14);
		}
		return lblNewLabel;
	}
}
