package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Questao17Persistencia {
	
	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("select p.pjnome, p.plocalizacao, d.dnome, count(te.essn) "
					+ "from empregado as e, trabalha_em as te, projeto as p, departamento as d "
					+ "where e.ssn=te.essn and te.pno=p.pnumero and d.dnumero=p.dnum group by te.pno");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getString("p.pjnome"),
						st.getString("p.plocalizacao"),
						st.getString("d.dnome"),
						st.getInt("count(te.essn)")
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
