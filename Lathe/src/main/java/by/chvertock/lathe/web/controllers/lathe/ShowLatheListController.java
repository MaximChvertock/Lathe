/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.lathe;


import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.beans.lathe.LatheFilter;
import by.chvertock.lathe.model.beans.lathe.LatheListForm;
import by.chvertock.lathe.model.entities.lathe.Lathe;
import by.chvertock.lathe.model.entities.lathe.LatheManufacturer;
import by.chvertock.lathe.service.lathe.LatheFilterService;
import by.chvertock.lathe.service.lathe.LatheManufacturerService;
import by.chvertock.lathe.service.lathe.LatheService;
import by.chvertock.lathe.web.controllers.util.PaginationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
@SessionAttributes(
		value = {
//                "newTire",
				"latheFilter",
//                "customerCart",
//                "compareList"
		},
		types = {
//                Tire.class,
				LatheFilter.class,
//                CustomerCart.class,
//                TireCompareList.class
		}
)

public class ShowLatheListController {

	private static final Logger logger = Logger.getLogger(ShowLatheListController.class);

	private static final int PAGE_SIZE = 10;
	private static final int PAGE_RADIUS = 2;

	@Autowired
	private LatheService latheService;

	//    @Autowired
//    private TireService tireService;
//
	@Autowired
	private LatheManufacturerService manufacturerService;
	//
//    @Autowired
//    private TireTypeService typeService;
//
//    @Autowired
//    private TireImageService imageService;
//
//    @Autowired
//    private TireWidthService widthService;
//
//    @Autowired
//    private TireProfileService profileService;
//
//    @Autowired
//    private TireDiameterService diameterService;
//
	@Autowired
	private LatheFilterService filterService;
//
//    @Autowired
//    private CustomerCartService cartService;
//
//    @Autowired
//    private TireBrandEditor brandEditor;
//    @Autowired
//    private TireTypeEditor typeEditor;
//    @Autowired
//    private TireImageEditor imageEditor;
//    @Autowired
//    private TireWidthEditor widthEditor;
//    @Autowired
//    private TireProfileEditor profileEditor;
//    @Autowired
//    private TireDiameterEditor diameterEditor;
//
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(TireBrand.class, brandEditor);
//        binder.registerCustomEditor(TireType.class, typeEditor);
//        binder.registerCustomEditor(TireImage.class, imageEditor);
//        binder.registerCustomEditor(TireWidth.class, widthEditor);
//        binder.registerCustomEditor(TireProfile.class, profileEditor);
//        binder.registerCustomEditor(TireDiameter.class, diameterEditor);
//    }


	@RequestMapping(value = "/admin/lathe")
	public ModelAndView showTiresListForAdmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@Valid @ModelAttribute("latheFilter") LatheFilter filter, BindingResult result
	) {
		ModelAndView modelAndView = new ModelAndView("admin/lathe/LatheListPage");

//        System.out.println("result: " + result); // DEBUG
//        System.out.println("filter: " + filter); // DEBUG

		try {
			prepareTireList(modelAndView, page, filter);
		} catch (ApplicationException e) {
			logger.error("Can't get lathe list", e);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/shop/lathe")
	public ModelAndView showTiresListForCustomer(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@Valid @ModelAttribute("latheFilter") LatheFilter latheFilter, BindingResult result
	) {
		ModelAndView modelAndView = new ModelAndView("shop/lathe/LatheListPage");

//        System.out.println("result: " + result); // DEBUG
//        System.out.println("filter: " + filter); // DEBUG

		try {
			prepareTireList(modelAndView, page, latheFilter);
		} catch (ApplicationException e) {
			logger.error("Can't get lathe list", e);
		}

		return modelAndView;
	}

	private void prepareTireList(ModelAndView modelAndView, int page, LatheFilter filter) {
		List<Lathe> latheList = latheService.getLathes(filter, new LatheService.Page(page, PAGE_SIZE));

		int count = (int) latheService.getLatheCount(filter);

		List<Integer> pageList = PaginationUtils.getPageList(page, PAGE_RADIUS, PAGE_SIZE, count);

		int lastPage = PaginationUtils.getLastPage(count, PAGE_SIZE);

		modelAndView.addObject("latheListForm", new LatheListForm(latheList));
		modelAndView.addObject("pageList", pageList);
		modelAndView.addObject("activePage", page);
		modelAndView.addObject("lastPage", lastPage);
	}

	//    @ModelAttribute("newTire")
//    private Tire getNewTire() {
//        Tire tire = new Tire();
//
//        tire.setPrice(BigDecimal.ZERO);
//        tire.setInStock(0);
//
//        tire.setName("DEFAULT_NAME");
//        tire.setDescription("DEFAULT_DESCRIPTION");
//
//        return tire;
//    }
//
	@ModelAttribute("manufacturerList")
	private List<LatheManufacturer> getManufacturerList() {
		return manufacturerService.getManufacturers();
	}

	//
//    @ModelAttribute("typeList")
//    private List<TireType> getTypeList() {
//        return typeService.getTypes();
//    }
//
//    @ModelAttribute("imageList")
//    private List<TireImage> getImageList() {
//        return imageService.getImages();
//    }
//
//    @ModelAttribute("widthList")
//    private List<TireWidth> getWidthList() {
//        return widthService.getWidths();
//    }
//
//    @ModelAttribute("profileList")
//    private List<TireProfile> getProfileList() {
//        return profileService.getProfiles();
//    }
//
//    @ModelAttribute("diameterList")
//    private List<TireDiameter> getDiameterList() {
//        return diameterService.getDiameters();
//    }
//
	@ModelAttribute("latheFilter")
	private LatheFilter getFilter() {
		return filterService.newFilter();
	}

	@ModelAttribute("minPrice")
	private BigDecimal getMinPrice() {
		return latheService.getMinPrice();
	}

	@ModelAttribute("maxPrice")
	private BigDecimal getMaxPrice() {
		return latheService.getMaxPrice();
	}
//
//    @ModelAttribute("compareList")
//    private TireCompareList getCompareList() {
//        return new TireCompareList();
//    }
}
