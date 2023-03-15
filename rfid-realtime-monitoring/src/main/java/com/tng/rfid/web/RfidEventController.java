package com.tng.rfid.web;

import com.tng.rfid.entity.RfidEvent;
import com.tng.rfid.repository.RfidEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/rfidEvent")
public class RfidEventController {

    @Autowired
    private RfidEventRepository rfidEventRepository;

    @PostMapping(path="")
    public @ResponseBody List<RfidEvent> addNewRfidEvents(@RequestBody List<RfidEvent> RfidEvents) {
        List<RfidEvent> result = new ArrayList<>();
        rfidEventRepository.saveAll(RfidEvents)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<RfidEvent> updateRfidEvents (@RequestBody List<RfidEvent> RfidEvents) {
        List<RfidEvent> result = new ArrayList<>();
        rfidEventRepository.saveAll(RfidEvents)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<RfidEvent> getRfidEvents () {
        List<RfidEvent> result = new ArrayList<>();
        rfidEventRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody RfidEvent getRfidEventById(@PathVariable Integer id) {
        return rfidEventRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteRfidEventById(@PathVariable Integer id) {
        rfidEventRepository.deleteById(id);
    }
}
