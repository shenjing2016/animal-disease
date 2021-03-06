package com.topie.common.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topie.common.utils.CamelUtil;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by chenguojun on 8/31/16.
 */
public class Sortable implements Serializable {

    private static final long serialVersionUID = 4103411269761135435L;

    @Transient
    @JsonIgnore
    private String sort_;

    public String getSort_() {
        String sortStr = "";
        if (!StringUtils.isEmpty(sort_)) {
            if (sort_.indexOf("_desc") != -1) {
                String filed = CamelUtil.camelToUnderline(sort_.replace("_desc", ""));
                sortStr = filed + " desc";
            } else if (sort_.indexOf("_asc") != -1) {
                String filed = CamelUtil.camelToUnderline(sort_.replace("_asc", ""));
                sortStr = filed + " asc";
            }
            sortStr = "order by " + sortStr;
        }
        return sortStr;
    }

    public void setSort_(String sort_) {
        this.sort_ = sort_;
    }

}
