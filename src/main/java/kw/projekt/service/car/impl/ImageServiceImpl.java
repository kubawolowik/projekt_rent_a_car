package kw.projekt.service.car.impl;

import kw.projekt.model.car.repository.ImageRepository;
import kw.projekt.service.car.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
}
