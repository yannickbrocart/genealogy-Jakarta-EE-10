/**
 * 
 */
package com.yannickbrocart.genealogy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yannickbrocart.genealogy.bean.component.IndividualEvents;
import com.yannickbrocart.genealogy.bean.component.Name;
import com.yannickbrocart.genealogy.bean.enums.KnownSexTypes;

/**
 * Individual
 */
public class Individual implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private KnownSexTypes sex;
    private List<Name> names;
    private IndividualEvents individualEvents;
    private long ChildToFamily;
    private long spouseToFamily;
    private boolean isPrivate = true;
	
    public Individual() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public KnownSexTypes getSex() {
		return sex;
	}

	public void setSex(KnownSexTypes sex) {
		this.sex = sex;
	}

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
	
	public void addName(Name name) {
		if(names == null) {
			names = new ArrayList<Name>();
		}
		names.add(name);
	}

	public IndividualEvents getIndividualEvents() {
		return individualEvents;
	}

	public void setIndividualEvents(IndividualEvents individualEvents) {
		this.individualEvents = individualEvents;
	}
	
	public Long getChildToFamily() {
		return ChildToFamily;
	}

	public void setChildToFamily(Long childToFamily) {
		ChildToFamily = childToFamily;
	}

	public long getSpouseToFamily() {
		return spouseToFamily;
	}

	public void setSpouseToFamily(long spouseToFamily) {
		this.spouseToFamily = spouseToFamily;
	}

	public boolean getPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	@Override
	public String toString() {
		return "Individual [id=" + id + ", sex=" + sex + ", names=" + names + ", individualEvents=" + individualEvents
				+ ", ChildToFamily=" + ChildToFamily + ", spouseToFamily=" + spouseToFamily + ", isPrivate=" + isPrivate
				+ "]";
	}

}
