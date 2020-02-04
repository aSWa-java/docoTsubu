package model;

import java.io.Serializable;

/**
 * つぶやきクラス。
 * つぶやき1件の情報を保持します。
 *
 */
public class Mutter implements Serializable {
	/**
	 * つぶやきID
	 */
	private int id;
	/**
	 * つぶやきを投稿したユーザーID
	 */
	private String userId;
	/**
	 * つぶやきを投稿したユーザー名
	 */
	private String userName;
	/**
	 * つぶやき内容
	 */
	private String text;
	/**
	 * つぶやき日時
	 */
	private String date;

	/**
	 *  内容が空のインスタンスを生成
	 */
	public Mutter() {
	}

	/**
	 * ユーザーIDとつぶやき内容を指定してインスタンスを生成
	 *
	 * @param userId つぶやいたユーザーのID
	 * @param text つぶやき内容
	 */
	public Mutter(String userId, String text) {
		this.userId = userId;
		this.text = text;
	}

	/**
	 * ユーザーID、ユーザー名およびつぶやき内容を指定してインスタンスを生成
	 *
	 * @param id つぶやいたユーザーのID
	 * @param userName つぶやいたユーザーの名前
	 * @param text つぶやき内容
	 */
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	/**
	 * ユーザーID、ユーザー名、つぶやき内容およびつぶやき日時を指定してインスタンスを生成
	 *
	 * @param id つぶやいたユーザーのID
	 * @param userName つぶやいたユーザーの名前
	 * @param text つぶやき内容
	 * @param date つぶやき日時
	 */
	public Mutter(int id, String userName, String text, String date) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.date = date;
	}

	/**
	 * つぶやきのIDを取得
	 * @return つぶやきID
	 */
	public int getId(){
		return id;
	}

	/**
	 *  つぶやきを投稿したユーザーIDを取得
	 * @return ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * つぶやきを投稿したユーザー名を取得
	 * @return ユーザー名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * つぶやき内容を取得
	 * @return つぶやき内容
	 */
	public String getText() {
		return text;
	}

	/**
	 * つぶやき日時を取得
	 * @return つぶやき日時
	 */
	public String getDate() {
		return date;
	}

	/**
	 * つぶやき日時を設定
	 * @param date つぶやき日時
	 */
	public void setDate(String date) {
		this.date = date;
	}


}
