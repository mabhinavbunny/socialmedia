package com.ums.beans;

public class ChangeUserRelationShipStatusRequest {
	private User requestingUser;
	private User requestedUser;
	private int status;
	public User getRequestingUser() {
		return requestingUser;
	}
	public void setRequestingUser(User requestingUser) {
		this.requestingUser = requestingUser;
	}
	public User getRequestedUser() {
		return requestedUser;
	}
	public void setRequestedUser(User requestedUser) {
		this.requestedUser = requestedUser;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ChangeUserRelationShipStatusRequest [requestingUser=" + requestingUser + ", requestedUser="
				+ requestedUser + ", status=" + status + "]";
	}
	
}
