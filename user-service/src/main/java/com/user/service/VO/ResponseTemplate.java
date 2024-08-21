package com.user.service.VO;

import com.user.service.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class ResponseTemplate {

    private UserEntity userEnity;
    private Department department;
}
