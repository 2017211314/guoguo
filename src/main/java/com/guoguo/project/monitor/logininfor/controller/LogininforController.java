package com.guoguo.project.monitor.logininfor.controller;

import com.guoguo.framework.aspectj.lang.annotation.Log;
import com.guoguo.framework.web.controller.BaseController;
import com.guoguo.framework.web.domain.Message;
import com.guoguo.framework.web.page.TableDataInfo;
import com.guoguo.project.monitor.logininfor.domain.Logininfor;
import com.guoguo.project.monitor.logininfor.service.ILogininforService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统访问记录
 * 
 * @author liuda
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class LogininforController extends BaseController
{
    private String prefix = "monitor/logininfor";

    @Autowired
    private ILogininforService logininforService;

    @RequiresPermissions("monitor:logininfor:view")
    @GetMapping()
    public String logininfor()
    {
        return prefix + "/logininfor";
    }

    @RequiresPermissions("monitor:logininfor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Logininfor logininfor)
    {
        startPage();
        List<Logininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:logininfor:batchRemove")
    @Log(title = "监控管理", action = "登录日志-批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    public Message batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = logininforService.batchDeleteLogininfor(ids);
        if (rows > 0)
        {
            return Message.success();
        }
        return Message.error();
    }
}
