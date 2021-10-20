package softuni.spring.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring.model.binding.AlbumBindingModel;
import softuni.spring.model.service.AlbumServiceModel;
import softuni.spring.service.AlbumService;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlumController {
   private final AlbumService albumService;
   private final ModelMapper modelMapper;

    public AlumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add")
    private String add(){
        return "add-album";
    }

    @ModelAttribute
    public AlbumBindingModel albumBindingModel(){
        return new AlbumBindingModel();
    }

    @PostMapping("add")
    public String confAdd(@Valid AlbumBindingModel albumBindingModel, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);

            return "redirect:add";
        }
        AlbumServiceModel albumServiceModel = modelMapper.map(albumBindingModel, AlbumServiceModel.class);

        albumService.addAlbum(albumServiceModel);


        return "redirect:/";


    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        albumService.delete(id);
        return "redirect:/";
    }

}
