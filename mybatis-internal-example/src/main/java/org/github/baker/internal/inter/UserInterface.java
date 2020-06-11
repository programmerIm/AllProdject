package org.github.baker.internal.inter;

import org.github.baker.internal.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年10月20日
 * @modifytime:
 */
public interface UserInterface {
    public User selectById(Long id);

    List<User> selectAllUser();
}
