/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireProfile;

import java.util.List;

public interface TireProfileDao {
    void addProfile(TireProfile profile);
    void removeProfile(TireProfile profile);
    void updateProfile(TireProfile profile);

    TireProfile getProfileById(Long id);
    TireProfile getProfileByValue(String value);

    List<TireProfile> getProfiles();

    int getProfilesCount();

    void removeAll();
}
