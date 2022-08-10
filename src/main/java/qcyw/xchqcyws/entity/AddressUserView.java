package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LUW
 */
@Data
@ApiModel("地址簿实体类")
public class AddressUserView {
    @ApiModelProperty("uaAddress")
    /**住址*/
    private String uaAddress;

    @ApiModelProperty("uaPhone")
    /**收货人手机号码*/
    private String uaPhone;

    @ApiModelProperty("uaConsignee")
    /**收货人姓名*/
    private String uaConsignee;

    @ApiModelProperty("uaIsDefault")
    /**是否默认地址(1为默认地址 0则不为默认地址）*/
    private int uaIsDefault;
}
