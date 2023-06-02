package co.micol.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class NoticeVo {
	@Getter
	@Setter
	public class NoticeVO{
		private int noticeId;
		private String noticeWriter;
		private String noticeTitle;
		private String noticeSubject;
		private Date noticeWdate;
	}
}
