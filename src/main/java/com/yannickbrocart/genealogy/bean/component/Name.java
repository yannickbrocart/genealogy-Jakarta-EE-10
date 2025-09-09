/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.yannickbrocart.genealogy.bean.enums.KnownNameTypes;

/**
 * Name
 */
public class Name implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private KnownNameTypes type;
	private List<NamePiece> namePieces;
	private LocalDate date;

	public Name() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public KnownNameTypes getType() {
		return type;
	}

	public void setType(KnownNameTypes type) {
		this.type = type;
	}

	public List<NamePiece> getNamePieces() {
		return namePieces;
	}

	public void setNamePieces(List<NamePiece> namePieces) {
		this.namePieces = namePieces;
	}
	
	public void addIndividual(NamePiece namePiece) {
		if(namePieces == null) {
			namePieces = new ArrayList<NamePiece>();
		}
		namePieces.add(namePiece);	
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Name [id=" + id + ", type=" + type + ", namePieces=" + namePieces + ", date=" + date + "]";
	}
	
}
