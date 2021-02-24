package com.dachshundcompany.devops.service;

import com.dachshundcompany.devops.domain.Tool;
import com.dachshundcompany.devops.repo.ToolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    private ToolRepository toolRepository;

    @Autowired
    public ToolService (ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    /**
     * 
     * @param name
     * @param provider
     * @return
     */
    public Tool createTool(String name, String provider) {
        return toolRepository.save(new Tool(name, provider));
    }

    /**
     * 
     * @return
     */
    public Iterable<Tool> findAll() {
        return toolRepository.findAll();
    }
}
