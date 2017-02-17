package com.topie.animald.service;

import com.github.pagehelper.PageInfo;
import com.topie.common.service.IService;
import com.topie.database.core.model.Report;

/**
 * Created by chenguojun on 2017/2/16.
 */
public interface IReportService extends IService<Report> {

    PageInfo<Report> selectByPage(Report userInfo, int pageNum, int pageSize);
}
