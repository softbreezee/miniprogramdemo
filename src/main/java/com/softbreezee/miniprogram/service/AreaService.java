package com.softbreezee.miniprogram.service;

import com.softbreezee.miniprogram.dao.AreaDao;
import com.softbreezee.miniprogram.entity.Area;
import com.softbreezee.miniprogram.exception.AreaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaDao areaDao;

    /**
     * 获取所有
     */
   public List<Area> getAreaList() {
        return areaDao.findAll();
    }

    /**
     * 通过id获取
     */
    public Area getAreaById(Integer id) {
        return areaDao.findById(id).get();
    }

    /**
     * 增加区域信息
     * 涉及增、删、查较为复杂的操作要加事物控制
     * 事物管理回滚默认的是runtimeException，因此这里改为exception
     * @param area
     * @return
     * @throws Exception
     */
    @Transactional(rollbackOn = Exception.class)
    public boolean addArea(Area area) throws Exception {
        if(area == null&&"".equals(area.getAreaName()))
            throw new AreaException("传入的地区是错误");
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        Area a = areaDao.save(area);
        if (a == null)
            return false;
        return true;
    }

    /**
     *
     * @param area
     * @return
     */
    public boolean updateArea(Area area)  {
        if(area == null&&"".equals(area.getAreaName())) {
            try {
                throw new AreaException("传入的地区是错误");
            } catch (AreaException e) {
                e.printStackTrace();
            }
        }
        area.setLastEditTime(new Date());
        Area a = areaDao.save(area);
        if (a == null)
            return false;
        return true;
    }

    /**
     * 删除
     * @param id
     */
    public void deleteArea(Integer id) {
       areaDao.deleteById(id);
    }

}
