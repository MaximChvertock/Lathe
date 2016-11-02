/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;

import by.chvertock.lathe.excel.XLSPictureHolder;
import by.chvertock.lathe.excel.exceptions.ExcelException;
import by.chvertock.lathe.model.entities.common.Country;
import by.chvertock.lathe.model.entities.common.Image;
import by.chvertock.lathe.model.entities.lathe.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

@Component
public class LatheFromFileService {

	private static final int ID_CELL = 0; //	Product ID  (String)
	private static final int TYPE_CELL = 1; //	Тип станка  (String)
	private static final int TYPE_URL_CELL = 2; //	Type for URL (String)
	private static final int MODEL_CELL = 3; //	Модель станка (String)
	private static final int MODEL_URL_CELL = 4; //	Model for URL (String)
	private static final int MANUFACTURER_CELL = 5; //	Manufacturer/Производитель (String)
	private static final int MANUFACTURER_COUNTRY_CELL = 6; //	Страна производитель (String)
	private static final int CNC_CELL = 7; //	CNC / Система ЧПУ (String)
	private static final int CNC_FULL_CELL = 8; //	CNC Full/Система ЧПУ (полная) (String)
	private static final int PRODUCTION_YEAR_CELL = 9; //	Год производства
	private static final int CONDITION_CELL = 10; //	Состояние станка
	private static final int LOCATION_CELL = 11; //	Физическое нахождение станка(Machine location) (String)
	private static final int MAX_PROCESSING_DIAMETER_CELL = 12; //	Максимальный диаметр обработки, мм (int)
	private static final int PROCESSING_DIAMETER_CELL = 13; //	Диаметр обработки мм (int)
	private static final int SPINDLE_ROD_DIAMETER_CELL = 14; //	Диаметр проходка прутка в шпинделе, мм (String)
	private static final int MAX_PROCESSING_LENGTH_CELL = 15; //	Максимальная длинна обработки L, мм (int)
	private static final int X_AXIS_CELL = 16; //	Перемещение по оси - X (int)
	private static final int Y_AXIS_CELL = 17; //	Перемещение по оси - Y (int)
	private static final int Z_AXIS_CELL = 18; //	Перемещение по оси - Z (int)
	private static final int SPINDLE_ANGLE_SPEED_CELL = 19; //	Частота вращения шпинделя, об/мин  (int)
	private static final int SPINDLE_POWER_CELL = 20; //	Мощность шпинделя, kw  (String)
	private static final int SPINDLE_BORE_DIAMETER_CELL = 21; //	Диаметр отверстия в шпинделе, мм (String)
	private static final int COUNTER_SPINDLE_AVAIL_CELL = 22; //	Наличие контр-шпинделя  (String)
	private static final int COUNTER_SPINDLE_ANGLE_SPEED_CELL = 23; //	Частота вращения контр-шпинделя (int)
	private static final int TOOL_HOLDER_TYPE_CELL = 24; //	Тип крепления инструмента револьверной головки
	private static final int TOOLS_AMOUNT_CELL = 25; //	Кол-во инструментов  (String)
	private static final int DRIVING_TOOLS_AMOUNT_CELL = 26; //	- приводных, шт (String)
	private static final int NON_DRIVING_TOOLS_AMOUNT_CELL = 27; //	- неприводных, шт (String)
	private static final int TAILSTOCK_AVAIL_CELL = 28; //	Наличие задней бабки (String)
	private static final int POSITIONING_ACCURACY_CELL = 29; //	Точность позиционирования/re, мм (String)
	private static final int POSITIONING_ACCURACY_DEG_CELL = 30; //	Точность позиционирования (Ось С: ), град (String)
	private static final int SPINDLE_HOURS_CELL = 31; //	Наработка на шпинделе, ч (String)
	private static final int LATHE_HOURS_CELL = 32; //	Включение станка всего, ч (String)
	private static final int PRICE_CELL = 33; //	Цена станка (int)
	private static final int IMAGE_1_CELL = 34; //	Фото станка 1 (String)
	private static final int IMAGE_2_CELL = 35; //	Фото станка 2 (String)
	private static final int IMAGE_3_CELL = 36; //	Фото станка 3 (String)
	private static final int IMAGE_4_CELL = 37; //	Фото станка 4 (String)
	private static final int IMAGE_5_CELL = 38; //	Фото станка 5 (String)
	private static final int DESCRIPTION_CELL = 39; //	Описание  (String)


	@Value("${content.images.directory}")
	private String imagesDir;

	public Lathe getLathe(File file) {
		try {

			Lathe lathe = new Lathe();

			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0); //get only first sheet

			if (sheet == null) {
				throw new ExcelException("Sheet is null");
			}


			String imageNameTemplate = null;
			try {
				imageNameTemplate = sheet.getRow(4).getCell(1).toString();
			} catch (Exception ignore) {/*NOP*/}

			// save all pictures from document in content folder
			XLSPictureHolder pictureHolder = new XLSPictureHolder((HSSFSheet) sheet, new File(imagesDir), imageNameTemplate);

			System.out.println(pictureHolder.getPictures());

			XLSPictureHolder.CellImage cellImage = null;

			int rowIndex = 0;
			final int cellIndex = 1;
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell = row.getCell(cellIndex);

				XLSPictureHolder.CellPosition cellPosition =
						new XLSPictureHolder.CellPosition(rowIndex, cellIndex);

				switch (rowIndex) {
					case ID_CELL:
						String id = cell.toString();
						System.out.println(id);
						//
						break;
					case TYPE_CELL:
						String type = cell.toString();
						System.out.println(type);
						lathe.setType(new LatheType(type));
						break;
					case TYPE_URL_CELL:
						String typeUrl = cell.toString();
						System.out.println(typeUrl);
						//
						break;
					case MODEL_CELL:
						String model = cell.toString();
						System.out.println(model);
						lathe.setModel(model);
						break;
					case MODEL_URL_CELL:
						String modelUrl = cell.toString();
						System.out.println(modelUrl);
						//
						break;
					case MANUFACTURER_CELL:
						String manufacturer = cell.toString();
						System.out.println(manufacturer);
						lathe.setManufacturer(new LatheManufacturer(manufacturer));
						break;
					case MANUFACTURER_COUNTRY_CELL:
						String manufacturerCountry = cell.toString();
						System.out.println(manufacturerCountry);
						lathe.setManufacturerCountry(new LatheManufacturerCountry(manufacturerCountry));
						break;
					case CNC_CELL:
						String cnc = cell.toString();
						System.out.println(cnc);
						lathe.setComputerNumericalControl(new LatheComputerNumericalControl(cnc));
						break;
					case CNC_FULL_CELL:
						String cncFull = cell.toString();
						System.out.println(cncFull);
						//
						break;
					case PRODUCTION_YEAR_CELL:
						String productionYear = cell.toString();
						System.out.println(productionYear);
						lathe.setProductionYear(productionYear);
						break;
					case CONDITION_CELL:
						String condition = cell.toString();
						System.out.println(condition);
						lathe.setCondition(condition);
						break;
					case LOCATION_CELL:
						String location = cell.toString();
						System.out.println(location);
						lathe.setLocation(new Country(location));
						break;
					case MAX_PROCESSING_DIAMETER_CELL:
						String maxProcessingDiameter = cell.toString();
						System.out.println(maxProcessingDiameter);
						try {
							lathe.setMaxProcessingDiameter(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'MAX_PROCESSING_DIAMETER' cell '" + cell.toString() + "'", e);
						}
						break;
					case PROCESSING_DIAMETER_CELL:
						String processingDiameter = cell.toString();
						System.out.println(processingDiameter);
						try {
							lathe.setProcessingDiameter(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'PROCESSING_DIAMETER' cell '" + cell.toString() + "'", e);
						}
						break;
					case SPINDLE_ROD_DIAMETER_CELL:
						String spindleRodDiameter = cell.toString();
						System.out.println(spindleRodDiameter);
						lathe.setSpindleRodDiameter(spindleRodDiameter);
						break;
					case MAX_PROCESSING_LENGTH_CELL:
						String maxProcessingLength = cell.toString();
						System.out.println(maxProcessingLength);
						try {
							lathe.setMaxProcessingLength(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'MAX_PROCESSING_LENGTH' cell '" + cell.toString() + "'", e);
						}
						break;
					case X_AXIS_CELL:
						String xAxis = cell.toString();
						System.out.println(xAxis);
						try {
							lathe.setxAxis(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'X_AXIS' cell '" + cell.toString() + "'", e);
						}
						break;
					case Y_AXIS_CELL:
						String yAxis = cell.toString();
						System.out.println(yAxis);
						try {
							lathe.setyAxis(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'Y_AXIS' cell '" + cell.toString() + "'", e);
						}
						break;
					case Z_AXIS_CELL:
						String zAxis = cell.toString();
						System.out.println(zAxis);
						try {
							lathe.setzAxis(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'X_AXIS' cell '" + cell.toString() + "'", e);
						}
						break;
					case SPINDLE_ANGLE_SPEED_CELL:
						String spindleAngleSpeed = cell.toString();
						System.out.println(spindleAngleSpeed);
						try {
							lathe.setSpindleAngleSpeed(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'SPINDLE_ANGLE_SPEED' cell '" + cell.toString() + "'", e);
						}
						break;
					case SPINDLE_POWER_CELL:
						String spindlePower = cell.toString();
						System.out.println(spindlePower);
						lathe.setSpindlePower(spindlePower);
						break;
					case SPINDLE_BORE_DIAMETER_CELL:
						String spindleBoreDiameter = cell.toString();
						System.out.println(spindleBoreDiameter);
						lathe.setSpindleBoreDiameter(spindleBoreDiameter);
						break;
					case COUNTER_SPINDLE_AVAIL_CELL:
						String counterSpindleAvailable = cell.toString();
						System.out.println(counterSpindleAvailable);
						lathe.setCounterSpindleAvailable(counterSpindleAvailable);
						break;
					case COUNTER_SPINDLE_ANGLE_SPEED_CELL:
						String counterSpindleAngleSpeed = cell.toString();
						System.out.println(counterSpindleAngleSpeed);
						try {
							lathe.setCounterSpindleAngleSpeed(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'COUNTER_SPINDLE_ANGLE_SPEED' cell '" + cell.toString() + "'", e);
						}
						break;
					case TOOL_HOLDER_TYPE_CELL:
						String toolHolderType = cell.toString();
						System.out.println(toolHolderType);
						lathe.setToolHolderType(new LatheToolHolderType(toolHolderType));
						break;
					case TOOLS_AMOUNT_CELL:
						String toolsAmount = cell.toString();
						System.out.println(toolsAmount);
						lathe.setToolsAmount(toolsAmount);
						break;
					case DRIVING_TOOLS_AMOUNT_CELL:
						String drivingToolsAmount = cell.toString();
						System.out.println(drivingToolsAmount);
						lathe.setDrivingToolsAmount(drivingToolsAmount);
						break;
					case NON_DRIVING_TOOLS_AMOUNT_CELL:
						String nonDrivingToolsAmount = cell.toString();
						System.out.println(nonDrivingToolsAmount);
						lathe.setNonDrivingToolsAmount(nonDrivingToolsAmount);
						break;
					case TAILSTOCK_AVAIL_CELL:
						String tailStockAvailable = cell.toString();
						System.out.println(tailStockAvailable);
						lathe.setTailStockAvailable(tailStockAvailable);
						break;
					case POSITIONING_ACCURACY_CELL:
						String positioningAccuracy = cell.toString();
						System.out.println(positioningAccuracy);
						lathe.setPositioningAccuracy(positioningAccuracy);
						break;
					case POSITIONING_ACCURACY_DEG_CELL:
						String positioningAccuracyDeg = cell.toString();
						System.out.println(positioningAccuracyDeg);
						lathe.setPositioningAccuracyInDegrees(positioningAccuracyDeg);
						break;
					case SPINDLE_HOURS_CELL:
						String spindleHours = cell.toString();
						System.out.println(spindleHours);
						try {
							lathe.setSpindleHours(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'SPINDLE_HOURS' cell '" + cell.toString() + "'", e);
						}
						break;
					case LATHE_HOURS_CELL:
						String latheHours = cell.toString();
						System.out.println(latheHours);
						try {
							lathe.setLatheHours(Integer.valueOf(cell.toString()));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'LATHE_HOURS' cell '" + cell.toString() + "'", e);
						}
						break;
					case PRICE_CELL:
						String price = cell.toString();
						System.out.println(price);
						try {
							lathe.setPrice(new BigDecimal(Integer.valueOf(cell.toString())));
						} catch (NumberFormatException e) {
							throw new ExcelException("Wrong format of 'PRICE' cell '" + cell.toString() + "'", e);
						}
						break;
					case IMAGE_1_CELL:
						String image1 = cell.toString();
						System.out.println(image1);
						cellImage = pictureHolder.getImage(cellPosition);
						if (cellImage != null) {
							lathe.getImages().add(new Image(cellImage.getFileName()));
						}
						break;
					case IMAGE_2_CELL:
						String image2 = cell.toString();
						System.out.println(image2);
						cellImage = pictureHolder.getImage(cellPosition);
						if (cellImage != null) {
							lathe.getImages().add(new Image(cellImage.getFileName()));
						}
						break;
					case IMAGE_3_CELL:
						String image3 = cell.toString();
						System.out.println(image3);
						cellImage = pictureHolder.getImage(cellPosition);
						if (cellImage != null) {
							lathe.getImages().add(new Image(cellImage.getFileName()));
						}
						break;
					case IMAGE_4_CELL:
						String image4 = cell.toString();
						System.out.println(image4);
						cellImage = pictureHolder.getImage(cellPosition);
						if (cellImage != null) {
							lathe.getImages().add(new Image(cellImage.getFileName()));
						}
						break;
					case IMAGE_5_CELL:
						String image5 = cell.toString();
						System.out.println(image5);
						cellImage = pictureHolder.getImage(cellPosition);
						if (cellImage != null) {
							lathe.getImages().add(new Image(cellImage.getFileName()));
						}
						break;
					case DESCRIPTION_CELL:
						String description = cell.toString();
						System.out.println(description);
						//
						break;


//                    case BRAND_CELL:
//                        String brandName = cell.toString();
//                        tire.setBrand(new TireBrand(brandName));
//                        break;
//                    case MODEL_NAME_CELL:
//                        String name = cell.toString();
//                        tire.setName(name);
//                        break;
//                    case TYPE_CELL:
//                        String typeName = cell.toString();
//                        tire.setType(new TireType(typeName));
//                        break;
//                    case WIDTH_CELL:
//                        String widthValue = cell.toString();
//                        tire.setWidth(new TireWidth(widthValue));
//                        break;
//                    case PROFILE_CELL:
//                        String profileValue = cell.toString();
//                        tire.setProfile(new TireProfile(profileValue));
//                        break;
//                    case DIAMETER_CELL:
//                        String diameterValue = cell.toString();
//                        tire.setDiameter(new TireDiameter(diameterValue));
//                        break;
//                    case PRICE_CELL:
//                        try {
//                            BigDecimal price = new BigDecimal(cell.getNumericCellValue());
//                            tire.setPrice(price);
//                        } catch (NumberFormatException e) {
//                            throw new ExcelException("Wrong format of 'price' cell '" + cell.toString() + "'", e);
//                        }
//                        break;
//                    case IN_STOCK_CELL:
//                        try {
//                            Integer inStock = (int) cell.getNumericCellValue();
//                            tire.setInStock(inStock);
//                        } catch (NumberFormatException e) {
//                            throw new ExcelException("Wrong format of 'in stock' cell '" + cell.toString() + "'", e);
//                        }
//                        break;
//                    case DESCRIPTION_CELL:
//                        String description = cell.toString();
//                        tire.setDescription(description);
//                        break;
//                    case IMAGE_CELL:
//                        XLSPictureHolder.CellPosition cellPosition =
//                                new XLSPictureHolder.CellPosition(rowIndex, cellIndex);
//                        XLSPictureHolder.CellImage cellImage = pictureHolder.getImage(cellPosition);
//                        if (cellImage != null) {
//                            String fileName = cellImage.getFileName();
//                            tire.setImage(new TireImage(fileName));
//                        }
//                        break;
				}

				++rowIndex;
			}


			return lathe;
		} catch (IOException e) {
			throw new ExcelException("Can't open file '" + file.getName() + "'");
		} catch (InvalidFormatException e) {
			throw new ExcelException("Wrong file format '" + file.getName() + "'");
		}
	}
}
