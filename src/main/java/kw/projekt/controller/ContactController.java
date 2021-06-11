package kw.projekt.controller;

import kw.projekt.model.contact.view_model.ContactForm;
import kw.projekt.service.contact.WantToContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    @Autowired
    private WantToContactService wantToContactService;


    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String addWantToContact(
            @ModelAttribute("contactForm") @Validated ContactForm contactForm,
            BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return "contact";

        wantToContactService.save(contactForm);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/contact";
    }
}
