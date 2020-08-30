package io.ark.hope.core.impl;

import io.ark.hope.core.service.SaveTest;
import io.ark.hope.domain.UserMember;
import io.ark.hope.repository.UserMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Author: ark
 * @Date: 2020/8/30 5:29 下午
 * @Description:
 */
@Service
public class SaveTestImpl implements SaveTest {

    @Autowired
    private UserMemberRepository userMemberRepository;
    @Override
    public void save() {
        UserMember newUser = new UserMember();
        newUser.setUsername("testtest");
        newUser.setPassword("321421421");
        userMemberRepository.save(newUser);
    }


}
