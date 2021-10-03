package com.vels.user.Vo;

import com.vels.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseTemplateVo {

    private User user;
    private Department department;
}
