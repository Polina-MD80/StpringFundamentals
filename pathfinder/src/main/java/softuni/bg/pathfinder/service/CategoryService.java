package softuni.bg.pathfinder.service;

import softuni.bg.pathfinder.model.entity.Category;
import softuni.bg.pathfinder.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    Category findByName(CategoryNameEnum category);
}
