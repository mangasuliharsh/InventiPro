package com.inventipro.backend.services;

import com.inventipro.backend.dto.CategoryDTO;
import com.inventipro.backend.entities.CategoryEntity;
import com.inventipro.backend.exceptions.NoSuchResourceException;
import com.inventipro.backend.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);
        CategoryEntity savedEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(savedEntity, CategoryDTO.class);
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryEntities
                .stream()
                .map(entities -> modelMapper.map(entities,CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(int id) {
        isExistCategory(id);

        return modelMapper.map(categoryRepository.findById((long) id), CategoryDTO.class);
    }

    public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        isExistCategory(id);
        CategoryEntity  getEntity = categoryRepository.findById((long)id).get();
        modelMapper.map(categoryDTO, getEntity);
        CategoryEntity savedEntity = categoryRepository.save(getEntity);
        return modelMapper.map(savedEntity, CategoryDTO.class);
    }

    public CategoryDTO patchCategory(int id, @Valid Map<String, Object> map) {
        isExistCategory(id);
        CategoryEntity categoryEntity = categoryRepository.findById((long) id).get();

        map.forEach( (key, value) -> {
            Field field = ReflectionUtils.findField(categoryEntity.getClass(), key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, categoryEntity, value);
        });
        CategoryEntity savedEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(savedEntity, CategoryDTO.class);
    }

    public void deleteCategory(int id) {
        isExistCategory(id);
        categoryRepository.deleteById((long) id);
    }



    public boolean isExistCategory(int id) {
        boolean isExist = categoryRepository.existsById((long) id);

        if (!isExist) {
            throw new NoSuchResourceException("Category with id " + id + " does not exist");
        }

        return isExist;
    }

}
