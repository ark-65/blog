package io.ark.hope.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: ark
 * @Date: 2020/8/30 4:58 下午
 * @Description:
 */
@Data
@Entity
public class UserMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
}
