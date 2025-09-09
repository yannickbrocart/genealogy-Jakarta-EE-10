/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import java.io.Serializable;

/**
 * Name piece
 */
public class NamePiece implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long id;
	private String prefix;
	private String given;
	private String nickname;
	private String surnamePrefix;
	private String surname;
	private String suffix;

	public NamePiece() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSurnamePrefix() {
		return surnamePrefix;
	}

	public void setSurnamePrefix(String surnamePrefix) {
		this.surnamePrefix = surnamePrefix;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "NamePiece [id=" + id + ", prefix=" + prefix + ", given=" + given + ", nickname="
				+ nickname + ", surnamePrefix=" + surnamePrefix + ", surname=" + surname + ", suffix=" + suffix + "]";
	}
	 
}
