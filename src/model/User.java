package model;

import java.io.Serializable;
/**
 *
 * Userクラス。
 * ログインするユーザーの情報を保持します。
 */
public class User implements Serializable {
	/**
	 * ユーザーID
	 */
	private String id;
	/**
	 * ユーザー名
	 */
	private String name;
	/**
	 * パスワード
	 */
	private String pass;

	public User() {
	}

	public User(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public User(String id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	/**
	 * ユーザーIDを取得する。
	 * @return ユーザーID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ユーザーIDを設定する。
	 * @param id ユーザーID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ユーザー名を設定する。
	 * @param name ユーザー名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * パスワードを設定する。
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * ユーザー名を取得する
	 * @return　名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * パスワードを取得する
	 * @return　パスワード
	 */
	public String getPass() {
		return pass;
	}


}
