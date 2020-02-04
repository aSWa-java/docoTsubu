package model;

import dao.UserDAO;

/**
 * ユーザー登録処理を行うクラス。
 */
public class UserRegisterLogic {
	/**
	 * 処理を実行するメソッド。
	 * @param user ユーザークラスのインスタンス
	 * @return 実行結果
	 */
	public boolean execute(User user){
		UserDAO dao = new UserDAO();
		return dao.register(user);
	}
}
