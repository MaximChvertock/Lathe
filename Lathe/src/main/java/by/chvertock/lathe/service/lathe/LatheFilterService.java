/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.lathe;

import by.chvertock.lathe.model.beans.lathe.LatheFilter;
import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.model.entities.lathe.Lathe;
import by.chvertock.lathe.service.tire.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LatheFilterService {

    @Autowired
    private LatheService latheService;

    public LatheFilter newFilter() {
        LatheFilter filter = new LatheFilter();

//        filter.setTireWidths(latheService.getWidths());

        filter.setMinPrice(latheService.getMinPrice());
        filter.setMaxPrice(latheService.getMaxPrice());

        return filter;
    }

    public void clearFilter(LatheFilter filter) {
        filter.clearBrands();
//        filter.clearTypes();
//        filter.clearWidths();
//        filter.clearProfiles();
//        filter.clearDiameters();

        filter.setMinPrice(latheService.getMinPrice());
        filter.setMaxPrice(latheService.getMaxPrice());

//        filter.setInStock(false);
    }
}
