package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexao.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Questao19Persistencia {
	
	public void preencher_tabela(JTable Tabela) throws SQLException{
		Conexao bd = new Conexao();
		Connection conn = (Connection) bd.abrirBDConn();
		try{
			
			DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
			modelo.setNumRows(0);
			
			Statement statement = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet st = statement.executeQuery("select e.pnome, e.ssn, d.gerdatainicio "
					+ "from empregado as e, departamento as d "
					+ "where e.ssn=d.gerssn and d.gerdatainicio>='1985-__-__' "
					+ "group by e.pnome");
			while(st.next()){
				
				modelo.addRow(new Object[]{
						st.getString("e.pnome"),
						st.getString("e.ssn"),
						st.getString("d.gerdatainicio"),
				});
			}
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Erro ao adicionar na tabela" + erro, "Erro no sistema", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
