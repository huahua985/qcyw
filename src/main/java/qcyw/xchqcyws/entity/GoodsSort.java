package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("商品类别实体类")
public class GoodsSort {
    @ApiModelProperty("id")
    /*商品分类ID*/
    private String id;

    @ApiModelProperty("sortId")
    /*商品类别ID*/
    private String sortId;

    @ApiModelProperty("sortName")
    /*商品类别名称*/
    private String sortName;

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
