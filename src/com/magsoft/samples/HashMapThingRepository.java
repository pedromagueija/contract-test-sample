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

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a {@link ThingRepository} using a HashMap.
 *
 * @author Pedro Magueija (pedromagueija@gmail.com)
 */
public class HashMapThingRepository implements ThingRepository {
    /**
     * The things store.
     */
    private final Map<ThingId, Thing> things = new HashMap<>();

    @Override
    public void save(Thing thing) {
        if (thing.id() != ThingId.empty)
            things.put(thing.id(), thing);
    }

    @Override
    public Thing findById(ThingId id) {
        if (things.containsKey(id))
            return things.get(id);
        else
            return Thing.empty;
    }

    @Override
    public void remove(ThingId id) {
        things.remove(id);
    }

    @Override
    public int count() {
        return things.values().size();
    }
}
