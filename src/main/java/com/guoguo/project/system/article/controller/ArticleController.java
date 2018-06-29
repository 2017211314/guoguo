package com.guoguo.project.system.article.controller;

import com.guoguo.framework.web.controller.BaseController;
import com.guoguo.framework.web.domain.Message;
import com.guoguo.framework.web.page.TableDataInfo;
import com.guoguo.project.system.article.domain.Article;
import com.guoguo.project.system.article.service.IArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章 信息操作处理
 * 
 * @author liuda
 * @date 2018-06-28
 */
@Controller
@RequestMapping("/system/article")
public class ArticleController extends BaseController
{
    private String prefix = "system/article";
	
	@Autowired
	private IArticleService articleService;
	
	@GetMapping()
	@RequiresPermissions("system:article:view")
	public String article()
	{
	    return prefix + "/article";
	}
	
	/**
	 * 查询文章列表
	 */
	@RequiresPermissions("system:article:list")
	@GetMapping("/list")
	@ResponseBody
	public TableDataInfo list(Article article)
	{
		startPage();
        List<Article> list = articleService.selectArticleList(article);
		return getDataTable(list);
	}
	
	/**
	 * 新增文章
	 */
	@RequiresPermissions("system:article:add")
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 修改文章
	 */
	@RequiresPermissions("system:article:edit")
	@GetMapping("/edit/{articleId}")
	public String edit(@PathVariable("articleId") Integer articleId, Model model)
	{
		Article article = articleService.selectArticleById(articleId);
		model.addAttribute("article", article);
	    return prefix + "/edit";
	}
	
	/**
	 * 保存文章
	 */
	@RequiresPermissions("system:article:save")
	@PostMapping("/save")
	@ResponseBody
	public Message save(Article article)
	{
		if (articleService.saveArticle(article) > 0)
		{
			return Message.success();
		}
		return Message.error();
	}
	
	/**
	 * 删除文章
	 */
	@RequiresPermissions("system:article:remove")
	@PostMapping( "/remove/{articleId}")
	@ResponseBody
	public Message remove(@PathVariable("articleId") Integer articleId)
	{
		if (articleService.deleteArticleById(articleId) > 0)
		{
		    return Message.success();
		}
		return Message.error();
	}
	
	/**
	 * 批量删除文章
	 */
	@RequiresPermissions("system:article:batchRemove")
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Message remove(@RequestParam("ids[]") Integer[] articleIds)
	{
		int rows = articleService.batchDeleteArticle(articleIds);
		if (rows > 0)
        {
            return Message.success();
        }
        return Message.error();
	}
	
}
