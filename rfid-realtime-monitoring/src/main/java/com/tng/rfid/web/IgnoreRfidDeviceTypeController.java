package com.tng.rfid.web;

import com.tng.rfid.entity.IgnoreRfidDeviceType;
import com.tng.rfid.repository.IgnoreRfidDeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/ignoreRfidDeviceType")
public class IgnoreRfidDeviceTypeController {

    @Autowired
    private IgnoreRfidDeviceTypeRepository ignoreRfidDeviceTypeRepository;

    @PostMapping(path="")
    public @ResponseBody List<IgnoreRfidDeviceType> addNewIgnoreRfidDeviceTypes(@RequestBody List<IgnoreRfidDeviceType> IgnoreRfidDeviceTypes) {
        List<IgnoreRfidDeviceType> result = new ArrayList<>();
        ignoreRfidDeviceTypeRepository.saveAll(IgnoreRfidDeviceTypes)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<IgnoreRfidDeviceType> updateIgnoreRfidDeviceTypes (@RequestBody List<IgnoreRfidDeviceType> IgnoreRfidDeviceTypes) {
        List<IgnoreRfidDeviceType> result = new ArrayList<>();
        ignoreRfidDeviceTypeRepository.saveAll(IgnoreRfidDeviceTypes)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<IgnoreRfidDeviceType> getIgnoreRfidDeviceTypes () {
        List<IgnoreRfidDeviceType> result = new ArrayList<>();
        ignoreRfidDeviceTypeRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody IgnoreRfidDeviceType getIgnoreRfidDeviceTypeById(@PathVariable Integer id) {
        return ignoreRfidDeviceTypeRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteIgnoreRfidDeviceTypeById(@PathVariable Integer id) {
        ignoreRfidDeviceTypeRepository.deleteById(id);
    }
}
