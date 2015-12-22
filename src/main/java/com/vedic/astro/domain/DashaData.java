package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.Collection;

public class DashaData {
	
	
	Collection<DashaPeriodSnapshot> data = new ArrayList<DashaPeriodSnapshot>();
	
	public Collection<DashaPeriodSnapshot> getData() {
		return data;
	}

	public void setData(Collection<DashaPeriodSnapshot> data) {
		this.data = data;
	}

	public void add(DashaPeriodSnapshot dashaPeriodSnapshot){
	    this.data.add(dashaPeriodSnapshot);	
	}

	@Override
	public String toString() {
		return "DashaData [data=" + data + "]";
	}
}
