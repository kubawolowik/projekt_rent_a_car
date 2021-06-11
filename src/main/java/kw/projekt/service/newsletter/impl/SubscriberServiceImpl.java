package kw.projekt.service.newsletter.impl;

import kw.projekt.exception.NewsletterSubscriberAlreadyExistsException;
import kw.projekt.model.newsletter.Subscriber;
import kw.projekt.model.newsletter.repository.SubscriberRepository;
import kw.projekt.model.newsletter.view_model.NewsletterForm;
import kw.projekt.service.newsletter.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public void save(NewsletterForm newsletterForm) throws NewsletterSubscriberAlreadyExistsException {
        int sub = subscriberRepository.countByEmail(newsletterForm.getSubscriberEmail());
        if (sub == 0) {
            Subscriber subscriber = Subscriber.builder()
                    .name(newsletterForm.getSubscriberName())
                    .email(newsletterForm.getSubscriberEmail())
                    .isEnabled(true)
                    .build();
            subscriberRepository.save(subscriber);
        } else throw new NewsletterSubscriberAlreadyExistsException("Użytkownik istnieje.");
    }
}