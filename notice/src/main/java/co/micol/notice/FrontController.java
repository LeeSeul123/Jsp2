package co.micol.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.command.NoticeDelete;
import co.micol.notice.command.NoticeEdit;
import co.micol.notice.command.NoticeInsert;
import co.micol.notice.command.NoticeInsertForm;
import co.micol.notice.command.NoticeList;
import co.micol.notice.command.NoticeSelect;
import co.micol.notice.command.NoticeUpdate;
import co.micol.notice.common.Command;
import co.micol.notice.main.command.MainCommand;
import co.micol.notice.member.command.AjaxCheckId;
import co.micol.notice.member.command.MemberInsert;
import co.micol.notice.member.command.MemberJoin;
import co.micol.notice.member.command.MemberList;
import co.micol.notice.member.command.MemberLogin;
import co.micol.notice.member.command.MemberLoginForm;
import co.micol.notice.member.command.MemberLogout;
import co.micol.notice.product.command.ProductInsert;
import co.micol.notice.product.command.ProductList;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//처음 시작될 때 동작하는 메소드(한번만 수행. 그다음부터는 service()만 수행), 요청한 것을 담아두는 곳
		map.put("/main.do", new MainCommand()); //처음 들어오는 페이지를 돌려준다. 구현체로 실어놓음
		//여기에 추가하면 기능이 추가됨. 인터페이스도 만들어줘야함
		map.put("/noticeList.do", new NoticeList()); //게시글 목록보기
		map.put("/noticeSelect.do", new NoticeSelect()); //게시글 상세보기
		map.put("/noticeInsertForm.do", new NoticeInsertForm()); //게시글 작성 폼 호출
		map.put("/noticeInsert.do", new NoticeInsert());	//게시글 등록
		map.put("/noticeEdit.do", new NoticeEdit()); 	//게시글 수정할 수 있는 폼을 호출
		map.put("/noticeUpdate.do", new NoticeUpdate()); //게시글을 DB에 수정작업
		map.put("/noticeDelete.do", new NoticeDelete()); //게시글 삭제
		map.put("/memberList.do", new MemberList()); //멤버 목록보기
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 화면 호출
		map.put("/memberInsert.do", new MemberInsert()); //회원가입 수행
		map.put("/ajaxCheckId.do", new AjaxCheckId()); //아이디 중복체크. 호출,커맨드에 ajax 이름 붙이면 직관적으로 ajax쓴 걸 알 수 있음
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/memberLogout.do", new MemberLogout());
		map.put("/productList.do", new ProductList());	//제품 목록 보기
		map.put("/productInsertForm.do", new ProductInsertForm());//제품등록 폼 호출
		map.put("/productInsert.do", new ProductInsert());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스 하는 부분 (서버가 만들어주니까 request, response 자동으로 들어감)
		//요청을 분석하고, 수행할 Command를 찾아서 수행하고, 결과를 돌려준다.
		
		//한글깨짐방지
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI(); //요청한거의 uri를 찾아야함. 도메인을 뺀 나머지 전부. uri는 리퀘스트 객체가 가지고 있음. 호출한 uri구하는 거
		String contextPath = request.getContextPath(); //contextPath구하기 (실제로는 root를 구하는 것). uri의 제일 첫부분. uri-contextPath = 실제 요청한 거
		//uri = /notice/main.do
		//contextPath = /notice
		String page = uri.substring(contextPath.length());//요청한 페이지 구하기 = /main.do
		
		Command command = map.get(page);//수행할 command를 가져온다. 그래서 인터페이스를 씀. 동일한 이름으로 원하는 구현체 가져와서 수행가능. 인터페이스는 자기 자신을 인스턴스 생성못하고 구현체를 통해 초기화 함. new MainCommand()가 들어오게 됨.
		String viewPage = command.exec(request, response);//보여줄 page. 이제 사람들한테 보여줘야하므로 view reserve로 html.
		//viewPage에 main/main이 들어옴
		
		
		if(!viewPage.endsWith(".do")) { //돌아왔는데 결과가 .do가 아니면
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5)); //결과가 No또는 Yes
				return; //여기까지하고 빠져나가라고
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //RequestDispatcher는 인터페이스라서 자식을 이용. 이 정보를 가지고 넘김
			dispatcher.forward(request, response); //디스패쳐를 이용해서 forward하면 request객체, response객체 가져가면 바로 들어갈 수 있음.(그냥 sendRed하면은 작성해서 들어가게 함)
		} else {
			response.sendRedirect(viewPage); //돌아온 결과가 *.do이면 위임해버린다. forward = sendRedirect 값을 안 싣고 다른 데로 넘겨버린다
		}//결과 response, 실행 request 결과를 넘겨버림
		
		//.do가 아니면 여기까지 오게됨
		
		
	}

}
