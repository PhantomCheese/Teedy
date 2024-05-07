package com.sismics.docs.core.util;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.util.TransactionUtil;
import com.sismics.docs.core.util.jpa.PaginatedList;
import com.sismics.docs.core.util.jpa.PaginatedLists;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the PaginatedLists class.
 */
public class TestPaginatedLists extends BaseTransactionalTest {
    @Test
    public void testCreateMethod() throws Exception {
        // Test with null values
        PaginatedList<Object> defaultList = PaginatedLists.create(null, null);
        Assert.assertNotNull(defaultList);

        // Test with page size greater than MAX_PAGE_SIZE
        PaginatedList<Object> maxList = PaginatedLists.create(150, 10);
        Assert.assertNotNull(maxList);

        // Commit transaction if necessary
        TransactionUtil.commit();

        // Add more tests as needed
    }
}
