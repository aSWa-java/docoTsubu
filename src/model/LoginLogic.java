package model;

import dao.UserDAO;

/**
 * ログイン処理を実行するクラス。
 */
public class LoginLogic {
	/**
	 * 引数で渡されたユーザーがログインできるか判定するメソッド。ユーザー名が設定されていれば真（true）、設定されていなければ偽（false）を返す。
	 * @param user Userインスタンス
	 * @return ログイン結果。真（true）ならログイン成功、偽（false）ならログイン失敗。
	 */
	public boolean execute(User user){
		UserDAO dao = new UserDAO();
		dao.login(user);

		if(user.getName() != null){
			return true;
		}
		return false;
	}
}
