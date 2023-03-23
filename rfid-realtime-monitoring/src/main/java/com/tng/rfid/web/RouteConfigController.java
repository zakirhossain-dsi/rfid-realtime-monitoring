package com.tng.rfid.web;

import com.tng.rfid.entity.RouteConfig;
import com.tng.rfid.repository.RouteConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/routeConfig")
public class RouteConfigController {

    @Autowired
    private RouteConfigRepository routeConfigRepository;

    @PostMapping(path="")
    public @ResponseBody List<RouteConfig> addNewRouteConfigs(@RequestBody List<RouteConfig> routeConfigs) {
        List<RouteConfig> result = new ArrayList<>();
        routeConfigRepository.saveAll(routeConfigs)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<RouteConfig> updateRouteConfigs (@RequestBody List<RouteConfig> routeConfigs) {
        List<RouteConfig> result = new ArrayList<>();
        routeConfigRepository.saveAll(routeConfigs)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<RouteConfig> getRouteConfigs () {
        List<RouteConfig> result = new ArrayList<>();
        routeConfigRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody RouteConfig getRouteConfigById(@PathVariable Integer id) {
        return routeConfigRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteRouteConfigById(@PathVariable Integer id) {
        routeConfigRepository.deleteById(id);
    }
}
