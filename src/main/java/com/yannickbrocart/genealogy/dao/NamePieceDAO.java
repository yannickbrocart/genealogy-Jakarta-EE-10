/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.component.NamePiece;

/**
 * 
 */
public interface NamePieceDAO {
	
	/**
	 * @return boolean
	 */
    public boolean createNamePiece(NamePiece namePiece);
	
    /**
	 * @return Optional<NamePiece>
	 */
    public Optional<NamePiece> findNamePieceById(long id);
	
	/**
	 * @return List<NamePiece>
	 */
	public List<NamePiece> findNamePiecesBy(String attribute);
	
	/**
	 * @return List<NamePiece>
	 */
	public List<NamePiece> findAllNamePieces();
	
	/**
	 * @return boolean
	 */
	public boolean updateNamePiece(long id, NamePiece namePiece);
	
	/**
	 * @return boolean
	 */
	public boolean deleteNamePiece(long id);
	
}