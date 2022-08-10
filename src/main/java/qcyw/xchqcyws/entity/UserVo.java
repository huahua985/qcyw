package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LUW
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户个人信息Vo类")
public class UserVo {

    @ApiModelProperty("余额")
    private double price;

    @ApiModelProperty("openid")
    private String openid;
}
