package com.keud.boardproject.dto;

import java.sql.Timestamp;

public class BoardDTO {

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



