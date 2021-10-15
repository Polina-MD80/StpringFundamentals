package softuni.bg.mobilelele.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.Offer;
import softuni.bg.mobilelele.models.enums.Engine;
import softuni.bg.mobilelele.models.enums.Transmission;
import softuni.bg.mobilelele.models.service.OfferUpdateServiceModel;
import softuni.bg.mobilelele.models.view.OfferDetailsView;
import softuni.bg.mobilelele.models.view.OfferSummaryView;
import softuni.bg.mobilelele.repository.ModelRepository;
import softuni.bg.mobilelele.repository.OfferRepository;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.OfferService;
import softuni.bg.mobilelele.web.exeption.ObjectNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeOffers() {
        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            offer1
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(Engine.GASOLINE)
                    .setTransmission(Transmission.MANUAL)
                    .setMileage(22500)
                    .setPrice(14300)
                    .setYear(2019)
                    .setDescription("Used, but well services and in good condition.")
                    .setSeller(userRepository.findByUsername("pesho")
                            .orElse(null)) // or currentUser.getUserName()
                    .setImageUrl(
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXp1KBpDKgYs6VqndkBpX8twjPOZbHV86yg&usqp=CAU");


            Offer offer2 = new Offer();
            offer2
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(Engine.DIESEL)
                    .setTransmission(Transmission.AUTOMATIC)
                    .setMileage(209000)
                    .setPrice(55000)
                    .setYear(2000)
                    .setDescription("After full maintenance, insurance, new tires...")
                    .setSeller(userRepository.findByUsername("admin")
                            .orElse(null)) // or currentUser.getUserName()
                    .setImageUrl(
                            "https://www.picclickimg.com/d/l400/pict/283362908243_/FORD-ESCORT-MK5-16L-DOHC-16v-ZETEC.jpg");


            offerRepository.saveAll(List.of(offer1, offer2));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {

        return offerRepository.findAll().stream()
                .map(this::mapToSummary)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findOfferById(Long id) {
        Offer offer = offerRepository.getById(id);
        OfferDetailsView detailsView = modelMapper.map(offer, OfferDetailsView.class);
        detailsView.setBrand(offer.getModel().getBrand().getName())
                .setModel(offer.getModel().getName())
                .setSellerFullName(String.format("%s %s", offer.getSeller().getFirstName(),
                        offer.getSeller().getLastName()));

        return detailsView;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void offerUpdate(OfferUpdateServiceModel offerModel)  {
        Offer offerEntity =
                offerRepository.findById(offerModel.getId())
                        .orElseThrow(()->new ObjectNotFoundException("Offer with id " + offerModel.getId() +
                                "does not exist"));

        assert offerEntity != null;
        offerEntity.setPrice(offerModel.getPrice())
                .setDescription(offerModel.getDescription())
                .setEngine(offerModel.getEngine())
                .setImageUrl(offerModel.getImageUrl())
                .setMileage(offerModel.getMileage())
                .setTransmission(offerModel.getTransmission())
                .setYear(offerModel.getYear());

        offerRepository.save(offerEntity);
    }

    private OfferSummaryView mapToSummary(Offer offer) {
        OfferSummaryView summaryView = this.modelMapper
                .map(offer, OfferSummaryView.class);

        summaryView.setModel(offer.getModel().getName());
        summaryView.setBrand(offer.getModel().getBrand().getName());


        return summaryView;
    }
}
