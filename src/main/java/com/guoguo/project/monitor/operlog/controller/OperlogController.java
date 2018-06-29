package com.guoguo.project.monitor.operlog.controller;

import com.guoguo.framework.web.controller.BaseController;
import com.guoguo.framework.web.domain.Message;
import com.guoguo.framework.web.page.TableDataInfo;
import com.guoguo.project.monitor.operlog.domain.OperLog;
import com.guoguo.project.monitor.operlog.service.IOperLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志记录
 * 
 * @author liuda
 */
@Controller
@RequestMapping("/monitor/operlog")
public class OperlogController extends BaseController
{
    private String prefix = "monitor/operlog";

    @Autowired
    private IOperLogService operLogService;

    @RequiresPermissions("monitor:operlog:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/operlog";
    }

    @RequiresPermissions("monitor:operlog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OperLog operLog)
    {
        startPage();
        List<OperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:operlog:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    public Message batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = operLogService.batchDeleteOperLog(ids);
        if (rows > 0)
        {
            return Message.success();
        }
        return Message.error();
    }

    @RequiresPermissions("monitor:operlog:detail")
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long deptId, Model model)
    {
        OperLog operLog = operLogService.selectOperLogById(deptId);
        model.addAttribute("operLog", operLog);
        return prefix + "/detail";
    }
}
