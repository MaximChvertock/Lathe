/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.excel;

import by.chvertock.lathe.util.StringUtils;
import org.apache.poi.ddf.*;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/*
* Updated in 04.04.2016
* */
public class XLSPictureHolder {

	private Set<ImageName> imageNames = new HashSet<ImageName>();

	private Map<CellPosition, CellImage> pictures = new HashMap<CellPosition, CellImage>();

	private File imageDir;

	private String imageNameTemplate;

	public XLSPictureHolder(HSSFSheet sheet, File imageDir, String imageNameTemplate) throws IOException {
		this.imageDir = imageDir;
		this.imageNameTemplate = imageNameTemplate;

		// Fix crash on first startup
		if (!this.imageDir.exists()) {
			this.imageDir.mkdirs();
		}

		initImageNames(sheet);

		initPictures(sheet);
	}

	private void initImageNames(HSSFSheet sheet) throws UnsupportedEncodingException {
		EscherAggregate drawingEscherAggregate = sheet.getDrawingEscherAggregate();
		EscherContainerRecord escherContainerRecord;
		try {
			escherContainerRecord = (EscherContainerRecord) drawingEscherAggregate.getEscherRecords().get(0);
		} catch (NullPointerException e) {
			return;// TODO : need testing
		}

		for (EscherContainerRecord container : escherContainerRecord.getChildContainers()) {
			List<EscherRecord> escherOptRecords = new ArrayList<EscherRecord>();
			container.getRecordsById(EscherOptRecord.RECORD_ID, escherOptRecords);
			for (EscherRecord record : escherOptRecords) {
				parseRecord((EscherOptRecord) record);
			}
		}
	}

	private void initPictures(HSSFSheet sheet) throws IOException {
		HSSFPatriarch drawingPatriarch = sheet.getDrawingPatriarch();

		List<HSSFShape> children;
		try {
			children = drawingPatriarch.getChildren();
		} catch (NullPointerException e) {
			return;
		}

		for (HSSFShape shape : children) {
			if (shape instanceof HSSFPicture) {
				HSSFPicture picture = (HSSFPicture) shape;

				HSSFClientAnchor anchor = picture.getPreferredSize();

				int col = anchor.getCol1();
				int row = anchor.getRow1();

				CellPosition position = new CellPosition(row, col);
				CellImage image = new CellImage(picture);
				pictures.put(position, image);

//                logger.error("Found picture");
			}
		}
	}

	private void parseRecord(EscherOptRecord record) throws UnsupportedEncodingException {
		List<EscherProperty> escherProperties = record.getEscherProperties();

		String name = null;
		Integer index = null;

		for (EscherProperty property : escherProperties) {

			if (property.isComplex()) {
				EscherComplexProperty complexProperty = (EscherComplexProperty) property;

				name = new String(complexProperty.getComplexData(), "UTF-16LE");
			} else {
				EscherSimpleProperty simpleProperty = (EscherSimpleProperty) property;

				if (simpleProperty.isBlipId()) {
					index = simpleProperty.getPropertyValue();
				}
			}
		}

		if (index != null && name != null) {
			ImageName imageName = new ImageName(index, name);
			imageNames.add(imageName);
		}
	}

	public CellImage getImage(CellPosition position) {
		return pictures.get(position);
	}

	public Map<CellPosition, CellImage> getPictures() {
		return pictures;
	}

	private ImageName getImageName(int index) {
		ImageName imageName = new ImageName(index, null);

		for (ImageName name : imageNames) {
			if (name.equals(imageName)) {
				return name;
			}
		}

		return null;
	}

	// INNER CLASSES
	public static class CellPosition {
		private int row;
		private int col;

		public CellPosition(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			CellPosition that = (CellPosition) o;

			if (row != that.row) return false;
			return col == that.col;

		}

		@Override
		public int hashCode() {
			int result = row;
			result = 31 * result + col;
			return result;
		}

		@Override
		public String toString() {
			return "[" + row + ", " + col + "]";
		}
	}

	public class CellImage {
		private String generatedFileName;

		public CellImage(HSSFPicture picture) throws IOException {

			ImageName imageName = getImageName(picture.getPictureIndex());

			generatedFileName = imageNameTemplate + "_" + picture.getPictureIndex() + ".jpg";
			if (StringUtils.isBlank(imageNameTemplate)) {
				generatedFileName = imageName.fileName;
			}

			File fileImage = new File(imageDir.getAbsolutePath() + File.separator + generatedFileName);

			byte[] data = picture.getPictureData().getData();
			BufferedImage bufferedImage = getBufferedImage(data);
			ImageIO.write(bufferedImage, "jpg", fileImage);
		}

		private BufferedImage getBufferedImage(byte[] data) throws IOException {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

			BufferedImage bufferedImage = ImageIO.read(inputStream);

			inputStream.close();

			return bufferedImage;
		}

		public String getFileName() {
			return generatedFileName;
		}

		@Override
		public String toString() {
			return generatedFileName;
		}
	}

	private class ImageName {
		private int pictureIndex; // unique key
		private String name;
		private String fileName;

		public ImageName(int pictureIndex, String name) {
			this.pictureIndex = pictureIndex;
			this.name = name;

			fileName = UUID.randomUUID().toString() + ".jpg";
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			ImageName imageName = (ImageName) o;

			return pictureIndex == imageName.pictureIndex;

		}

		@Override
		public int hashCode() {
			return pictureIndex;
		}

		@Override
		public String toString() {
			return "ImageName{" +
					"pictureIndex=" + pictureIndex +
					", name='" + name + '\'' +
					", fileName='" + fileName + '\'' +
					'}';
		}
	}
}

