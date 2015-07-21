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

import persistencia.Questao17Persistencia;

public class Questao17GUI extends JFrame {

	Questao17Persistencia q17p=new Questao17Persistencia();
	
	private JPanel contentPane;
	String[] coluna = { "Projeto", "Departamento", "Localização", "Qtd Empregados" };
	
	String[][] linhas = {};

	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna);
	private JScrollPane scroll = null;
	private JTable Tabela = null;
	private JButton btnVoltar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

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

		modeloDaColuna.getColumn(0).setPreferredWidth(125);
		modeloDaColuna.getColumn(1).setPreferredWidth(124);
		modeloDaColuna.getColumn(2).setPreferredWidth(124);
		modeloDaColuna.getColumn(3).setPreferredWidth(124);
	}

	
	/**
	 * Create the frame.
	 */
	public Questao17GUI() {
		setTitle("Quest\u00E3o 17");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getBtnVoltar());
		
		contentPane.setLayout(null);
		contentPane.add(getScrool());
		try {
			q17p.preencher_tabela(Tabela);
			contentPane.add(getLblNewLabel());
			contentPane.add(getLblNewLabel_1());
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

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Selecione o nome do projeto, o nome do departamento, sua localiza\u00E7\u00E3o e a quantidades");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel.setBounds(22, 11, 511, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("de empregados que trabalham nele.");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_1.setBounds(22, 23, 503, 14);
		}
		return lblNewLabel_1;
	}
}
