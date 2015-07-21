package persistencia.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {
	Connection con;
	private Connection oConn;
	private Statement sStmt;

	public Conexao() {
	}

	public Connection abrirBDConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/empresa";
			con = DriverManager.getConnection(url, "root", "");
			System.out.println("Conexao efetuada com sucesso");
			return con;
		} catch (Exception e) {
			System.out.println("Erro ao abrir conexao com banco:");
			e.printStackTrace();
			return null;
		}
	}

	public void fecharBDConn() {
		try {
			con.close();
			System.out.println("Conexao finalizada com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com banco"
					+ e.getMessage());
		}
	}
}
