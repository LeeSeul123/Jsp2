package co.micol.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.service.Impl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 목록 가져오기
		NoticeService ns = new NoticeServiceImpl(); //DAO. 즉 모델을 호출
		List<NoticeVO> notices = new ArrayList<>(); //모델 호출한 결과를 담을 것
		notices = ns.noticeSelectList();
		//위는 자바와 같음
		
		//JSP페이지에 던짐
		//1.request객체에 담는다
		//array형태의 notices를 notices변수명으로 담음
		request.setAttribute("notices", notices); //JSP에 보내기 위해 결과 객체를 담는다. "notices"변수로 넘어온 결과값을 쭉 담아달라. "변수명", 값 형태. 이걸 JSP페이지로 던짐. 담을 객체가 딱히 없어서 request객체에 담음
		return "notice/noticeList"; //결과담에서 여기서 보여줌. return에 담는 건 views폴더
		//jsp페이지에서는 request객체에서 notices변수를 끄집어내서 읽으면됨
	}

}
