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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contract tests that all implementations of ThingRepository must pass.
 *
 * @author Pedro Magueija (pedromagueija@gmail.com)
 */
public abstract class ThingRepositoryContractTest {

    private ThingRepository repo;

    @Before
    public void setUp() throws Exception {
        repo = getConcreteRepository();
    }

    @Test
    public void storesThings() throws Exception {
        Thing thing = Thing.create("THING_ID");
        repo.save(thing);

        assertEquals(1, repo.count());
    }

    @Test
    public void storesOnlyIdentifiableThings() throws Exception {
        Thing empty = Thing.empty;
        repo.save(empty);

        assertEquals(0, repo.count());
    }

    @Test
    public void findsThings() throws Exception {
        repo.save(Thing.create("THING_ID"));
        repo.save(Thing.create("THING_ID2"));
        repo.save(Thing.create("THING_ID3"));

        Thing found = repo.findById(new ThingId("THING_ID"));

        assertEquals(new ThingId("THING_ID"), found.id());
    }

    @Test
    public void returnsEmptyWhenCantFindThing() throws Exception {
        repo.save(Thing.create("THING_ID"));
        repo.save(Thing.create("THING_ID2"));
        repo.save(Thing.create("THING_ID3"));

        Thing found = repo.findById(new ThingId("THING_ID4"));

        assertEquals(ThingId.empty, found.id());
    }

    @Test
    public void removesThings() throws Exception {
        repo.save(Thing.create("THING_ID"));

        repo.remove(new ThingId("THING_ID"));

        assertEquals(0, repo.count());
    }

    @Test
    public void removesTheIdentifiedThing() throws Exception {
        ThingId removedId = new ThingId("THING_ID");
        ThingId remainingId = new ThingId("THING_ID2");

        repo.save(Thing.create("THING_ID"));
        repo.save(Thing.create("THING_ID2"));

        repo.remove(removedId);

        Thing remainingThing = repo.findById(remainingId);

        assertEquals(1, repo.count());
        assertEquals(remainingId, remainingThing.id());
    }

    @Test
    public void ignoresRemovingOfThingsNotInTheStore() throws Exception {
        ThingId remainingId = new ThingId("THING_ID");
        ThingId unexistentId = new ThingId("THING_ID2");

        repo.save(Thing.create("THING_ID"));

        repo.remove(unexistentId);

        Thing remainingThing = repo.findById(remainingId);

        assertEquals(1, repo.count());
        assertEquals(remainingId, remainingThing.id());
    }

    /**
     * Gets a concrete repository implementation.
     *
     * @return The concrete repository to use in the tests.
     */
    public abstract ThingRepository getConcreteRepository();
}