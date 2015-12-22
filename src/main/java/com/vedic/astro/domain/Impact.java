package com.vedic.astro.domain;

import java.io.Serializable;

public class Impact implements Serializable{
	
	private String gross;
	private String sublte;
	private String causal;
	
	public String getGross() {
		return gross;
	}
	public void setGross(String gross) {
		this.gross = gross;
	}
	public String getSublte() {
		return sublte;
	}
	public void setSublte(String sublte) {
		this.sublte = sublte;
	}
	public String getCausal() {
		return causal;
	}
	public void setCausal(String causal) {
		this.causal = causal;
	}
	@Override
	public String toString() {
		return "PlanetImpact [gross=" + gross + ", sublte=" + sublte
				+ ", causal=" + causal + "]";
	}
}
