package com.tng.rfid.web;

import com.tng.rfid.entity.ContactConfig;
import com.tng.rfid.repository.DingTalkContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/dingTalkContact")
public class DingTalkContactController {

    @Autowired
    private DingTalkContactRepository dingTalkContactRepository;

    @PostMapping(path="")
    public @ResponseBody List<ContactConfig> addNewDingTalkContacts(@RequestBody List<ContactConfig> contactConfigs) {
        List<ContactConfig> result = new ArrayList<>();
        dingTalkContactRepository.saveAll(contactConfigs)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<ContactConfig> updateDingTalkContacts (@RequestBody List<ContactConfig> contactConfigs) {
        List<ContactConfig> result = new ArrayList<>();
        dingTalkContactRepository.saveAll(contactConfigs)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<ContactConfig> getDingTalkContacts () {
        List<ContactConfig> result = new ArrayList<>();
        dingTalkContactRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteDingTalkContacts(List<Integer> ids) {
        dingTalkContactRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteDingTalkContactById(@PathVariable Integer id) {
        dingTalkContactRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody ContactConfig getDingTalkContactById(@PathVariable Integer id) {
        return dingTalkContactRepository.findById(id)
                .orElse(null);
    }
}
