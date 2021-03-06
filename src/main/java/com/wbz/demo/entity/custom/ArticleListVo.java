package com.wbz.demo.entity.custom;


import com.wbz.demo.util.others.Page;

import java.util.List;

/**
 * @Title: ArticleListVo.java
 * @Description:用于封装文章列表，包括文章信息，作者信息，分类信息，标签信息
 * @Author 王炳智
 * @Date 2018/3/12 11:56
 */
public class ArticleListVo {
	//文章信息
	private ArticleCustom articleCustom;
	
	//文章对应的分类
	private List<CategoryCustom> categoryCustomList;

	//作者信息
	private UserCustom userCustom;

	//文章分页信息
	private Page page;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public ArticleCustom getArticleCustom() {
		return articleCustom;
	}
	
	public void setArticleCustom(ArticleCustom articleCustom) {
		this.articleCustom = articleCustom;
	}

	public List<CategoryCustom> getCategoryCustomList() {
		return categoryCustomList;
	}

	public void setCategoryCustomList(List<CategoryCustom> categoryCustomList) {
		this.categoryCustomList = categoryCustomList;
	}
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
}
