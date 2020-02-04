package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * docotsubuデータベースへの接続を行うDAOクラス。
 */
public class DocotsubuMySQLDAO {
	/**
	 * JDBCドライバ
	 */
	protected final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	/**
	 * データベースのURL
	 */
	protected final String JDBC_URL = "jdbc:mysql://172.16.11.254:3306/docotsubu?autoReconnect=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
	/**
	 * データーベースに接続するユーザー名
	 */
	protected final String DB_USER = "docoTsubu";
	/**
	 * データベース接続パスワード
	 */
	protected final String DB_PASS = "docoTsubu";
	/**
	 * データベース接続を保持するフィールド。
	 */
	protected Connection conn;

	/**
	 * データベース接続を行うメソッド。
	 * @throws ClassNotFoundException JDBCドライバが見つからなかった場合発生します。
	 * @throws SQLException データベースエラーの場合発生します。
	 */
	protected void getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}

	/**
	 * データベース接続を切断するメソッド。
	 */
	protected void closeConnection(){
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
