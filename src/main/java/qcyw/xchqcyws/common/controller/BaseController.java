package qcyw.xchqcyws.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import qcyw.xchqcyws.common.domain.PageDomain;
import qcyw.xchqcyws.common.domain.PageHelperEntity;
import qcyw.xchqcyws.common.domain.TableDataInfo;
import qcyw.xchqcyws.common.domain.TableSupport;
import qcyw.xchqcyws.common.sql.SqlUtil;
import qcyw.xchqcyws.common.untils.StringUtils;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @date 2022/7/27
 * @author  LUW
 */
public class BaseController {

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo<>(list).getTotal());
        rspData.setPageNum(pageNum);
        rspData.setPageSize(pageSize);

        return rspData;
    }


    /**
     * 设置请求分页数据
     * 自定义带参数
     */
    protected void startPage(PageHelperEntity entity) {
        Integer pageNum = entity.getPageNum();
        Integer pageSize = entity.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(entity.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list, PageHelperEntity entity) {
        Integer pageNum = entity.getPageNum();
        Integer pageSize = entity.getPageSize();

        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        long total = new PageInfo(list).getTotal();
        rspData.setTotal(total);
        rspData.setPageNum(pageNum);
        rspData.setPageSize(pageSize);

        // 总页数 = 总记录数 / 每页显示记录数
        int totalPageNum = (new Long(total).intValue() + pageSize - 1) / pageSize;
        rspData.setTotalPageNum(totalPageNum);

        return rspData;
    }
}
