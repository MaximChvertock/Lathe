/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.beans.tire.*;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.tire.*;
import by.chvertock.lathe.service.cart.CustomerCartService;
import by.chvertock.lathe.service.tire.*;
import by.chvertock.lathe.web.controllers.util.PaginationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@Controller
@SessionAttributes(
        value = {
                "newTire",
                "filter",
                "customerCart",
                "compareList"
        },
        types = {
                Tire.class,
                TireFilter.class,
                CustomerCart.class,
                TireCompareList.class
        }
)
public class ShowTireListController {

    private static final Logger logger = Logger.getLogger(ShowTireListController.class);

    private static final int PAGE_SIZE = 10;
    private static final int PAGE_RADIUS = 2;

    @Autowired
    private TireService tireService;

    @Autowired
    private TireBrandService brandService;

    @Autowired
    private TireTypeService typeService;

    @Autowired
    private TireImageService imageService;

    @Autowired
    private TireWidthService widthService;

    @Autowired
    private TireProfileService profileService;

    @Autowired
    private TireDiameterService diameterService;

    @Autowired
    private TireFilterService filterService;

    @Autowired
    private CustomerCartService cartService;

    @Autowired
    private TireBrandEditor brandEditor;
    @Autowired
    private TireTypeEditor typeEditor;
    @Autowired
    private TireImageEditor imageEditor;
    @Autowired
    private TireWidthEditor widthEditor;
    @Autowired
    private TireProfileEditor profileEditor;
    @Autowired
    private TireDiameterEditor diameterEditor;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(TireBrand.class, brandEditor);
        binder.registerCustomEditor(TireType.class, typeEditor);
        binder.registerCustomEditor(TireImage.class, imageEditor);
        binder.registerCustomEditor(TireWidth.class, widthEditor);
        binder.registerCustomEditor(TireProfile.class, profileEditor);
        binder.registerCustomEditor(TireDiameter.class, diameterEditor);
    }


    @RequestMapping(value = "/admin/tires")
    public ModelAndView showTiresListForAdmin(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Valid @ModelAttribute("filter") TireFilter filter, BindingResult result
    ) {
        ModelAndView modelAndView = new ModelAndView("admin/tire/TireListPage");

//        System.out.println("result: " + result); // DEBUG
//        System.out.println("filter: " + filter); // DEBUG

        try {
            prepareTireList(modelAndView, page, filter);
        } catch (DaoException e) {
            logger.error("Can't get tire list", e);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/shop/tires")
    public ModelAndView showTiresListForCustomer(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Valid @ModelAttribute("filter") TireFilter filter, BindingResult result
    ) {
        ModelAndView modelAndView = new ModelAndView("shop/tire/TireListPage");

//        System.out.println("result: " + result); // DEBUG
//        System.out.println("filter: " + filter); // DEBUG

        try {
            prepareTireList(modelAndView, page, filter);
        } catch (DaoException e) {
            logger.error("Can't get tire list", e);
        }

        return modelAndView;
    }

    private void prepareTireList(ModelAndView modelAndView, int page, TireFilter filter) {
        List<Tire> tireList = tireService.getTires(filter, new TireService.Page(page, PAGE_SIZE));

        int count = (int) tireService.getTireCount(filter);

        List<Integer> pageList = PaginationUtils.getPageList(page, PAGE_RADIUS, PAGE_SIZE, count);

        int lastPage = PaginationUtils.getLastPage(count, PAGE_SIZE);

        modelAndView.addObject("tireListForm", new TireListForm(tireList));
        modelAndView.addObject("pageList", pageList);
        modelAndView.addObject("activePage", page);
        modelAndView.addObject("lastPage", lastPage);
    }

    @ModelAttribute("newTire")
    private Tire getNewTire() {
        Tire tire = new Tire();

        tire.setPrice(BigDecimal.ZERO);
        tire.setInStock(0);

        tire.setName("DEFAULT_NAME");
        tire.setDescription("DEFAULT_DESCRIPTION");

        return tire;
    }

    @ModelAttribute("brandList")
    private List<TireBrand> getBrandList() {
        return brandService.getBrands();
    }

    @ModelAttribute("typeList")
    private List<TireType> getTypeList() {
        return typeService.getTypes();
    }

    @ModelAttribute("imageList")
    private List<TireImage> getImageList() {
        return imageService.getImages();
    }

    @ModelAttribute("widthList")
    private List<TireWidth> getWidthList() {
        return widthService.getWidths();
    }

    @ModelAttribute("profileList")
    private List<TireProfile> getProfileList() {
        return profileService.getProfiles();
    }

    @ModelAttribute("diameterList")
    private List<TireDiameter> getDiameterList() {
        return diameterService.getDiameters();
    }

    @ModelAttribute("filter")
    private TireFilter getFilter() {
        return filterService.newFilter();
    }

    @ModelAttribute("minPrice")
    private BigDecimal getMinPrice() {
        return tireService.getMinPrice();
    }

    @ModelAttribute("maxPrice")
    private BigDecimal getMaxPrice() {
        return tireService.getMaxPrice();
    }

    @ModelAttribute("compareList")
    private TireCompareList getCompareList() {
        return new TireCompareList();
    }
}
