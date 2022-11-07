package com.practice.techpack;

import com.practice.techpack.entity.PantoneColor;
import com.practice.techpack.repository.PantonceColorRepository;
import com.practice.techpack.service.PantoneColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    @Autowired
    private PantonceColorRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(repository.uploadToTable());
    }
}
