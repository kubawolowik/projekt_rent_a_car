package kw.projekt.service.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    void initStorage(Path location);

    void store(MultipartFile file, String carId);

    void deleteAll();

    Path load(String fileName);

    Resource loadAsResource(String fileName);
}