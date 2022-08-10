package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LUW
 */
@Data
@ApiModel("购物车实体类")
public class MyCart {
    @ApiModelProperty("id")
    /**购物车ID*/
    private int id;

    @ApiModelProperty("openid")
    /**openid*/
    private String openid;

    @ApiModelProperty("goodsId")
    /**商品标识ID*/
    private String goodsId;

    @ApiModelProperty("cartNum")
    /**购买商品数量*/
    private int cartNum;

    @ApiModelProperty("addNum")
    /**购买增加商品数量*/
    private String addNum;

    @ApiModelProperty("deleteNum")
    /**购买减少商品数量*/
    private String deleteNum;

    @ApiModelProperty("delFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private String delFlag;
}
