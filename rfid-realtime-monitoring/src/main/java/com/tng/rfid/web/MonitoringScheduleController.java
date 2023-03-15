package com.tng.rfid.web;

import com.tng.rfid.entity.MonitoringSchedule;
import com.tng.rfid.repository.MonitoringScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/monitoringSchedule")
public class MonitoringScheduleController {

    @Autowired
    private MonitoringScheduleRepository monitoringScheduleRepository;

    @PostMapping(path="")
    public @ResponseBody List<MonitoringSchedule> addNewMonitoringSchedules(@RequestBody List<MonitoringSchedule> MonitoringSchedules) {
        List<MonitoringSchedule> result = new ArrayList<>();
        monitoringScheduleRepository.saveAll(MonitoringSchedules)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<MonitoringSchedule> updateMonitoringSchedules (@RequestBody List<MonitoringSchedule> MonitoringSchedules) {
        List<MonitoringSchedule> result = new ArrayList<>();
        monitoringScheduleRepository.saveAll(MonitoringSchedules)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<MonitoringSchedule> getMonitoringSchedules () {
        List<MonitoringSchedule> result = new ArrayList<>();
        monitoringScheduleRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteMonitoringSchedules(List<Integer> ids) {
        monitoringScheduleRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteMonitoringScheduleById(@PathVariable Integer id) {
        monitoringScheduleRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody MonitoringSchedule getMonitoringScheduleById(@PathVariable Integer id) {
        MonitoringSchedule ms = monitoringScheduleRepository.findById(id)
                .orElse(null);

        return ms;
    }
}
