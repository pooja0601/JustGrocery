package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.Map;


public interface ComparisonServiceInt extends Serializable {
	public Map<Object,Object> formatDataCharts(Map<Object, Object> myModel, String Loc, String wishList);
	public Map<Object,Object> formatDataTable(Map<Object, Object> myModel, String Loc, String wishList);
	

}
