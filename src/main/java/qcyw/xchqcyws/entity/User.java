package qcyw.xchqcyws.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("openid")
    private String openid;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("unionid")
    private String unionid;

}
