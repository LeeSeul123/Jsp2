package co.micol.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.service.Impl.NoticeServiceImpl;

public class NoticeEdit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 수정(DB에 가서 일단 내가 수정할 글을 가져와야 함)
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();//결과를 담아서 보냄
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));//넘어온 key값
		vo = ns.noticeSelect(vo); //key에 해당하는 value받아옴
		request.setAttribute("notice", vo);
		
		return "notice/noticeEdit";
	}

}
