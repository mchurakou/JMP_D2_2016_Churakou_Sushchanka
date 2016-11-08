package com.company.springmvc.interfaces;

import com.company.springmvc.model.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by alt-hanny on 07.11.2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
