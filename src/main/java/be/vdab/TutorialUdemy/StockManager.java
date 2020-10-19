package be.vdab.TutorialUdemy;

public class StockManager {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService databaseService;

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    // method to create locator code, given isbn
    public String createLocatorCode(String isbn) {

        // find book in database or web service
        Book book = databaseService.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }

        // create locator code with data book and isbn
        StringBuilder locatorCode = new StringBuilder();
        locatorCode.append(isbn.substring(isbn.length()-4));
        locatorCode.append(book.getAuthor().charAt(0));
        locatorCode.append(book.getTitle().split(" ").length);

        return locatorCode.toString();

    }


}
