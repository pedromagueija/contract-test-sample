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

import java.util.ArrayList;

/**
 * Implements a {@link ThingRepository} using an ArrayList.
 *
 * @author Pedro Magueija (pedromagueijga@gmail.com)
 */
public class ArrayListThingRepository implements ThingRepository {
    /**
     * The things store.
     */
    private final ArrayList<Thing> things = new ArrayList<>();

    @Override
    public void save(Thing thing) {
        if (thing.id() != ThingId.empty)
            things.add(thing);
    }

    @Override
    public Thing findById(ThingId id) {
        for (Thing thing : things) {
            if (thing.id().equals(id)) {
                return thing;
            }
        }

        return Thing.empty;
    }

    @Override
    public void remove(ThingId id) {
        Thing thing = findById(id);
        if (!thing.equals(Thing.empty)) {
            things.remove(thing);
        }
    }

    @Override
    public int count() {
        return things.size();
    }
}
