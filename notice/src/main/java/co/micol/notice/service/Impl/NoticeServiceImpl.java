package co.micol.notice.service.Impl;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.notice.common.DataSource;
import co.micol.notice.service.NoticeMapper;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	//이 두줄이 데이터베이스를 연결. mapper연결 후 map한테 시킴
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //db연결. sql담음? auto커밋하라고 true
	NoticeMapper map = sqlSession.getMapper(NoticeMapper.class); //mapper연결
	
	
	//전통적 방법. 이게 모델임

//	private DataSource dao = DataSource.getInstance();
//	private Connection conn;
//	private PreparedStatement psmt;
//	private ResultSet rs; //결과를 돌려받음
//	
	@Override
	public List<NoticeVO> noticeSelectList() {
//		String sql = "SELECT * FROM notice";
//		List<NoticeVO> notices = new ArrayList<>();
//		NoticeVO vo;
//		try {
//			conn = dao.getConnection();
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				vo = new NoticeVO();
//				vo.setNoticeId(rs.getInt("notice_id"));
//				vo.setNoticeWriter(rs.getString("notice_writer"));
//				vo.setNoticeTitle(rs.getString("notice_title"));
//				vo.setNoticeWdate(rs.getDate("notice_wdate"));
//				vo.setNoticeHit(rs.getInt("notice_hit"));
//				notices.add(vo);
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return notices;
		return map.noticeSelectList(); //map.메소드이름. 야를 호출하면 NoticeMapper 구현클래스의 메소드가 호출됨
	}

//	private void close() {
//		try { //전통적인 방법을 쓸 때 반드시 close
//			if(rs != null) { //rs가 열려있다면
//				rs.close();
//			}
//			if(psmt != null) {
//				psmt.close();
//			}
//			if(conn != null) {
//				conn.close();
//			}
//		} catch(SQLException e) {
//			
//		}
//	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

}
