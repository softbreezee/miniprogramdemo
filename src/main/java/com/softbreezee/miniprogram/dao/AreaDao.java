package com.softbreezee.miniprogram.dao;

import com.softbreezee.miniprogram.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao extends JpaRepository<Area,Integer> {

}
