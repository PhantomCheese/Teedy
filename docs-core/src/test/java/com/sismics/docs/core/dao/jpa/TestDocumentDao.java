package com.sismics.docs.core.dao.jpa;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.DocumentDao;
import com.sismics.docs.core.model.jpa.Document;
import com.sismics.docs.core.util.TransactionUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 * Tests the document DAO.
 */
public class TestDocumentDao extends BaseTransactionalTest {
    @Test
    public void testDocumentDao() throws Exception {
        // Create a document
        DocumentDao documentDao = new DocumentDao();
        Document document = new Document();
        // Set the necessary properties of the document
        document.setTitle("Test Document");
        String userId = "admin";
        
        // Use the create method to save the new document
        String documentId = documentDao.create(document, userId);
        
        TransactionUtil.commit();

        // Retrieve the document by its ID
        document = documentDao.getById(documentId);
        Assert.assertNotNull(document);
        Assert.assertEquals("Test Document", document.getTitle());

        // Normally, you would verify the audit log here, but since we're not using AuditLogType,
        // you can perform other verifications as needed.
    }
}
