package softuni.bg.mobilelele.web;



import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.mobilelele.models.binding.OfferUpdateBindingModel;
import softuni.bg.mobilelele.models.enums.Engine;
import softuni.bg.mobilelele.models.enums.Transmission;
import softuni.bg.mobilelele.models.service.OfferUpdateServiceModel;
import softuni.bg.mobilelele.models.view.OfferDetailsView;
import softuni.bg.mobilelele.service.OfferService;

import javax.validation.Valid;

@Controller
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id, Model model) {
        model.addAttribute("offer", this.offerService.findOfferById(id));

        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String delete(@PathVariable Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model){
        OfferDetailsView offerDetailsView = offerService.findOfferById(id);
        OfferUpdateBindingModel bindingModel = modelMapper.map(offerDetailsView, OfferUpdateBindingModel.class);
        model.addAttribute("offerModel", bindingModel);
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());

        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            System.out.println("I am here");
            return "redirect:/offers/" + id + "/edit/errors";
        }


        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel, OfferUpdateServiceModel.class);
        serviceModel.setId(id);

        offerService.offerUpdate(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }

}
