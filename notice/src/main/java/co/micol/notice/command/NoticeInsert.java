package co.micol.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.service.Impl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		int n = ns.noticeInsert(vo);
		
		return "noticeList.do";
	}

}
