package com.dachshundcompany.devops.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.dachshundcompany.devops.domain.Tool;
import com.dachshundcompany.devops.service.ToolService;
import com.dachshundcompany.devops.web.dto.ToolDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/devops/tool")
public class DevopsRestController {

    ToolService toolService;

    @Autowired
    public DevopsRestController(ToolService toolService) {
        this.toolService = toolService;
    }

    protected DevopsRestController() {

    }

    @RequestMapping("/hello")
    public String sayHello() {

        return "Hello World!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTool(@RequestBody ToolDto toolDto) {

        toolService.createTool(toolDto.getName(), toolDto.getProvider());

    }

    /**
     * 
     * @return
     */
    @GetMapping
    public List<Tool> getTools() {
        List result = new ArrayList<Tool>();
        toolService.findAll().forEach(result::add);
        return result;
    }
}
