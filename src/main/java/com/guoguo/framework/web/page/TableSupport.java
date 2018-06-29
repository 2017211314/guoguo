package com.guoguo.framework.web.page;

import com.guoguo.common.constant.Constants;
import com.guoguo.common.utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @author liuda
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getIntParameter(Constants.PAGENUM));
        pageDomain.setPageSize(ServletUtils.getIntParameter(Constants.PAGESIZE));
        pageDomain.setOrderByColumn(ServletUtils.getStrParameter(Constants.ORDERBYCOLUMN));
        pageDomain.setIsAsc(ServletUtils.getStrParameter(Constants.ISASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }

}
