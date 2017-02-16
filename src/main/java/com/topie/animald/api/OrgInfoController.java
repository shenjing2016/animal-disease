package com.topie.animald.api;

import com.github.pagehelper.PageInfo;
import com.topie.animald.service.IOrgInfoService;
import com.topie.common.utils.PageConvertUtil;
import com.topie.common.utils.ResponseUtil;
import com.topie.common.utils.Result;
import com.topie.database.core.model.OrgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenguojun on 2017/2/16.
 */
@Controller
@RequestMapping("/api/animalDisease/orgInfo")
public class OrgInfoController {
    @Autowired
    private IOrgInfoService iOrgInfoService;

    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    @ResponseBody
    public Result roles(OrgInfo orgInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<OrgInfo> pageInfo = iOrgInfoService.selectByPage(orgInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertRole(OrgInfo orgInfo) {
        int result = iOrgInfoService.saveNotNull(orgInfo);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateRole(OrgInfo orgInfo) {
        iOrgInfoService.updateNotNull(orgInfo);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadRole(@PathVariable(value = "id") Integer id) {
        OrgInfo orgInfo = iOrgInfoService.selectByKey(id);
        return ResponseUtil.success(orgInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iOrgInfoService.delete(id);
        return ResponseUtil.success();
    }
}
