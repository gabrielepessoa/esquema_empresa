package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Questao07Persistencia {
	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("select e.pnome, e.datanasc, dep.nome_dependente, dep.datanasc "
					+ "from empregado as e, dependente as dep "
					+ "where e.ssn=dep.essn and dep.parentesco='Conjuge' and e.datanasc<dep.datanasc");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getString("e.pnome"),
						st.getString("e.datanasc"),
						st.getString("dep.nome_dependente"),
						st.getString("dep.datanasc")
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
