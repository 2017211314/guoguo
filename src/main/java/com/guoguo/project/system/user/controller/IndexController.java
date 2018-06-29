package com.guoguo.project.system.user.controller;

import com.guoguo.framework.config.GuoGuoConfig;
import com.guoguo.framework.web.controller.BaseController;
import com.guoguo.project.system.menu.domain.Menu;
import com.guoguo.project.system.menu.service.IMenuService;
import com.guoguo.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author liuda
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private GuoGuoConfig GuoGuoConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(Model model)
    {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("user", user);
        model.addAttribute("copyrightYear", GuoGuoConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(Model model)
    {
        model.addAttribute("version", GuoGuoConfig.getVersion());
        return "main";
    }

}
