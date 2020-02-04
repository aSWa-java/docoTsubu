package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

/**
 * docotsubuデータベースのuserテーブルに接続するDAOクラス
 */
public class UserDAO extends DocotsubuMySQLDAO{
	/**
	 * ユーザーIDとパスワードを基にしてデータベースを検索し、ユーザー名を設定する。
	 * @param user ログインを行うユーザークラスのインスタンス
	 */
	public void login(User user){
		String id = user.getId();
		String pass = user.getPass();
		try{
			getConnection();
			//
			String sql = "SELECT name FROM user WHERE id=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pass);
			//
			ResultSet rs = pStmt.executeQuery();

			//
			if(rs.next()) {
				String name = rs.getString("name");
				user.setName(name);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
	}

	/**
	 * ユーザー情報を追加するメソッド。model.Userクラスのインスタンスを渡すと、インスタンスのフィールドの値をデータベースに追加します。
	 * @param user テーブルに追加するユーザークラスのインスタンス
	 * @return 実行結果。追加成功時に真（true）、失敗時に偽（false）を返す。
	 */
	public boolean register(User user) {
		try{
			getConnection();

			//
			String sql = "INSERT INTO user(id, pass, name) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getName());

			//
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeConnection();
		}
		return true;
	}
}
