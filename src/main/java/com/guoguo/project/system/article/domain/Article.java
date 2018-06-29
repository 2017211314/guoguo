package com.guoguo.project.system.article.domain;

import com.guoguo.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 文章表 t_article
 * 
 * @author liuda
 * @date 2018-06-28
 */
public class Article extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 文章id */
	private Integer articleId;
	/** 文章种类id */
	private Integer categoryId;
	/** 标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 关键字 */
	private String keyWords;
	/** 作者 */
	private String author;
	/** 发布时间 */
	private Date publishTime;
	/** 发布人/机构 */
	private String publisher;
	/** 是否推荐  1 推荐 2 不推荐 */
	private Integer recommend;
	/** 是否发布 1 发布 0 未发布 */
	private Integer isPublished;
	/** 状态，1 开启 2 关闭 */
	private Integer state;
	/** 是否置顶 1 置顶 0 不置顶 */
	private Integer isTop;
	/** 文章主图 */
	private String image;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 状态 1 已删除 2 未删除 */
	private Integer delState;
	/** 管理员id */
	private Integer adminId;

	/**
	 * 设置：文章id
	 */
	public void setArticleId(Integer articleId) 
	{
		this.articleId = articleId;
	}
	
	/**
	 * 获取：文章id
	 */
	public Integer getArticleId() 
	{
		return articleId;
	}
	
	/**
	 * 设置：文章种类id
	 */
	public void setCategoryId(Integer categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	/**
	 * 获取：文章种类id
	 */
	public Integer getCategoryId() 
	{
		return categoryId;
	}
	
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	/**
	 * 获取：标题
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * 设置：内容
	 */
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() 
	{
		return content;
	}
	
	/**
	 * 设置：关键字
	 */
	public void setKeyWords(String keyWords) 
	{
		this.keyWords = keyWords;
	}
	
	/**
	 * 获取：关键字
	 */
	public String getKeyWords() 
	{
		return keyWords;
	}
	
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	/**
	 * 获取：作者
	 */
	public String getAuthor() 
	{
		return author;
	}
	
	/**
	 * 设置：发布时间
	 */
	public void setPublishTime(Date publishTime) 
	{
		this.publishTime = publishTime;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getPublishTime() 
	{
		return publishTime;
	}
	
	/**
	 * 设置：发布人/机构
	 */
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	
	/**
	 * 获取：发布人/机构
	 */
	public String getPublisher() 
	{
		return publisher;
	}
	
	/**
	 * 设置：是否推荐  1 推荐 2 不推荐
	 */
	public void setRecommend(Integer recommend) 
	{
		this.recommend = recommend;
	}
	
	/**
	 * 获取：是否推荐  1 推荐 2 不推荐
	 */
	public Integer getRecommend() 
	{
		return recommend;
	}
	
	/**
	 * 设置：是否发布 1 发布 0 未发布
	 */
	public void setIsPublished(Integer isPublished) 
	{
		this.isPublished = isPublished;
	}
	
	/**
	 * 获取：是否发布 1 发布 0 未发布
	 */
	public Integer getIsPublished() 
	{
		return isPublished;
	}
	
	/**
	 * 设置：状态，1 开启 2 关闭
	 */
	public void setState(Integer state) 
	{
		this.state = state;
	}
	
	/**
	 * 获取：状态，1 开启 2 关闭
	 */
	public Integer getState() 
	{
		return state;
	}
	
	/**
	 * 设置：是否置顶 1 置顶 0 不置顶
	 */
	public void setIsTop(Integer isTop) 
	{
		this.isTop = isTop;
	}
	
	/**
	 * 获取：是否置顶 1 置顶 0 不置顶
	 */
	public Integer getIsTop() 
	{
		return isTop;
	}
	
	/**
	 * 设置：文章主图
	 */
	public void setImage(String image) 
	{
		this.image = image;
	}
	
	/**
	 * 获取：文章主图
	 */
	public String getImage() 
	{
		return image;
	}
	
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() 
	{
		return createTime;
	}
	
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}
	
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() 
	{
		return updateTime;
	}
	
	/**
	 * 设置：状态 1 已删除 2 未删除
	 */
	public void setDelState(Integer delState) 
	{
		this.delState = delState;
	}
	
	/**
	 * 获取：状态 1 已删除 2 未删除
	 */
	public Integer getDelState() 
	{
		return delState;
	}
	
	/**
	 * 设置：管理员id
	 */
	public void setAdminId(Integer adminId) 
	{
		this.adminId = adminId;
	}
	
	/**
	 * 获取：管理员id
	 */
	public Integer getAdminId() 
	{
		return adminId;
	}
	
}
