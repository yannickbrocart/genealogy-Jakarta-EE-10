/**
 * 
 */
package com.yannickbrocart.genealogy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Family
 */
public class Family implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Individual person1;
	private Individual person2;
	private List<Individual> childs;
	 
	public Family() {}
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Individual getPerson1() {
		return person1;
	}

	public void setPerson1(Individual person1) {
		this.person1 = person1;
	}

	public Individual getPerson2() {
		return person2;
	}

	public void setPerson2(Individual person2) {
		this.person2 = person2;
	}

	public List<Individual> getChilds() {
		return childs;
	}
	
	public void setChilds(List<Individual> childs) {
		this.childs = childs;
	}
	
	public void addIndividual(Individual individual) {
		if(childs == null) {
			childs = new ArrayList<Individual>();
		}
		childs.add(individual);	
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", person1=" + person1 + ", person2=" + person2 + ", childs=" + childs + "]";
	}

}
