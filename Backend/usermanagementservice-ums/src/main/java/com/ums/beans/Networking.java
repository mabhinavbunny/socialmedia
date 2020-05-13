package com.ums.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="networking")
public class Networking {
	@Id
	int id;
	String user1;
	String user2;
	@Column(name = "relationshipstatus")
	int relationshipStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser1() {
		return user1;
	}
	public void setUser1(String user1) {
		this.user1 = user1;
	}
	public String getUser2() {
		return user2;
	}
	public void setUser2(String user2) {
		this.user2 = user2;
	}
	public int getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(int relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	@Override
	public String toString() {
		return "Networking [id=" + id + ", user1=" + user1 + ", user2=" + user2 + ", relationshipStatus="
				+ relationshipStatus + "]";
	}
	
}
