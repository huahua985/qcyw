package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LUW
 */
@Data
@ApiModel("订单实体类")
public class Orders {
    @ApiModelProperty("id")
    /**订单表ID*/
    private String id;

    @ApiModelProperty("ordersId")
    /**订单商品标识ID*/
    private String ordersId;

    @ApiModelProperty("openid")
    /**用户ID*/
    private String openid;

    @ApiModelProperty("ordersName")
    /**订单商品名称*/
    private String ordersName;

    @ApiModelProperty("payablePrice")
    /**应付金额*/
    private Double payablePrice;

    @ApiModelProperty("paidPrice")
    /**实付金额*/
    private Double paidPrice;

    @ApiModelProperty("delFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private String delFlag;

    @ApiModelProperty("createBy")
    /**创建者*/
    private String createBy;

    @ApiModelProperty("createTime")
    /**创建时间*/
    private Date createTime;

    @ApiModelProperty("updateTime")
    /**更新时间*/
    private Date updateTime;

}
