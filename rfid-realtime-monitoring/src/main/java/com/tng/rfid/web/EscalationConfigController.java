package com.tng.rfid.web;

import com.tng.rfid.entity.EscalationConfig;
import com.tng.rfid.repository.EscalationConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/escalationConfig")
public class EscalationConfigController {

    @Autowired
    private EscalationConfigRepository escalationConfigRepository;

    @PostMapping(path="")
    public @ResponseBody List<EscalationConfig> addNewEscalationConfigs(@RequestBody List<EscalationConfig> escalationConfigs) {
        List<EscalationConfig> result = new ArrayList<>();
        escalationConfigRepository.saveAll(escalationConfigs)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<EscalationConfig> updateEscalationConfigs (@RequestBody List<EscalationConfig> escalationConfigs) {
        List<EscalationConfig> result = new ArrayList<>();
        escalationConfigRepository.saveAll(escalationConfigs)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<EscalationConfig> getEscalationConfigs () {
        List<EscalationConfig> result = new ArrayList<>();
        escalationConfigRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody EscalationConfig getEscalationPlanById(@PathVariable Integer id) {
        return escalationConfigRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteEscalationPlanById(@PathVariable Integer id) {
        escalationConfigRepository.deleteById(id);
    }
}
