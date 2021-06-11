package kw.projekt.service.contact.impl;

import kw.projekt.model.contact.ContactState;
import kw.projekt.model.contact.repository.ContactStateRepository;
import kw.projekt.service.contact.ContactStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactStateServiceImpl implements ContactStateService {

    @Autowired
    private ContactStateRepository contactStateRepository;

    @Override
    public ContactState getOrCreateState(String stateName) {
        ContactState contactState = contactStateRepository.getStateByStateName(stateName);
        if (contactState == null) {
            contactState = ContactState.builder().stateName(stateName).build();
            contactStateRepository.save(contactState);
        }
        return contactState;
    }
}