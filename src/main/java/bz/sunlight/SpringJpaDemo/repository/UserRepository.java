package bz.sunlight.SpringJpaDemo.repository;


import bz.sunlight.SpringJpaDemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * UserRepository
 * Created by chen_yong on 2017/6/1.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    @Modifying
    @Query(value = "update User user set user.address = :address where user.id = :id ")
    void findByUpdateUser(@Param("id") int id,@Param("address") String address);
}
