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
 * The id of a {@link Thing}. This object is immutable.
 *
 * @author Pedro Magueija (pedromagueija@gmail.com)
 */
public class ThingId {

    /**
     * Represents an empty id. This should be used instead of null.
     */
    public final static ThingId empty = new ThingId("");

    /**
     * The id of the {@link Thing}.
     */
    private final String id;

    /**
     * Constructs a new ThingId with the given id.
     *
     * @param id The id to use.
     */
    public ThingId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        ThingId other = (ThingId) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
