package kw.projekt.controller;

import kw.projekt.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/{imageId:.+}")
    @ResponseBody
    public Resource getRootImage(@PathVariable(name = "imageId") String imageId) {
        return storageService.loadAsResource(imageId);
    }

    @RequestMapping("/{folder}/{imageId:.+}")
    @ResponseBody
    public Resource getFolderImage(
            @PathVariable(name = "folder") String folder,
            @PathVariable(name = "imageId") String imageId) {
        return storageService.loadAsResource(folder + "/" + imageId);
    }

    @GetMapping("/upload")
    public String upload() {
        return "temp-file-upload";
    }

    @PostMapping("/upload")
    public String saveFiles(
            @RequestParam(name = "files") MultipartFile[] files,
            @RequestParam(name = "folder") String folder,
            RedirectAttributes redirectAttributes) {

        for (MultipartFile file : files)
            storageService.store(file, folder);

        redirectAttributes.addFlashAttribute("message", "Done!");
        return "redirect:/images/upload";
    }
}
