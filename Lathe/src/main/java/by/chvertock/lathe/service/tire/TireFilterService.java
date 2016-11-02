/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;

import by.chvertock.lathe.model.beans.tire.TireFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TireFilterService {

    @Autowired
    private TireService tireService;

    public TireFilter newFilter() {
        TireFilter filter = new TireFilter();

//        filter.setTireWidths(tireService.getWidths());

        filter.setMinPrice(tireService.getMinPrice());
        filter.setMaxPrice(tireService.getMaxPrice());

        return filter;
    }

    public void clearFilter(TireFilter filter) {
        filter.clearBrands();
        filter.clearTypes();
        filter.clearWidths();
        filter.clearProfiles();
        filter.clearDiameters();

        filter.setMinPrice(tireService.getMinPrice());
        filter.setMaxPrice(tireService.getMaxPrice());

        filter.setInStock(false);
    }
}
