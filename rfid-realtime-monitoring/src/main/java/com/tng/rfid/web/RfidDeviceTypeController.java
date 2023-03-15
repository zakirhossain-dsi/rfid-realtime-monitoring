package com.tng.rfid.web;

import com.tng.rfid.entity.RfidDeviceType;
import com.tng.rfid.repository.RfidDeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/rfidDeviceType")
public class RfidDeviceTypeController {

    @Autowired
    private RfidDeviceTypeRepository rfidDeviceTypeRepository;

    @PostMapping(path="")
    public @ResponseBody List<RfidDeviceType> addNewRfidDeviceTypes(@RequestBody List<RfidDeviceType> rfidDeviceTypes) {
        List<RfidDeviceType> result = new ArrayList<>();
        rfidDeviceTypeRepository.saveAll(rfidDeviceTypes).forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<RfidDeviceType> updateRfidDeviceTypes (@RequestBody List<RfidDeviceType> rfidDeviceTypes) {
        List<RfidDeviceType> result = new ArrayList<>();
        rfidDeviceTypeRepository.saveAll(rfidDeviceTypes)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<RfidDeviceType> getRfidDeviceTypes () {
        List<RfidDeviceType> result = new ArrayList<>();
        rfidDeviceTypeRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteRfidDeviceTypes(List<Integer> ids) {
        rfidDeviceTypeRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteRfidDeviceTypeById(@PathVariable Integer id) {
        rfidDeviceTypeRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody RfidDeviceType getRfidDeviceTypeById(@PathVariable Integer id) {
        return rfidDeviceTypeRepository.findById(id)
                .orElse(null);
    }
}
