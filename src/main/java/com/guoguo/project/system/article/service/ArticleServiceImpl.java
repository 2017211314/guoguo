package com.guoguo.project.system.article.service;

import com.guoguo.common.utils.StringUtils;
import com.guoguo.project.system.article.domain.Article;
import com.guoguo.project.system.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 文章 服务层实现
 * 
 * @author liuda
 * @date 2018-06-28
 */
@Service
public class ArticleServiceImpl implements IArticleService 
{
	@Autowired
	private ArticleMapper articleMapper;
	
	/**
     * 查询文章信息
     * 
     * @param articleId 文章ID
     * @return 文章信息
     */
	 @Override
	public Article selectArticleById(Integer articleId)
	{
	    return articleMapper.selectArticleById(articleId);
	}
	
	/**
     * 查询文章列表
     * 
     * @param article 文章信息
     * @return 文章集合
     */
	 @Override
	public List<Article> selectArticleList(Article article)
	{
	    return articleMapper.selectArticleList(article);
	}
	
    /**
     * 新增文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	 @Override
	public int insertArticle(Article article)
	{
	    return articleMapper.insertArticle(article);
	}
	
	/**
     * 修改文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	 @Override
	public int updateArticle(Article article)
	{
	    return articleMapper.updateArticle(article);
	}
	
	/**
     * 保存文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	 @Override
	public int saveArticle(Article article)
	{
	    Integer articleId = article.getArticleId();
		int rows = 0;
		if (StringUtils.isNotNull(articleId))
        {
		    rows = articleMapper.updateArticle(article);
		}
		else
        {
		    rows = articleMapper.insertArticle(article);
		}
		return rows;
	}
	
	/**
     * 删除文章信息
     * 
     * @param articleId 文章ID
     * @return 结果
     */
	 @Override
	public int deleteArticleById(Integer articleId)
	{
	    return articleMapper.deleteArticleById(articleId);
	}
	
	/**
     * 批量删除文章对象
     * 
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
	 @Override
	public int batchDeleteArticle(Integer[] articleIds)
	{
		return articleMapper.batchDeleteArticle(articleIds);
	}
	
}
