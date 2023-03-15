package com.tng.rfid.web;

import com.tng.rfid.entity.EscalationPlan;
import com.tng.rfid.repository.EscalationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/escalationPlan")
public class EscalationPlanController {

    @Autowired
    private EscalationPlanRepository escalationPlanRepository;

    @PostMapping(path="")
    public @ResponseBody List<EscalationPlan> addNewEscalationPlans(@RequestBody List<EscalationPlan> EscalationPlans) {
        List<EscalationPlan> result = new ArrayList<>();
        escalationPlanRepository.saveAll(EscalationPlans)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<EscalationPlan> updateEscalationPlans (@RequestBody List<EscalationPlan> EscalationPlans) {
        List<EscalationPlan> result = new ArrayList<>();
        escalationPlanRepository.saveAll(EscalationPlans)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<EscalationPlan> getEscalationPlans () {
        List<EscalationPlan> result = new ArrayList<>();
        escalationPlanRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody EscalationPlan getEscalationPlanById(@PathVariable Integer id) {
        return escalationPlanRepository.findById(id)
                .orElse(null);
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteEscalationPlanById(@PathVariable Integer id) {
        escalationPlanRepository.deleteById(id);
    }
}
