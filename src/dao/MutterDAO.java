package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

/**
 * docotubuデータベースのmutterテーブルに接続するDAOクラス。
 */
public class MutterDAO extends DocotsubuMySQLDAO{
	/**
	 * つぶやき全件を取得するメソッド。
	 * @return　つぶやき全件のリスト
	 */
	public List<Mutter> findAll() {

		List<Mutter> mutterList = new ArrayList<Mutter>();
		try{
			getConnection();

			//
			String sql = "SELECT m.id, u.name, m.text, m.date "
					+ "FROM user AS u, mutter AS m "
					+ "WHERE u.id = m.userid "
					+ "ORDER BY id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//
			ResultSet rs = pStmt.executeQuery();

			//
			while (rs.next()) {
				int id = rs.getInt("m.id");
				String userName = rs.getString("u.name");
				String text = rs.getString("m.text");
				String date = rs.getString("m.date");
				Mutter mutter = new Mutter(id, userName, text, date);
				mutterList.add(mutter);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
		finally{
			closeConnection();
		}

		return mutterList;
	}

	/**
	 * つぶやきを投稿するメソッド。
	 * @param mutter つぶやきのインスタンス
	 * @return 投稿結果
	 */
	public boolean create(Mutter mutter) {
		try{
			//
			getConnection();

			//
			String sql = "INSERT INTO mutter(userid, text, date) VALUES(?, ?, now())";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//
			pStmt.setString(1, mutter.getUserId());
			pStmt.setString(2, mutter.getText());

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
