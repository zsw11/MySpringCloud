package com.zsw.provider.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author zsw
 * @date 2021/3/20 10:41
 * @description :
 */
@Data
@ApiModel
@Component
public class User implements Serializable {

    private int id;

    @ApiModelProperty("用户姓名")  //model注释
    @ApiParam("用户姓名")  // 参数注释
//    @Size(min = 3, max = 10)
    @NotNull
    private String name;

    // 读取 ValidationMessage.properties 的信息
    //  @NotNull(message = "{user.address.notnull}")  读取 ValidationMessage.properties 的信息
    @NotNull //使用默认提示信息
    @ApiParam("用户地址")
    @ApiModelProperty("用户地址")
    private String address;

    @ApiModelProperty("年龄")
    @DecimalMin(value = "1")
    @DecimalMax(value = "200")
    @ApiParam("用户年龄")
    private Integer age;

    @NotNull
    @ApiParam("用户电话")
    private String phone;

    @ApiParam("用户博客")
    private String blog;

    @Email
    @NotNull
    @ApiParam("用户邮箱")
    private String email;
}
