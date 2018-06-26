package com.softbreezee.miniprogram.service;

import com.softbreezee.miniprogram.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    AreaService areaService;

    @Test
    @Ignore
    public void getAreaList() {
        List<Area> list = areaService.getAreaList();
        assertEquals(2,list.size());
    }

    @Test
    @Ignore
    public void getAreaById() {
        Area a = areaService.getAreaById(10);
        assertEquals("西苑",a.getAreaName());
    }

    @Test
    public void addArea() throws Exception{
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("西苑");
        area.setPriority(1);
        boolean flag = areaService.addArea(area);
        assertEquals(true,flag);

    }

    @Test
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("东苑");
        area.setPriority(2);
        areaService.updateArea(area);
    }

    @Test
    public void deleteArea() {
        areaService.deleteArea(11);
    }
}