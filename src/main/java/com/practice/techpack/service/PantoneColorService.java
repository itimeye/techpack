package com.practice.techpack.service;

import com.practice.techpack.entity.PantoneColor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PantoneColorService {
    List<PantoneColor> uploadPantoneColors() throws IOException;

}
