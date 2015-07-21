package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Questao21Persistencia {

	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("select distinct e.pnome "
					+ "from empregado as e "
					+ "where e.superssn in (select e1.ssn from empregado as e1 where e1.pnome='Franklin' and e1.unome='Wong')");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getString("e.pnome"),
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
