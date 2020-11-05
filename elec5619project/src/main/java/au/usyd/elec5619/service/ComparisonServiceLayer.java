package au.usyd.elec5619.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;


@SuppressWarnings("serial")
@Service(value="comparisonServiceLayer")
public class ComparisonServiceLayer implements ComparisonServiceInt {
	private static final Logger logger = LoggerFactory.getLogger(ComparisonServiceLayer.class);
	@Resource(name="comparisonDAO")
	private ComparisonDAOInt comparisonDAO;
	
	private Gson gsonObj = new Gson();
	private List<retailer> unique_retailers;
	private Map<Object, Object> byretailer_map = new HashMap<Object, Object>();
	private Map<String, Map<String, Double>> byretailer_map_tbl = new HashMap<String, Map<String, Double>>();
	private Map<String, List<Double>> full_prices_for_avg_map= new HashMap<String,List<Double>>();
	
	public Map<Object,Object> formatDataCharts(Map<Object, Object> myModel, String Loc, String wishList){
		unique_retailers = this.comparisonDAO.getUniqueRetailers(Loc);
		List<String> wishlist=Arrays.asList(wishList.split(","));
		for (int i=0; i<unique_retailers.size();i++) {
			logger.info(unique_retailers.get(i).getTag());
			String tag = unique_retailers.get(i).getTag();
			List<product_prices> all_row = this.comparisonDAO.getRetailers(unique_retailers.get(i).getTag(),unique_retailers.get(i).getLocation(),wishList);
			List<Map<Object,Object>> list_row_maps = new ArrayList<Map<Object,Object>>();
			Map<String, Double> map_tbl_by_ret = new HashMap<String,Double>();	
			List<Double> pprices= new ArrayList<Double>();
			for (int j=0; j<all_row.size();j++) {
				if (wishlist.contains(all_row.get(j).getProduct_name())) {
				String name= all_row.get(j).getProduct_name();
				double price= all_row.get(j).getPrice();
				String category= all_row.get(j).getCategory();
				Map<Object, Object> map = new HashMap<Object,Object>();	
				map.put("label", name+"-"+category);
				map.put("y", price);
				list_row_maps.add(map);			
				pprices.add(price);
				map_tbl_by_ret.put(name, price);	
				}
			}
			full_prices_for_avg_map.put(tag, pprices);
			byretailer_map_tbl.put(tag, map_tbl_by_ret);
			String dataPoints = gsonObj.toJson(list_row_maps);
			byretailer_map.put(tag, dataPoints);
		}
		myModel.put("wow",byretailer_map.get("wow"));
		myModel.put("col",byretailer_map.get("col"));
		myModel.put("ald",byretailer_map.get("ald"));
		logger.info("Charts data is prepared. Table data is now being prepared.");
		return myModel;
	}
	
	public Map<Object,Object> formatDataTable(Map<Object, Object> myModel, String Loc, String wishList){
		//unique_retailers = this.comparisonDAO.getUniqueRetailers(Loc);
		List<Map<Object,Object>> final_tbl=new ArrayList<Map<Object, Object>>();
		List<String> wishlist=Arrays.asList(wishList.split(","));
		for (int p=0; p<wishlist.size();p++) {
			String prod = wishlist.get(p).toString();
			logger.info("Running for " + prod);
	        Map<Object,Object> map_per_prod= new HashMap<Object, Object>();
	        map_per_prod.put("product", prod);
	        for (int i=0;i<unique_retailers.size();i++) {
	        	String retail_tag = unique_retailers.get(i).getTag();
	        	Map<String, Double> prod_price = byretailer_map_tbl.get(retail_tag);
	        	String key_name=retail_tag+"_price";
	        	map_per_prod.put(key_name,"$"+prod_price.getOrDefault(prod, 0.0));
	        }
	        final_tbl.add(map_per_prod);
	    }
		Map<Object,Object> map_avgs= new HashMap<Object, Object>();
		
	    for (int i=0; i<unique_retailers.size();i++) {
	    	String tag_val = unique_retailers.get(i).getTag();
			List<Double> prices_ret = full_prices_for_avg_map.get(tag_val);
			double total=0.0;
			double avg_price = 0.0;
			logger.info("Prices array for retailer tag " + tag_val + " "+ prices_ret);
			for(int j = 0; j < prices_ret.size(); j++)
			{	
			    total = total+prices_ret.get(j);
			}
			avg_price = total / prices_ret.size();
			BigDecimal bd = BigDecimal.valueOf(avg_price);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
			logger.info("The Total price for "+ tag_val + " is:" + total);
			logger.info("The Number of products for "+ tag_val + " is:" + prices_ret.size());
		    logger.info("The Average price for "+ tag_val + " is:" + bd.doubleValue());
			map_avgs.put(tag_val+"_price","$"+bd.doubleValue());
		}
		Map<Object,Object> map_choice_stg= new HashMap<Object, Object>();
		map_choice_stg=map_avgs;
		map_choice_stg.remove("product");
		Map.Entry<Object, Object> minEntry = null;
		for (Entry<Object, Object> entry : map_choice_stg.entrySet()) {
		  if (minEntry == null || Double.valueOf(entry.getValue().toString().replace("$", "")) < Double.valueOf(minEntry.getValue().toString().replace("$", ""))) {
		    minEntry = entry;
		  }
		}
		Object minKey = minEntry.getKey(); 
	    logger.info("Min avg price per product key is "+minKey);
	    map_avgs.put("product","AVERAGE PRICE PER PRODUCT");
	    final_tbl.add(map_avgs);
	    Map<Object,Object> map_choice= new HashMap<Object, Object>();
	    map_choice.put(minKey, "BEST OPTION!");
	    map_choice.put("product", "CHOICE");
	    for (Map.Entry<Object, Object> entry : map_choice_stg.entrySet()) {
	        String key_val = entry.getKey().toString();
	        map_choice.putIfAbsent(key_val, "---");
	    }
	    final_tbl.add(map_choice);
	    myModel.put("retailers",final_tbl);
	    
		return myModel;
	}
	

}