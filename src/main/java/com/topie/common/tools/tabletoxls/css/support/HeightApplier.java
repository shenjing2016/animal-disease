package com.topie.common.tools.tabletoxls.css.support;

import java.util.Map;
import java.util.HashMap;
import com.topie.common.tools.tabletoxls.css.CssUtils;
import com.topie.common.tools.tabletoxls.css.CssApplier;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;


/**
 * @version 0.0.1
 * @since 0.0.1
 * @author Shaun Chyxion <br>
 * chyxion@163.com <br>
 * Oct 24, 2014 5:18:57 PM
 */
public class HeightApplier implements CssApplier {

	/**
	 * {@inheritDoc}
	 */
    public Map<String, String> parse(Map<String, String> style) {
    	Map<String, String> mapRtn = new HashMap<String, String>();
    	String height = style.get(HEIGHT);
    	if (CssUtils.isNum(height)) {
    		mapRtn.put(HEIGHT, height);
    	}
	    return mapRtn;
    }

    /**
     * {@inheritDoc}
     */
    public void apply(HSSFCell cell, HSSFCellStyle cellStyle, Map<String, String> style) {
    	int height = Math.round(CssUtils.getInt(style.get(HEIGHT)) * 255 / 12.75F);
    	HSSFRow row = cell.getRow();
    	if (height > row.getHeight()) {
    		row.setHeight((short) height);
    	}
    }
}
