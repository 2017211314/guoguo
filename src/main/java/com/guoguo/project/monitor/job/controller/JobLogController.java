package com.guoguo.project.monitor.job.controller;

import com.guoguo.framework.aspectj.lang.annotation.Log;
import com.guoguo.framework.web.controller.BaseController;
import com.guoguo.framework.web.domain.Message;
import com.guoguo.framework.web.page.TableDataInfo;
import com.guoguo.project.monitor.job.domain.JobLog;
import com.guoguo.project.monitor.job.service.IJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度日志操作处理
 * 
 * @author liuda
 */
@Controller
@RequestMapping("/monitor/jobLog")
public class JobLogController extends BaseController
{
    private String prefix = "monitor/job";

    @Autowired
    private IJobLogService jobLogService;

    @RequiresPermissions("monitor:job:view")
    @GetMapping()
    public String jobLog()
    {
        return prefix + "/jobLog";
    }

    @RequiresPermissions("monitor:job:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JobLog jobLog)
    {
        startPage();
        List<JobLog> list = jobLogService.selectJobLogList(jobLog);
        return getDataTable(list);
    }

    /**
     * 调度日志删除
     */
    @Log(title = "监控管理", action = "定时任务-删除调度日志")
    @RequiresPermissions("monitor:job:remove")
    @RequestMapping("/remove/{jobLogId}")
    @ResponseBody
    public Message remove(@PathVariable("jobLogId") Long jobLogId)
    {
        JobLog jobLog = jobLogService.selectJobLogById(jobLogId);
        if (jobLog == null)
        {
            return Message.error("调度任务不存在");
        }
        if (jobLogService.deleteJobLogById(jobLogId) > 0)
        {
            return Message.success();
        }
        return Message.error();
    }

    @Log(title = "监控管理", action = "定时任务-批量删除日志")
    @RequiresPermissions("monitor:job:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    public Message batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        try
        {
            jobLogService.batchDeleteJoblog(ids);
            return Message.success();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return Message.error(e.getMessage());
        }
    }
}
