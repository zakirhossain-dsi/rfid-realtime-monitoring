package com.tng.rfid.web;

import com.tng.rfid.entity.DingTalkSender;
import com.tng.rfid.repository.DingTalkSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/dingTalkSender")
public class DingTalkSenderController {

    @Autowired
    private DingTalkSenderRepository dingTalkSenderRepository;

    @PostMapping(path="")
    public @ResponseBody List<DingTalkSender> addNewDingTalkSenders(@RequestBody List<DingTalkSender> DingTalkSenders) {
        List<DingTalkSender> result = new ArrayList<>();
        dingTalkSenderRepository.saveAll(DingTalkSenders)
                .forEach(result::add);
        return result;
    }

    @PutMapping(path="")
    public @ResponseBody List<DingTalkSender> updateDingTalkSenders (@RequestBody List<DingTalkSender> DingTalkSenders) {
        List<DingTalkSender> result = new ArrayList<>();
        dingTalkSenderRepository.saveAll(DingTalkSenders)
                .forEach(result::add);
        return result;
    }

    @GetMapping(path="")
    public @ResponseBody List<DingTalkSender> getDingTalkSenders () {
        List<DingTalkSender> result = new ArrayList<>();
        dingTalkSenderRepository.findAll()
                .forEach(result::add);
        return result;
    }

    @DeleteMapping(path="")
    public @ResponseBody void deleteDingTalkSenders(List<Integer> ids) {
        dingTalkSenderRepository.deleteAllById(ids);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteDingTalkSenderById(@PathVariable Integer id) {
        dingTalkSenderRepository.deleteById(id);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody DingTalkSender getDingTalkSenderById(@PathVariable Integer id) {
        return dingTalkSenderRepository.findById(id)
                .orElse(null);
    }
}
