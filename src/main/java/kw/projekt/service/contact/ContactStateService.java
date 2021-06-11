package kw.projekt.service.contact;

import kw.projekt.model.contact.ContactState;

public interface ContactStateService {

    ContactState getOrCreateState(String stateName);
}