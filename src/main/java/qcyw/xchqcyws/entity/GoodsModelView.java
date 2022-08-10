package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LUW
 */
@Data
@ApiModel("商品视图实体类")
public class GoodsView {

    @ApiModelProperty("ssId")
    /**商品主表ID*/
    private String ssId;

    @ApiModelProperty("ssSortId")
    /**商品类别ID*/
    private String ssSortId;

    @ApiModelProperty("ssGoodsPic")
    /**商品图片地址*/
    private String ssGoodsPic;

    @ApiModelProperty("ssGoodsId")
    /**商品标识ID*/
    private String ssGoodsId;

    @ApiModelProperty("ssGoodsName")
    /**商品名称*/
    private String ssGoodsName;

    @ApiModelProperty("ssGoodsNum")
    /**商品数量*/
    private int ssGoodsNum;

    @ApiModelProperty("ssGoodsPrice")
    /**商品价格*/
    private double ssGoodsPrice;

    @ApiModelProperty("ssGoodsDetails")
    /**商品详情*/
    private String ssGoodsDetails;

    @ApiModelProperty("ssGoodsSpecs")
    /**商品规格*/
    private String ssGoodsSpecs;

    @ApiModelProperty("ssDelFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private int ssDelFlag;

    @ApiModelProperty("ssCreateBy")
    /**创建者*/
    private String ssCreateBy;

    @ApiModelProperty("ssCreateTime")
    /**创建时间*/
    private Date ssCreateTime;

    @ApiModelProperty("ssUpdateTime")
    /**更新时间*/
    private Date ssUpdateTime;

    @ApiModelProperty("ssOrdersPrice")
    /**每日订货价格(随行情波动)*/
    private double ssOrdersPrice;

    @ApiModelProperty("ssMarketPrice")
    /**市场零售价*/
    private double ssMarketPrice;

    @ApiModelProperty("ssMemberPrice")
    /**会员价格*/
    private double ssMemberPrice;

    @ApiModelProperty("ssCompanyId")
    /**单位标识ID*/
    private String ssCompanyId;
    /**goods_sort表*/

    @ApiModelProperty("gsId")
    /**商品分类ID*/
    private String gsId;

    @ApiModelProperty("gsSortId")
    /**商品类别ID*/
    private String gsSortId;

    @ApiModelProperty("gsSortName")
    /**商品类别名称*/
    private String gsSortName;

    @ApiModelProperty("gsDelFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private int gsDelFlag;

    @ApiModelProperty("gsCreateBy")
    /**创建者*/
    private String gsCreateBy;

    @ApiModelProperty("gsCreateTime")
    /**创建时间*/
    private Date gsCreateTime;

    @ApiModelProperty("gsUpdateTime")
    /**更新时间*/
    private Date gsUpdateTime;

    /**company表*/

    @ApiModelProperty("ccDelFlag")
    /**删除标记(1代表存在 0代表删除)*/
    private int ccDelFlag;

    @ApiModelProperty("ccCreateBy")
    /**创建者*/
    private String ccCreateBy;

    @ApiModelProperty("ccCreateTime")
    /**创建时间*/
    private Date ccCreateTime;

    @ApiModelProperty("ccUpdateTime")
    /**更新时间*/
    private Date ccUpdateTime;

    @ApiModelProperty("ccId")
    /**单位名称表ID*/
    private String ccId;

    @ApiModelProperty("ccCompanyName")
    /**单位名称*/
    private String ccCompanyName;

    @ApiModelProperty("cCompanyId")
    /**单位标识ID*/
    private String ccCompanyId;

}
