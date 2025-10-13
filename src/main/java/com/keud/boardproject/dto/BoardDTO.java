package com.keud.boardproject.dto;

import java.sql.Timestamp;

public class BoardDTO {
<<<<<<< HEAD
	private String writer; // 사용자 이름
	private String title;
	private String contents;
	private Timestamp writerDate;
	private int viewCount;
	
	public BoardDTO() {}
	
	public BoardDTO(String writer, String title, String contents, Timestamp writerDate, int viewCount) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.writerDate = writerDate;
		this.viewCount = viewCount;
=======

	private int seq;
	private String writer;
	private String title;
	private String content;
	private Timestamp writedate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
>>>>>>> 56883e14a5733fdb353b11adcd1c39ec11dadf84
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
<<<<<<< HEAD
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWriterDate() {
		return writerDate;
	}
	public void setWriterDate(Timestamp writerDate) {
		this.writerDate = writerDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	

}
=======
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public BoardDTO(int seq, String writer, String title, String content, Timestamp writedate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
	}
	public BoardDTO() {
	}
	
	
	
}



>>>>>>> 56883e14a5733fdb353b11adcd1c39ec11dadf84
