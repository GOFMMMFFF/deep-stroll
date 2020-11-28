package ap.deepstroll.controller;

import ap.deepstroll.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/api/admin/log")
    @PreAuthorize("admin")
    public Map<String,Object> scanLog(@RequestBody HashMap<String,Integer> page){
        return logService.getLogByPage(page);
    }
}
