/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;

import by.chvertock.lathe.excel.XLSPictureHolder;
import by.chvertock.lathe.excel.exceptions.ExcelException;
import by.chvertock.lathe.model.entities.tire.*;
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
public class TireFromFileService {

    private static final int BRAND_CELL = 0; //    Производитель
    private static final int MODEL_NAME_CELL = 1; //    Номер/код по производителю
    private static final int TYPE_CELL = 2; //            Тип
    private static final int WIDTH_CELL = 3; //    Ширина
    private static final int PROFILE_CELL = 4; //    Высота профиля
    private static final int DIAMETER_CELL = 5; //    Диаметр
    private static final int PRICE_CELL = 6; //            Цена
    private static final int IN_STOCK_CELL = 7; //    Количество в наличии
    private static final int DESCRIPTION_CELL = 8; //            Описание
    private static final int IMAGE_CELL = 9; //    Изображение

    @Value("${content.images.directory}")
    private String imagesDir;

    public Tire getTire(File file) {
        try {

            Tire tire = new Tire();

            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); //get only first sheet

            if (sheet == null) {
                throw new ExcelException("Sheet is null");
            }

            // save all pictures from document in content folder
            XLSPictureHolder pictureHolder = new XLSPictureHolder((HSSFSheet) sheet, new File(imagesDir), null);

            int rowIndex = 0;
            final int cellIndex = 1;
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(cellIndex);

                switch (rowIndex) {
                    case BRAND_CELL:
                        String brandName = cell.toString();
                        tire.setBrand(new TireBrand(brandName));
                        break;
                    case MODEL_NAME_CELL:
                        String name = cell.toString();
                        tire.setName(name);
                        break;
                    case TYPE_CELL:
                        String typeName = cell.toString();
                        tire.setType(new TireType(typeName));
                        break;
                    case WIDTH_CELL:
                        String widthValue = cell.toString();
                        tire.setWidth(new TireWidth(widthValue));
                        break;
                    case PROFILE_CELL:
                        String profileValue = cell.toString();
                        tire.setProfile(new TireProfile(profileValue));
                        break;
                    case DIAMETER_CELL:
                        String diameterValue = cell.toString();
                        tire.setDiameter(new TireDiameter(diameterValue));
                        break;
                    case PRICE_CELL:
                        try {
                            BigDecimal price = new BigDecimal(cell.getNumericCellValue());
                            tire.setPrice(price);
                        } catch (NumberFormatException e) {
                            throw new ExcelException("Wrong format of 'price' cell '" + cell.toString() + "'", e);
                        }
                        break;
                    case IN_STOCK_CELL:
                        try {
                            Integer inStock = (int) cell.getNumericCellValue();
                            tire.setInStock(inStock);
                        } catch (NumberFormatException e) {
                            throw new ExcelException("Wrong format of 'in stock' cell '" + cell.toString() + "'", e);
                        }
                        break;
                    case DESCRIPTION_CELL:
                        String description = cell.toString();
                        tire.setDescription(description);
                        break;
                    case IMAGE_CELL:
                        XLSPictureHolder.CellPosition cellPosition =
                                new XLSPictureHolder.CellPosition(rowIndex, cellIndex);
                        XLSPictureHolder.CellImage cellImage = pictureHolder.getImage(cellPosition);
                        if (cellImage != null) {
                            String fileName = cellImage.getFileName();
                            tire.setImage(new TireImage(fileName));
                        }
                        break;
                }

                ++rowIndex;
            }


            return tire;
        } catch (IOException e) {
            throw new ExcelException("Can't open file '" + file.getName() + "'");
        } catch (InvalidFormatException e) {
            throw new ExcelException("Wrong file format '" + file.getName() + "'");
        }
    }
}
