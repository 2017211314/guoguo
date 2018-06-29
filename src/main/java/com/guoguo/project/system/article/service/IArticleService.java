package com.guoguo.project.system.article.service;

import com.guoguo.project.system.article.domain.Article;

import java.util.List;

/**
 * 文章 服务层
 * 
 * @author liuda
 * @date 2018-06-28
 */
public interface IArticleService 
{
	
	/**
     * 查询文章信息
     * 
     * @param articleId 文章ID
     * @return 文章信息
     */
	public Article selectArticleById(Integer articleId);
	
	/**
     * 查询文章列表
     * 
     * @param article 文章信息
     * @return 文章集合
     */
	public List<Article> selectArticleList(Article article);
	
	/**
     * 新增文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	public int insertArticle(Article article);
	
	/**
     * 修改文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	public int updateArticle(Article article);
	
	/**
     * 保存文章
     * 
     * @param article 文章信息
     * @return 结果
     */
	public int saveArticle(Article article);
	
	/**
     * 删除文章信息
     * 
     * @param articleId 文章ID
     * @return 结果
     */
	public int deleteArticleById(Integer articleId);
	
	/**
     * 批量删除文章信息
     * 
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
	public int batchDeleteArticle(Integer[] articleIds);
	
}
