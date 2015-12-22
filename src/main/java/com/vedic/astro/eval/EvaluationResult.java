package com.vedic.astro.eval;

import com.vedic.astro.enums.EntityImpact;

public class EvaluationResult {
	
	private EntityImpact impact;
	private Double score;
	private String comments;
	
	public EntityImpact getImpact() {
		return impact;
	}
	public void setImpact(EntityImpact impact) {
		this.impact = impact;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "ActivityEvaluationResult [impact=" + impact + ", score="
				+ score + ", comments=" + comments + "]";
	}
}
