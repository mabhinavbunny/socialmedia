package com.ums.beans;

public class ResponseObj<T> {
	private String status;
	private String message;
	private T response;
	
	public ResponseObj(String status, String message, T response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ResponseObj [status=" + status + ", message=" + message + ", response=" + response + "]";
	}
	
}
