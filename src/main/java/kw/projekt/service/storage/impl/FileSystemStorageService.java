package kw.projekt.service.storage.impl;

import kw.projekt.exception.StorageException;
import kw.projekt.exception.StorageFileNotFoundException;
import kw.projekt.exception.StorageInvalidImageFormatException;
import kw.projekt.service.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path storageLocation = Paths.get("upload");

    @Override
    public void initStorage(Path location) {
        try {
            Files.createDirectories(location);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage: " + location.toString(), e);
        }
    }

    @Override
    public void store(MultipartFile file, String folder) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = storageLocation.resolve(Paths.get(folder));
        try {
            if (file.isEmpty())
                throw new StorageException("Failed to store empty file: " + fileName);

            if (fileName.contains("..")) //security check
                throw new StorageException("Cannot store file with relative path outside current directory: " + fileName);

            try (InputStream inputStream = file.getInputStream()) {
                if (ImageIO.read(inputStream) == null)
                    throw new StorageInvalidImageFormatException("Uploaded file is not an image: " + fileName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                this.initStorage(path);
                Files.copy(inputStream, path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file: " + fileName, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(storageLocation.toFile());
    }

    @Override
    public Path load(String fileName) {
        return storageLocation.resolve(fileName);
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try {
            Path file = load(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new StorageFileNotFoundException("Could not read file: " + fileName);

        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + fileName, e);
        }
    }


}