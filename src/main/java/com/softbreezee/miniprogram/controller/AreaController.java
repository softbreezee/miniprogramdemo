package com.softbreezee.miniprogram.controller;

import com.softbreezee.miniprogram.entity.Area;
import com.softbreezee.miniprogram.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value ="/listarea" ,method =RequestMethod.GET )
    public Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @GetMapping("/getareabyid/{id}")
    public Map<String,Object> getAreaById(@PathVariable("id") Integer id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaById(id);
        modelMap.put("area",area);
        return modelMap;
    }

    @PostMapping("/addarea")
    public Map<String,Object> addArea(Area area) throws Exception {
        Map<String,Object> modelMap = new HashMap<String,Object>();
            modelMap.put("success",areaService.addArea(area));
            modelMap.put("name",area.getAreaName());
        return modelMap;
    }

    @PostMapping("/modifyarea")
    public Map<String,Object> modifyArea(Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }

    @GetMapping("/deletearea")
    public void addArea(@RequestParam Integer areaId){
        areaService.deleteArea(areaId);
    }


}
