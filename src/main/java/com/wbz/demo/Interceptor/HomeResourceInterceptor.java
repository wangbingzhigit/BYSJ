package com.wbz.demo.Interceptor;
import com.wbz.demo.entity.custom.*;
import com.wbz.demo.service.*;
import com.wbz.demo.entity.custom.*;
import com.wbz.demo.service.*;
import org.apache.cxf.common.i18n.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

public class HomeResourceInterceptor implements WebRequestInterceptor{
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */
    @Override
    public void preHandle(WebRequest request) throws java.lang.Exception {
        System.out.println("我是HomeResourceInterceptor类中的preHandle方法");
     //导航主要菜单显示
        //分类目录显示
        List<CategoryCustom> categoryList = categoryService.listCategory(1);
        request.setAttribute("categoryList",categoryList,WebRequest.SCOPE_REQUEST);

      //侧边栏显示
		//获得随机文章
		List<ArticleCustom> randomArticleList = articleService.listRandomArticle(1,8);
		request.setAttribute("randomArticleList",randomArticleList,WebRequest.SCOPE_REQUEST);

		//获得网站概况
		List<String> siteBasicStatistics = new ArrayList<String>();
		siteBasicStatistics.add(articleService.countArticle(1)+"");
		siteBasicStatistics.add(categoryService.countCategory(1)+"");
		request.setAttribute("siteBasicStatistics",siteBasicStatistics,WebRequest.SCOPE_REQUEST);
		//最后更新的文章
        ArticleCustom lastUpdateArticle = articleService.getLastUpdateArticle();
        request.setAttribute("lastUpdateArticle",lastUpdateArticle,WebRequest.SCOPE_REQUEST);

    }
    /**
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
     */
    @Override
    public void postHandle(WebRequest request, ModelMap map) throws Exception {
        //System.out.println("postHandle.......");
    }
    /**
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放
     */

    public void afterCompletion(WebRequest request, Exception exception)
            throws Exception {
        //System.out.println("afterCompletion");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, java.lang.Exception e) throws java.lang.Exception {

    }
}