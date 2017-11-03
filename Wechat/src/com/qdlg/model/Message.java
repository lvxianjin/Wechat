package com.qdlg.model;


/**
 * message表的模型
 * @author 10184
 *2017年10月29日
 */
public class Message {
	private String id;           //ID字段
	private String command;      //COMMAND字段
	private String description;  //DESCRIPTION字段
	private String content;      //CONTENT字段
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
