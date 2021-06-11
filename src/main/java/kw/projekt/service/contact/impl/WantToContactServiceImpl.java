package kw.projekt.service.contact.impl;

import kw.projekt.model.contact.ContactState;
import kw.projekt.model.contact.WantToContact;
import kw.projekt.model.contact.repository.WantToContactRepository;
import kw.projekt.model.contact.view_model.ContactForm;
import kw.projekt.service.contact.ContactStateService;
import kw.projekt.service.contact.WantToContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WantToContactServiceImpl implements WantToContactService {

    @Autowired
    private WantToContactRepository wantToContactRepository;

    @Autowired
    private ContactStateService contactStateService;

    @Override
    public void save(ContactForm contactForm) {
        ContactState contactState = contactStateService.getOrCreateState("Unread");

        WantToContact wantToContact = WantToContact.builder()
                .firstName(contactForm.getFirstName())
                .lastName(contactForm.getLastName())
                .email(contactForm.getEmail())
                .phone(contactForm.getPhone())
                .message(contactForm.getMessage())
                .addDate(new Date())
                .state(contactState)
                .build();

        wantToContactRepository.save(wantToContact);
    }
}