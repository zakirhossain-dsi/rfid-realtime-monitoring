package com.tng.rfid.web;

import com.tng.rfid.entity.AlertConfig;
import com.tng.rfid.repository.AlertConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/alertConfig")
public class AlertConfigController {

    @Autowired
    private AlertConfigRepository alertConfigRepository;

    @PostMapping(path="")
    public @ResponseBody List<AlertConfig> addNewAlertConfigs(@RequestBody List<AlertConfig> alertConfigs) {
        List<AlertConfig> result = new ArrayList<>();
        alertConfigRepository.saveAll(alertConfigs)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<AlertConfig> updateAlertConfigs (@RequestBody List<AlertConfig> alertConfigs) {
        List<AlertConfig> result = new ArrayList<>();
        alertConfigRepository.saveAll(alertConfigs)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<AlertConfig> getAlertConfigs () {
        List<AlertConfig> result = new ArrayList<>();
        alertConfigRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteAlertConfigs(List<Integer> ids) {
        alertConfigRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteAlertConfigById(@PathVariable Integer id) {
        alertConfigRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody AlertConfig getAlertConfigById(@PathVariable Integer id) {
        AlertConfig ms = alertConfigRepository.findById(id)
                .orElse(null);

        return ms;
    }
}
