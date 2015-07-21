package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PrincipalGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuestao3 = new JButton("Quest\u00E3o 3");
		btnQuestao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Questao03GUI q3 = new Questao03GUI();
				q3.setVisible(true);
				dispose();
			}
		});
		btnQuestao3.setBounds(65, 56, 145, 23);
		contentPane.add(btnQuestao3);
		
		JButton btnQuesta07 = new JButton("Quest\u00E3o 7");
		btnQuesta07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Questao07GUI q7g = new Questao07GUI();
				q7g.setVisible(true);
				dispose();
			}
		});
		btnQuesta07.setBounds(65, 90, 145, 23);
		contentPane.add(btnQuesta07);
		
		JButton btnQuestao10 = new JButton("Quest\u00E3o 10");
		btnQuestao10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Questao10GUI q10gui = new Questao10GUI();
				q10gui.setVisible(true);
				dispose();
			}
		});
		btnQuestao10.setBounds(65, 124, 145, 23);
		contentPane.add(btnQuestao10);
		
		JButton btnQuestao17 = new JButton("Quest\u00E3o 17");
		btnQuestao17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao17GUI q17g = new Questao17GUI();
				q17g.setVisible(true);
				dispose();
				
			}
		});
		btnQuestao17.setBounds(65, 158, 145, 23);
		contentPane.add(btnQuestao17);
		
		JButton btnQuestao19 = new JButton("Quest\u00E3o 19");
		btnQuestao19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao19GUI q19g = new Questao19GUI();
				q19g.setVisible(true);
				dispose();
			}
		});
		btnQuestao19.setBounds(65, 192, 145, 23);
		contentPane.add(btnQuestao19);
		
		JButton btnQuesto = new JButton("Quest\u00E3o 21");
		btnQuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao21GUI q21g = new Questao21GUI();
				q21g.setVisible(true);
				dispose();
			}
		});
		btnQuesto.setBounds(65, 226, 145, 23);
		contentPane.add(btnQuesto);
		
		JButton btnQuesto_1 = new JButton("Quest\u00E3o 24");
		btnQuesto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao24GUI q24g = new Questao24GUI();
				q24g.setVisible(true);
				dispose();
			}
		});
		btnQuesto_1.setBounds(65, 260, 145, 23);
		contentPane.add(btnQuesto_1);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, 
						"Parte 1 do projeto desenvolvido por Lisandra Cruz, Gabriele Pessoa \n"
						+ "e Raissa Brizeno para a cadeira de Fundamentos de Banco de Dados. \n"
						+ "Ministrada pela professora Roberta Macêdo. UFRPE. \n \n"
						+ "Obrigada! :)",
						"Sobre",
						1);
			}
		});
		btnSobre.setBounds(168, 313, 89, 23);
		contentPane.add(btnSobre);
	}
}
