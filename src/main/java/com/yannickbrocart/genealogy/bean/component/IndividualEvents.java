/**
 * 
 */
package com.yannickbrocart.genealogy.bean.component;

import java.io.Serializable;

/**
 * Event
 */
public class IndividualEvents implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private IndividualEventDetail birthDetail = null;
	private IndividualEventDetail deathDetail = null;
	private boolean death = false;

	public IndividualEvents() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public IndividualEventDetail getBirthDetail() {
		return birthDetail;
	}

	public void setBirthDetail(IndividualEventDetail birthDetail) {
		this.birthDetail = birthDetail;
	}

	public IndividualEventDetail getDeathDetail() {
		return deathDetail;
	}

	public void setDeathDetail(IndividualEventDetail deathDetail) {
		this.deathDetail = deathDetail;
	}

	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", birthDetail=" + birthDetail + ", deathDetail=" + deathDetail + ", death=" + death
				+ "]";
	}

}
