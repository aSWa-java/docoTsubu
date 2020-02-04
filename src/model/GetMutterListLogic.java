package model;

import java.util.List;

import dao.MutterDAO;

/**
 * つぶやきリスト取得クラス
 */
public class GetMutterListLogic {
	/**
	 * つぶやきリストを取得する処理を行うメソッド。
	 * @return つぶやきリスト
	 */
	public List<Mutter> execute(){
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}
}
