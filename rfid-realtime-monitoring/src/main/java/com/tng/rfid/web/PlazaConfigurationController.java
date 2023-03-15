package com.tng.rfid.web;

import com.tng.rfid.entity.PlazaConfiguration;
import com.tng.rfid.repository.PlazaConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/plazaConfiguration")
public class PlazaConfigurationController {

    @Autowired
    private PlazaConfigurationRepository plazaConfigurationRepository;

    @PostMapping(path="")
    public @ResponseBody List<PlazaConfiguration> addNewPlazaConfigurations(@RequestBody List<PlazaConfiguration> plazaConfigurations) {
        List<PlazaConfiguration> result = new ArrayList<>();
        plazaConfigurationRepository.saveAll(plazaConfigurations)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<PlazaConfiguration> updatePlazaConfigurations (@RequestBody List<PlazaConfiguration> plazaConfigurations) {
        List<PlazaConfiguration> result = new ArrayList<>();
        plazaConfigurationRepository.saveAll(plazaConfigurations)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<PlazaConfiguration> getPlazaConfigurations () {
        List<PlazaConfiguration> result = new ArrayList<>();
        plazaConfigurationRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody PlazaConfiguration getPlazaById(@PathVariable Integer id) {
        return plazaConfigurationRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deletePlazaById(@PathVariable Integer id) {
        plazaConfigurationRepository.deleteById(id);
    }
}
