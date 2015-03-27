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
 * Represents a thing that can be stored and is identified by a {@link ThingId}.
 *
 * @author Pedro Magueija (pedromagueija@gmail.com)
 */
public class Thing {
    /**
     * Represents an empty thing. This should be used instead of null.
     */
    public final static Thing empty = new Thing(ThingId.empty);

    /**
     * The id of the thing.
     */
    private final ThingId thingId;

    /**
     * Constructs a new Thing with the given {@link ThingId}.
     *
     * @param thingId The id to use with the thing.
     */
    private Thing(ThingId thingId) {
        this.thingId = thingId;
    }

    /**
     * Creates a new Thing with the given id.
     *
     * @param id The id to use with the thing.
     * @return A new Thing identified by the given id.
     */
    public static Thing create(String id) {
        return new Thing(new ThingId(id));
    }

    /**
     * Get the {@link ThingId} that identifies this thing.
     *
     * @return The id of the thing.
     */
    public ThingId id() {
        return thingId;
    }
}
