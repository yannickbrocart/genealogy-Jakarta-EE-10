/**
 * 
 */
package com.yannickbrocart.genealogy.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.yannickbrocart.genealogy.bean.enums.GenealogyStatusType;

/**
 * Genealogy
 */
public class Genealogy implements Serializable, Comparable<Object> {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private LocalDateTime creationTime;
	private LocalDateTime lastAccessTime;
	private LocalDateTime lastModifiedTime;
	private User createdBy;
	private User lastModifiedBy;
	private GenealogyStatusType status;
	private List<Individual> individuals;
	private List<Family> families;
	
	public Genealogy() {}
		
	public Genealogy(String name, User createdBy) {
		this.name = name;
		this.creationTime = LocalDateTime.now();
		this.createdBy = createdBy;
		this.status = GenealogyStatusType.CREATED;
	}
	
	public Genealogy(long id, String name, LocalDateTime creationTime, 
			LocalDateTime lastAccessTime, LocalDateTime lastModifiedTime, User createdBy,
					 User lastModifiedBy, GenealogyStatusType status,
					 List<Individual> individuals, List<Family> families) {
		this.id = id;
		this.name = name;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.lastModifiedTime = lastModifiedTime;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.status = status;
		this.individuals = individuals;
		this.families = families;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(LocalDateTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public LocalDateTime getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public GenealogyStatusType getStatus() {
		return status;
	}

	public void setStatus(GenealogyStatusType status) {
		this.status = status;
	}

	public List<Individual> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(List<Individual> individuals) {	
		this.individuals = individuals;
	}
	
	public void addIndividual(Individual individual) {
		if(individuals == null) {
			individuals = new ArrayList<Individual>();
		}
		individuals.add(individual);	
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public void addFamily(Family family) {
		if(families == null) {
			families = new ArrayList<Family>();
		}
		families.add(family);	
	}
	
	@Override
	public String toString() {
		return "Genealogy [id=" + id + ", name=" + name + ", creationTime=" + creationTime
				+ ", lastAccessTime=" + lastAccessTime + ", lastModifiedTime=" + lastModifiedTime + ", createdBy="
				+ createdBy + ", lastModifiedBy=" + lastModifiedBy + ", status=" + status + ", individuals="
				+ individuals + ", families=" + families + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		Genealogy genealogy = (Genealogy) arg0;
		return (int) (this.id - genealogy.id);
	}
	
}
