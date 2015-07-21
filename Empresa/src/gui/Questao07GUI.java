package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import persistencia.Questao07Persistencia;
import javax.swing.JTextField;

public class Questao07GUI extends JFrame {

	Questao07Persistencia q7p = new Questao07Persistencia();
	
	private JPanel contentPane;
	String[] coluna = { "Empregado", "Data de Nascimeto", "Cônjugue", "Data de Nascimento" };
	String[][] linhas = {};

	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll = null;
	private JTable Tabela = null;
	private JButton btnVoltar;
	private JLabel lblNascimentoDoDependente;
	private JLabel lblForMenorQue;

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
			scroll.setBounds(22, 58, 500, 261);
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

		modeloDaColuna.getColumn(0).setPreferredWidth(124);
		modeloDaColuna.getColumn(1).setPreferredWidth(124); 
		modeloDaColuna.getColumn(2).setPreferredWidth(125);
		modeloDaColuna.getColumn(3).setPreferredWidth(124);
		
	}

	
	/**
	 * Create the frame.
	 */
	public Questao07GUI() {
		setTitle("Quest\u00E3o 07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getBtnVoltar());
		
		JLabel lblSelecioneONome = new JLabel("Selecione o nome e a data de nascimento dos empregados e o nome e a data de\r\n ");
		lblSelecioneONome.setFont(new Font("Arial", Font.BOLD, 12));
		lblSelecioneONome.setBounds(22, 8, 500, 14);
		contentPane.add(lblSelecioneONome);
		
		contentPane.setLayout(null);
		contentPane.add(getScrool());
		try {
			q7p.preencher_tabela(Tabela);
			contentPane.add(getLblNascimentoDoDependente());
			contentPane.add(getLblForMenorQue());
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
	private JLabel getLblNascimentoDoDependente() {
		if (lblNascimentoDoDependente == null) {
			lblNascimentoDoDependente = new JLabel("nascimento do dependente c\u00F4njuge, em que a data de nascimento do empregado \r\n");
			lblNascimentoDoDependente.setFont(new Font("Arial", Font.BOLD, 12));
			lblNascimentoDoDependente.setBounds(22, 20, 500, 14);
		}
		return lblNascimentoDoDependente;
	}
	private JLabel getLblForMenorQue() {
		if (lblForMenorQue == null) {
			lblForMenorQue = new JLabel("for menor que a data de nascimento do seu c\u00F4njuge");
			lblForMenorQue.setFont(new Font("Arial", Font.BOLD, 12));
			lblForMenorQue.setBounds(22, 33, 503, 14);
		}
		return lblForMenorQue;
	}
}
