package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("购物车实体类")
public class MyCart {
    @ApiModelProperty("cardId")
    /*购物车ID*/
    private String cardId;

    @ApiModelProperty("userId")
    /*用户ID*/
    private String userId;

    @ApiModelProperty("goodsPic")
    /*商品图片地址*/
    private String goodsPic;

    @ApiModelProperty("goodsId")
    /*商品标识ID*/
    private String goodsId;

    @ApiModelProperty("goodsName")
    /*商品名称*/
    private String goodsName;

    @ApiModelProperty("cartNum")
    /*购买商品数量*/
    private String cartNum;

    @ApiModelProperty("goodsPrice")
    /*商品价格*/
    private String goodsPrice;

    @ApiModelProperty("goodsSpecs")
    /*商品规格*/
    private String goodsSpecs;

    @ApiModelProperty("buyStatus")
    /*购买状态(0代表未支付 1代表已支付)*/
    private String buyStatus;

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

    @ApiModelProperty("addNum")
    /*购买增加商品数量*/
    private String addNum;

    @ApiModelProperty("deleteNum")
    /*购买减少商品数量*/
    private String deleteNum;
}
