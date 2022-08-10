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
public class OrdersSon {
    @ApiModelProperty("id")
    /**订单表ID*/
    private String id;

    @ApiModelProperty("orderSonId")
    /**订单型号标识*/
    private String orderSonId;

    @ApiModelProperty("orderSonName")
    /**订单型号名称*/
    private String orderSonName;

    @ApiModelProperty("goods_num")
    /**订单数量*/
    private int goodsNum;

    @ApiModelProperty("goodsPrice")
    /**订单价格*/
    private Double goodsPrice;

    @ApiModelProperty("delFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private int delFlag;

    @ApiModelProperty("createBy")
    /**创建者*/
    private String createBy;

    @ApiModelProperty("createTime")
    /**创建时间*/
    private Date createTime;

    @ApiModelProperty("updateTime")
    /**更新时间*/
    private Date updateTime;

    @ApiModelProperty("goodsPic")
    /**订单图片地址*/
    private String goodsPic;

    @ApiModelProperty("goodsSpecs")
    /**订单商品规格*/
    private String goodsSpecs;

    @ApiModelProperty("ordersIds")
    /**订单主表关联ID*/
    private String ordersIds;

    @ApiModelProperty("ordersName")
    /**订单商品名称*/
    private String ordersName;
}
