package com.ync.biz.board;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int seq;
	private int num;
	private String reference;
	private Date date;
	private String manager;
	private String money;
	private String reception;
	private String subject;
	private String filename;
	private MultipartFile uploadFile;
	private String upload;
	private int cnt;
	private String searchKeyword;
	private String moneyif;
	private String vat;
	LocalDate now = LocalDate.now();
	private int dayofYear=now.getDayOfYear();
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getReception() {
		return reception;
	}
	public void setReception(String reception) {
		this.reception = reception;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMoneyif() {
		return moneyif;
	}
	public void setMoneyif(String moneyif) {
		this.moneyif = moneyif;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", reference=" + reference + ", date=" + date + ", manager=" + manager
				+ ", money=" + money + ", reception=" + reception + ", subject=" + subject + ", moneyif=" + moneyif
				+ "]";
	}
	
	
	

}
