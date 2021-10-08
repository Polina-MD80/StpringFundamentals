package softuni.bg.mobilelele.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.view.OfferSummaryView;
import softuni.bg.mobilelele.repository.OfferRepository;
import softuni.bg.mobilelele.service.OfferService;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void initializeOffers() {
//TODO
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        //TODO
        return null;
    }
}
