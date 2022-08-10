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
public class GoodsModelView {

    @ApiModelProperty("ssGoodsPic")
    /**商品图片地址*/
    private String ssGoodsPic;

    @ApiModelProperty("ssGoodsName")
    /**商品名称*/
    private String ssGoodsName;

    @ApiModelProperty("ssGoodsPrice")
    /**商品价格*/
    private double ssGoodsPrice;

    @ApiModelProperty("ssGoodsDetails")
    /**商品详情*/
    private String ssGoodsDetails;

    @ApiModelProperty("ssGoodsSpecs")
    /**商品规格*/
    private String ssGoodsSpecs;

    /**company表*/
    @ApiModelProperty("ccCompanyName")
    /**单位名称*/
    private String ccCompanyName;

    /**goods_model表*/

    @ApiModelProperty("gmModelName")
    /**商品型号名称*/
    private String gmModelName;

    @ApiModelProperty("gmModelPrice")
    /**商品型号价格*/
    private String gmModelPrice;

    @ApiModelProperty("gmMemberPrice")
    /**会员价格*/
    private double gmMemberPrice;

    @ApiModelProperty("aaAnnexName")
    /**附件图片*/
    private String aaAnnexName;

}
