package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LUW
 */
@Data
@ApiModel("商品实体类")
public class Goods {
    @ApiModelProperty("id")
    /**商品主表ID*/
    private String id;

    @ApiModelProperty("sortId")
    /**商品类别ID*/
    private String sortId;

    @ApiModelProperty("goodsPic")
    /**商品图片地址*/
    private String goodsPic;

    @ApiModelProperty("goodsId")
    /**商品标识ID*/
    private String goodsId;

    @ApiModelProperty("goodsName")
    /**商品名称*/
    private String goodsName;

    @ApiModelProperty("goodsNum")
    /**商品数量*/
    private String goodsNum;

    @ApiModelProperty("goodsPrice")
    /**商品价格*/
    private String goodsPrice;

    @ApiModelProperty("goodsDetails")
    /**商品详情*/
    private String goodsDetails;

    @ApiModelProperty("goodsSpecs")
    /**商品规格*/
    private String goodsSpecs;

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
