package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.models.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initializeOffers();
    List<OfferSummaryView> getAllOffers();
}
