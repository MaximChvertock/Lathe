/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.common.Country;
import by.chvertock.lathe.model.entities.common.Image;
import by.chvertock.lathe.model.entities.lathe.*;
import by.chvertock.lathe.service.lathe.LatheService;
import by.chvertock.lathe.service.order.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Controller
@SessionAttributes(
		value = {
				"customerCart"
		},
		types = {
				CustomerCart.class
		}
)
public class TestController {

	@Autowired
	private LatheService latheService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@RequestMapping(value = "/test")
	public String test(
			@ModelAttribute("customerCart") CustomerCart customerCart
	) {

		Random random = new Random();

		for (int i = 0; i < 100; ++i) {
			Lathe lathe = new Lathe();

			lathe.setManufacturer(new LatheManufacturer("MANUFACTURER_" + random.nextInt(10)));
			lathe.setType(new LatheType("TYPE_" + random.nextInt(10)));
			lathe.setManufacturerCountry(new LatheManufacturerCountry("COUNTRY_" + random.nextInt(10)));
			lathe.setComputerNumericalControl(new LatheComputerNumericalControl("CNC_" + random.nextInt(10)));
			lathe.setLocation(new Country("COUNTRY_" + random.nextInt(10)));
			lathe.setModel("MODEL_" + i);
			lathe.setProductionYear("" + (2000 + random.nextInt(16)));
			lathe.setMaxProcessingDiameter(50 + random.nextInt(100));
			lathe.setProcessingDiameter(10 + random.nextInt(100));
			lathe.setSpindleRodDiameter("" + (40 + random.nextInt(10)));
			lathe.setToolHolderType(new LatheToolHolderType("THT_" + random.nextInt(10)));
			lathe.setMaxProcessingLength(1000 + random.nextInt(1000));
			lathe.setxAxis(random.nextInt(100));
			lathe.setyAxis(random.nextInt(100));
			lathe.setzAxis(random.nextInt(100));
			lathe.setSpindleAngleSpeed(100 + random.nextInt(1000));
			lathe.setSpindlePower("" + (100 + random.nextInt(100)));
			lathe.setSpindleBoreDiameter("" + (10 + random.nextInt(10)));
			lathe.setCounterSpindleAvailable((random.nextInt(1) == 0) ? "no" : "yes");
			lathe.setCounterSpindleAngleSpeed(100 + random.nextInt(1000));
			lathe.setToolsAmount("" + (10 + random.nextInt(10)));
			lathe.setDrivingToolsAmount("" + (10 + random.nextInt(10)));
			lathe.setNonDrivingToolsAmount("" + (10 + random.nextInt(10)));
			lathe.setTailStockAvailable((random.nextInt(1) == 0) ? "no" : "yes");
			lathe.setPositioningAccuracy("" + (10 + random.nextInt(10)));
			lathe.setPositioningAccuracyInDegrees("" + (10 + random.nextInt(10)));
			lathe.setSpindleHours(5000 + random.nextInt(5000));
			lathe.setLatheHours(5000 + random.nextInt(5000));
			lathe.setPrice(new BigDecimal(10000 + random.nextInt(10000)));
			lathe.setCondition("CONDITION_" + random.nextInt(5));

			Set<Image> images = new HashSet<>();
			for(int j = 0; j < 5; ++j){
				Image image = new Image();
				image.setFileName("IMAGE_"+random.nextInt());

				images.add(image);
			}
			lathe.setImages(images);

//			System.out.println(lathe);

			latheService.saveOrUpdateLathe(lathe);
		}
		System.out.println(latheService.getLathes().get(0));

		return "test";
	}
}

//class Test {
//    public static void main(String[] args) {
//
//        for (int i = 0; i < 100; ++i) {
//            System.out.println(GeneratorUtils.getUniqueId());
//        }
//    }
//}
