package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.pathfinder.service.PictureService;
import softuni.bg.pathfinder.util.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final PictureService pictureService;

    public HomeController(CurrentUser currentUser, PictureService pictureService) {
        this.currentUser = currentUser;
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("pictures", pictureService.findAllPicturesUrls());
      return "index";
    }
}
