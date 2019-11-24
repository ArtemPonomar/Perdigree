package com.pedigree.service;

import com.pedigree.entity.pet_related.Color;
import com.pedigree.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;

    public Color getByColorName(String colorName) {
        List<Color> searchResult = colorRepository.findByColorNameIgnoreCaseOrderByColorNameAsc(colorName);
        if (searchResult.size() == 0) return null;
        return searchResult.get(0);
    }

    @Transactional
    public void saveColor(Color color){
        List<Color> dups = colorRepository.findByColorNameIgnoreCaseOrderByColorNameAsc(color.getColorName());
        if (dups.size() != 0) {
            color.setId(dups.get(0).getId());
        }
        colorRepository.save(color);
    }


}
