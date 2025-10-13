package com.keud.boardproject.dto;

import java.sql.Timestamp;

public class BoardDTO {
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
