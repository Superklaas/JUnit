package be.vdab.TutorialUdemyTests;

import be.vdab.TutorialUdemy.Book;
import be.vdab.TutorialUdemy.ExternalISBNDataService;
import be.vdab.TutorialUdemy.StockManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


public class StockManagerTest {

    @Test
    void createLocatorCodeWithValidISBN_StubTest() {

        ExternalISBNDataService databaseService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };
        ExternalISBNDataService webService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"John Steinbeck","Of mice and men");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);

        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        assertEquals("7396J4",locatorCode);

    }

    @Test
    void createLocatorCodeWithValidISBN_MockTest() {

        // creating mocks
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        // putting data in mock database
        when(databaseService.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // instantiate stock manager & give him database and web service
        StockManager stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // assertion
        assertEquals("7396J4",locatorCode);

    }

    @Test
    void ifBookInDatabase_DatabaseIsCalled() {

        // creating mocks
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        // putting data in mock database
        when(databaseService.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // instantiate stock manager & give him database and web service
        StockManager stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // verify that database is called but web service is not
        verify(databaseService).lookup("0140177396");
        verify(webService,never()).lookup(anyString());

    }

    @Test
    void ifBookNotInDatabase_WebServiceIsCalled() {

        // instantiate mocks
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        // putting data in mocks
        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // instantiate stock manager & give him database and web service
        StockManager stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // verify that database and web service are called
        verify(databaseService).lookup("0140177396");
        verify(webService).lookup("0140177396");

    }

}
