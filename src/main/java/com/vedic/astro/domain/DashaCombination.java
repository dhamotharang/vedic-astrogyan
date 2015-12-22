package com.vedic.astro.domain;

import com.vedic.astro.enums.Dasha;

public class DashaCombination {
	
	private Dasha level1;
	private Dasha level2;
	private Dasha level3;
	private Dasha level4;
	
	
	public DashaCombination() {}
	
	
	public DashaCombination(Dasha level1, Dasha level2, Dasha level3,
			Dasha level4) {
		super();
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.level4 = level4;
	}
	
	public Dasha getLevel1() {
		return level1;
	}
	public void setLevel1(Dasha level1) {
		this.level1 = level1;
	}
	public Dasha getLevel2() {
		return level2;
	}
	public void setLevel2(Dasha level2) {
		this.level2 = level2;
	}
	public Dasha getLevel3() {
		return level3;
	}
	public void setLevel3(Dasha level3) {
		this.level3 = level3;
	}
	public Dasha getLevel4() {
		return level4;
	}
	public void setLevel4(Dasha level4) {
		this.level4 = level4;
	}
	@Override
	public String toString() {
		return "DashaCombination [level1=" + level1 + ", level2=" + level2
				+ ", level3=" + level3 + ", level4=" + level4 + "]";
	}
}
