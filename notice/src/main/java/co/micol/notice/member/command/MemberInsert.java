package co.micol.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.member.service.MemberService;
import co.micol.notice.member.service.MemberVO;
import co.micol.notice.member.service.Impl.MemberServiceImpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입을 수행한다
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		//리퀘스트 객체가 폼의 값을 가지고 있음(get이든 post든)
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPW"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberGender(request.getParameter("memberGender"));
		vo.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		int n = ms.memberInsert(vo);
		if(n != 0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었습니다.");
		} else {
			request.setAttribute("message", "회원가입이 실패했습니다. 다시 가입하라");
		}
		return "member/memberMessage";
	}

}
