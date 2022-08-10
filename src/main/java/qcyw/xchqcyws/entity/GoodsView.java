package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LUW
 */
@Data
@ApiModel("商品视图实体类")
public class GoodsView {
    @ApiModelProperty("ssGoodsId")
    /**商品标识ID*/
    private String ssGoodsId;

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

    @ApiModelProperty("gsSortName")
    /**商品类别名称*/
    private String gsSortName;

}
