package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("地址簿实体类")
public class Address {
    @ApiModelProperty("id")
    /*地址簿ID*/
    private String id;

    @ApiModelProperty("userId")
    /*用户ID*/
    private String userId;

    @ApiModelProperty("address")
    /*住址*/
    private String address;

    @ApiModelProperty("phone")
    /*收货人手机号码*/
    private String phone;

    @ApiModelProperty("consignee")
    /*收货人姓名*/
    private String consignee;

    @ApiModelProperty("isDefault")
    /*是否默认地址(1为默认地址 0则不为默认地址）*/
    private String isDefault;

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
