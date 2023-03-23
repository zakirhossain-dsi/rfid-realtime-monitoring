package com.tng.rfid.web;

import com.tng.rfid.entity.DeviceConfig;
import com.tng.rfid.repository.DeviceConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/deviceConfig")
public class DeviceConfigController {

    @Autowired
    private DeviceConfigRepository deviceConfigRepository;

    @PostMapping(path="")
    public @ResponseBody List<DeviceConfig> addNewDeviceConfigs(@RequestBody List<DeviceConfig> deviceConfigs) {
        List<DeviceConfig> result = new ArrayList<>();
        deviceConfigRepository.saveAll(deviceConfigs).forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<DeviceConfig> updateDeviceConfigs (@RequestBody List<DeviceConfig> deviceConfigs) {
        List<DeviceConfig> result = new ArrayList<>();
        deviceConfigRepository.saveAll(deviceConfigs)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<DeviceConfig> getDeviceConfigs () {
        List<DeviceConfig> result = new ArrayList<>();
        deviceConfigRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteDeviceConfigs(List<Integer> ids) {
        deviceConfigRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteDeviceConfigById(@PathVariable Integer id) {
        deviceConfigRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody DeviceConfig getDeviceConfigById(@PathVariable Integer id) {
        return deviceConfigRepository.findById(id)
                .orElse(null);
    }
}
