package com.pos.app.repository;

import com.pos.app.model.core.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 4/13/2018.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    /** Get User by user name and password. */
    User findByUserNameAndUserPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    User findByUserName(@Param("userName") String userName);

    User findByUserNameOrEmail(@Param("userName") String userName, @Param("email") String email);

    List<User> findByUserNameIn(List<String> userNames);

}
