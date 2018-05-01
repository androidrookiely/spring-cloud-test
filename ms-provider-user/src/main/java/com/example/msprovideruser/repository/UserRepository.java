package com.example.msprovideruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.common.Entity.User;

/**
 *创建者:liyang【loken.li@mail.dealmoon.com】
 *创建时间:2018/4/30  下午9:21
 *描述:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}