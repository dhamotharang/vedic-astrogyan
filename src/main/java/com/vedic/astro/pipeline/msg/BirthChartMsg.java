package com.vedic.astro.pipeline.msg;

public class BirthChartMsg {
	
	private String pid;
	private String chartId;
	
	public BirthChartMsg(String pid, String chartId) {
		super();
		this.pid = pid;
		this.chartId = chartId;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getChartId() {
		return chartId;
	}
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	@Override
	public String toString() {
		return "BirthChartMsg [pid=" + pid + ", chartId=" + chartId + "]";
	}
}
