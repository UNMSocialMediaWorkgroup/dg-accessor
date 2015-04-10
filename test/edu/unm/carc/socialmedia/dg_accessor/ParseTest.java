package edu.unm.carc.socialmedia.dg_accessor;

import junit.framework.TestSuite;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Sixstring982
 * @since 4/12/2015
 */
public class ParseTest extends TestSuite {

    @Test
    public void testUnfilteredRecords() throws Exception {
        Query q = new Query();
        q.execute();
    }

    @Test
    public void testFilteredRecords() throws Exception {
        String ownerString = "6862819220458bcaab625a5d8038b748";

        List<String> filters = new ArrayList<>();
        filters.add(Filter.Owner.create(ownerString));

        List<Record> records = new Query(filters).execute();
        assertTrue(records.size() > 0);

        for (Record r : records) {
            assertEquals(ownerString, r.owner);
        }
    }

    @Test
    public void testLatLongWindowFilter() throws Exception {
        double minLat = 33.44056;
        double maxLat = 33.44065;
        double minLon = -112.06600;
        double maxLon = -112.06540;

        List<String> filters = new ArrayList<>();
        filters.add(Filter.MinLat.create(minLat));
        filters.add(Filter.MaxLat.create(maxLat));
        filters.add(Filter.MinLon.create(minLon));
        filters.add(Filter.MaxLon.create(maxLon));

        List<Record> records = new Query(filters).execute();
        assertTrue(records.size() > 0);

        for (Record r : records) {
            assertTrue(r.latitude >= minLat);
            assertTrue(r.latitude <= maxLat);
            assertTrue(r.longitude >= minLon);
            assertTrue(r.longitude <= maxLon);
        }
    }

    @Test
    public void testTimeFilter() throws Exception {
        long minTime = 1426036017000L;
        long maxTime = 1426036046000L;

        List<String> filters = new ArrayList<>();
        filters.add(Filter.MinTime.create(minTime));
        filters.add(Filter.MaxTime.create(maxTime));

        List<Record> records = new Query(filters).execute();
        assertTrue(records.size() > 0);

        for (Record r : records) {
            assertTrue(r.time >= minTime);
            assertTrue(r.time <= maxTime);
        }
    }
}
