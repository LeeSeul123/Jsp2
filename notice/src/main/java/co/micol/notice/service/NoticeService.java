package co.micol.notice.service;

import java.util.List;

import co.micol.notice.service.NoticeVo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();	//전체 조회
	NoticeVO noticeSelect(NoticeVO vo); //한명 조회.데이터 베이스와 통신할때 vo
	int noticeInsert(NoticeVO vo); 		//입력
	int noticeUpdate(NoticeVO vo);		//수정
	int noticeDelete(NoticeVO vo);		//삭제
}
