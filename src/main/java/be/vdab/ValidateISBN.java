package be.vdab;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        if (isbn.length() == 13) {
            return checkISBN13(isbn);
        } else if (isbn.length() == 10) {
            return checkISBN10(isbn);
        } else {
            throw new NumberFormatException("Length ISBN needs to be 10 or 13");
        }
    }

    private boolean checkISBN10(String isbn) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN needs to be numeric");
                }
            } else {
                total += (10-i)*Character.getNumericValue(isbn.charAt(i));
            }
        }
        return (total % 11 == 0);
    }

    private boolean checkISBN13(String isbn) {
        int total = 0;
        for (int i = 0; i < 13; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 12 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN needs to be numeric");
                }
            } else {
                if (i % 2 == 0) {
                    total += Character.getNumericValue(isbn.charAt(i));
                } else {
                    total += 3 * Character.getNumericValue(isbn.charAt(i));
                }
            }
        }
        return (total % 10 == 0);
    }

}
