package qcyw.xchqcyws.common.domain;

import lombok.Data;
import qcyw.xchqcyws.common.untils.StringUtils;

import java.io.Serializable;

/**
 * 分页实体
 *
 * @date 2022/3/31
 * @Description
 */
@Data
public class PageHelperEntity implements Serializable {

    /**
     * 用户唯一标识(必传)
     */
    private String openid;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页显示的条数
     */
    private Integer pageSize;


    /**
     * 排序字段
     */
    private String orderByColumn;

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    private String isAsc;

    public String getOrderBy() {
        if (StringUtils.isEmpty(orderByColumn)) {
            return "";
        }
        return orderByColumn + (StringUtils.isEmpty(isAsc) ? "" : " " + isAsc);
    }

}
