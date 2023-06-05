package co.micol.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.common.Command;
import co.micol.notice.member.service.MemberService;
import co.micol.notice.member.service.MemberVO;
import co.micol.notice.member.service.Impl.MemberServiceImpl;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//아이디 중복체크(Ajax리턴)
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		MemberVO vo2 = ms.memberSelect(vo); //id값만 들어간 vo
		
		//Ajax를 사용했다는 것을 알기위해서
		String str = "Ajax:";
		if(vo2 != null) {
			//결과가 없으면 빈 vo를 돌려줌.실어서 보냈지만 빈 vo가 들어옴. 만약에 결과가 있으면 꽉찬 vo가 돌아옴
			str += "No";
		} else {
			str += "Yes";
		}
		return str;
	}

}
