package by.chvertock.lathe.web.controllers.lathe;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.entities.lathe.Lathe;
import by.chvertock.lathe.service.UploadFileService;
import by.chvertock.lathe.service.lathe.LatheService;
import by.chvertock.lathe.service.tire.LatheFromFileService;
import by.chvertock.lathe.web.controllers.tire.AddTireFromFileController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
public class AddLatheFromFileController {

	private static final Logger logger = Logger.getLogger(AddTireFromFileController.class);

	@Autowired
	private UploadFileService uploadFileService;

	@Autowired
	private LatheFromFileService latheFromFileService;

	@Autowired
	private LatheService latheService;


	@RequestMapping(value = "admin/lathe/add-lathe-from-file")
	public ModelAndView upload(
			@RequestParam("file") MultipartFile file
	) {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/lathe");

		try {
			System.out.println("lathe");
			File latheFile = uploadFileService.uploadExcelFileToTemp(file);

			Lathe lathe = latheFromFileService.getLathe(latheFile);

			System.out.println(lathe);


			// TODO : prevent duplicates
			latheService.saveOrUpdateLathe(lathe);
//			latheService.addLathe(lathe);
		} catch (ApplicationException e) {
			logger.error("Can't add lathe from file", e);
		}

		return modelAndView;
	}
}
