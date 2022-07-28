package com.laioffer.staybooking.repository;

import com.laioffer.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> { //操作的数据类型是User class; String是User这个class的primary key的类型

}
