package co.micol.notice.service;

import java.util.List;
//Mybatis 사용을 위한 인터페이스
public interface NoticeMapper { 
	List<NoticeVO> noticeSelectList();	//전체 조회
	NoticeVO noticeSelect(NoticeVO vo); //한명 조회.데이터 베이스와 통신할때 vo
	int noticeInsert(NoticeVO vo); 		//입력
	int noticeUpdate(NoticeVO vo);		//수정
	int noticeDelete(NoticeVO vo);		//삭제
}
