package kw.projekt.controller;

import kw.projekt.exception.NewsletterSubscriberAlreadyExistsException;
import kw.projekt.model.newsletter.view_model.NewsletterForm;
import kw.projekt.service.car.CarService;
import kw.projekt.service.newsletter.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @Autowired
    private SubscriberService subscriberService;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("homePageCars", carService.getHomePageCars());
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("newsletterForm", new NewsletterForm());
        return "home-page";
    }

    @GetMapping("/newsletter")
    public String redirectToHomePage() {
        return "redirect:/";
    }

    @PostMapping("/newsletter")
    public String addNewSubscriber(
            @ModelAttribute("newsletterForm") @Validated NewsletterForm newsletterForm,
            BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors())
            return "home-page";

        try {
            subscriberService.save(newsletterForm);
        } catch (NewsletterSubscriberAlreadyExistsException e) {
            result.rejectValue("subscriberEmail", "error.newsletterForm", e.getMessage());
            return "home-page";
        }

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

}