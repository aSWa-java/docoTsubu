package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * メイン画面を表示するリクエストを受け付けるサーブレットクラス
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Getリクエストで呼び出され、画面表示に関する処理を行うメソッド。
	 * 結果画面は/WEB-INF/jsp/main.jspにフォワードします。
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterLogic.execute();
		request.setAttribute("mutterList", mutterList);


		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null){
			// ログインしていない場合、リダイレクト
			response.sendRedirect("/docoTsubu/");
		} else {
			// 表示ページの設定
			String pageStr = request.getParameter("page");
			Integer page;
			if(pageStr == null || pageStr.equals("")){
				page = 1;
			}else{
				page = Integer.parseInt(pageStr);
			}
			request.setAttribute("page", page);

			// ログイン済みの場合、フォワード
			RequestDispatcher dispatcer = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}

	/**
	 * Postリクエストで呼び出され、つぶやき投稿を制御するメソッド。
	 * 結果画面は/WEB-INF/jsp/main.jspにフォワードします。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//　入力チェック
		if(text != null && text.length() != 0){

			// セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getId(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

			//
			Integer page = 1;
			request.setAttribute("page", page);

		}else{
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		//
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		// メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
}
