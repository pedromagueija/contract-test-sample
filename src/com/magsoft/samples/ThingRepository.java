/*
 * Copyright (c) 2015 Pedro Magueija (pedromagueija@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.magsoft.samples;

/**
 * Allows you to perform simple storing and retrieval of Things. It also provides a way to check how
 * many things are currently in the store.
 *
 * @author Pedro Magueija (pedromagueija@gmail.com)
 */
public interface ThingRepository {

    /**
     * Saves a {@link Thing} in the things store.
     *
     * @param thing The {@link Thing} to store (must have an {@link ThingId}).
     */
    void save(Thing thing);

    /**
     * Finds a {@link Thing} by it's id.
     *
     * @param id The id of the {@link Thing} to find.
     * @return Returns the {@link Thing} that matches the given id,
     * or Thing.empty when no {@link Thing} with the given id is found.
     */
    Thing findById(ThingId id);

    /**
     * Removes a {@link Thing} from the store.
     *
     * @param id The id of the {@link Thing} to remove.
     */
    void remove(ThingId id);

    /**
     * Counts how many {@link Thing} are in the store.
     *
     * @return The number of things in the store.
     */
    int count();
}
