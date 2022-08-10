package qcyw.xchqcyws.common.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 * @date 2022/7/27
 * @author LUW
 */
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页显示的条数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private Integer totalPageNum;

    /**
     * 列表数据
     */
    private List<?> rows;
    /**
     * 消息状态码
     */
    private int code;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
