/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireImage;

import java.util.List;

public interface TireImageDao {
    void addImage(TireImage image);
    void removeImage(TireImage image);
    void updateImage(TireImage image);

    TireImage getImageById(Long id);
    TireImage getImageByFileName(String name);

    List<TireImage> getImages();

    int getImagesCount();

    void removeAll();
}
