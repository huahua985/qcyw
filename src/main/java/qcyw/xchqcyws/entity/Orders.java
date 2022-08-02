package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("订单实体类")
public class Orders {
    @ApiModelProperty("id")
    /*订单表ID*/
    private String id;

    @ApiModelProperty("goodsId")
    /*订单商品标识ID*/
    private String goodsId;

    @ApiModelProperty("userId")
    /*用户ID*/
    private String userId;

    @ApiModelProperty("goodsName")
    /*订单商品名称*/
    private String goodsName;

    @ApiModelProperty("sortId")
    /*订单商品类别ID*/
    private String sortId;

    @ApiModelProperty("goodsPic")
    /*订单商品图片地址*/
    private String goodsPic;

    @ApiModelProperty("goodsNum")
    /*订单商品数量*/
    private String goodsNum;

    @ApiModelProperty("goodsPrice")
    /*订单商品价格*/
    private String goodsPrice;

    @ApiModelProperty("goodsDetails")
    /*商品详情*/
    private String goodsDetails;

    @ApiModelProperty("goodsSpecs")
    /*订单商品规格*/
    private String goodsSpecs;

    @ApiModelProperty("orderStatus")
    /*订单状态(1为未采购 2为已采购 3为未配送 4为配送中 5配送完成)*/
    private String orderStatus;

    @ApiModelProperty("delFlag")
    /*删除标记(1代表存在 0代表删除)*/
    private String delFlag;

    @ApiModelProperty("createBy")
    /*创建者*/
    private String createBy;

    @ApiModelProperty("createTime")
    /*创建时间*/
    private Date createTime;

    @ApiModelProperty("updateTime")
    /*更新时间*/
    private Date updateTime;

}
