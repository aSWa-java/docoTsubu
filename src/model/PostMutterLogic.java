package model;

import dao.MutterDAO;

/**
 * つぶやき投稿クラス。
 */
public class PostMutterLogic {
	/**
	 * つぶやき投稿を実行するメソッド。
	 * @param mutter つぶやきクラスのインスタンス
	 */
	public void execute(Mutter mutter){
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}
