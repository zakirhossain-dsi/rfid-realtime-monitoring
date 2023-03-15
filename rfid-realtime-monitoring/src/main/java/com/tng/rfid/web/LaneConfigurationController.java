package com.tng.rfid.web;

import com.tng.rfid.entity.LaneConfiguration;
import com.tng.rfid.repository.LaneConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/laneConfiguration")
public class LaneConfigurationController {

    @Autowired
    private LaneConfigurationRepository laneConfigurationRepository;

    @PostMapping(path="")
    public @ResponseBody List<LaneConfiguration> addNewLaneConfigurations(@RequestBody List<LaneConfiguration> laneConfigurations) {
        List<LaneConfiguration> result = new ArrayList<>();
        laneConfigurationRepository.saveAll(laneConfigurations)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<LaneConfiguration> updateLaneConfigurations (@RequestBody List<LaneConfiguration> laneConfigurations) {
        List<LaneConfiguration> result = new ArrayList<>();
        laneConfigurationRepository.saveAll(laneConfigurations)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<LaneConfiguration> getLaneConfigurations () {
        List<LaneConfiguration> result = new ArrayList<>();
        laneConfigurationRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody LaneConfiguration getLaneById(@PathVariable Integer id) {
        return laneConfigurationRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteLaneById(@PathVariable Integer id) {
        laneConfigurationRepository.deleteById(id);
    }
}
