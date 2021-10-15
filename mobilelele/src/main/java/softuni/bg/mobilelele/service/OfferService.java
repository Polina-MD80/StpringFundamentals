package softuni.bg.mobilelele.service;

import javassist.tools.rmi.ObjectNotFoundException;
import softuni.bg.mobilelele.models.entity.Offer;
import softuni.bg.mobilelele.models.service.OfferUpdateServiceModel;
import softuni.bg.mobilelele.models.view.OfferDetailsView;
import softuni.bg.mobilelele.models.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initializeOffers();
    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findOfferById(Long id);

    void deleteOffer(Long id);

    void offerUpdate(OfferUpdateServiceModel offerModel) throws ObjectNotFoundException;

}
