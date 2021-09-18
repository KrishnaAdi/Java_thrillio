package com.kadi.entities;

import com.kadi.constants.BookGenre;
import com.kadi.managers.BookmarkManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testIsKidFriendlyEligible() {
        //test 1
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "",	1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendlyEligibility = book.isKidFriendly();
        assertFalse("For Philosophy Genre - isKidFriendly should return false", isKidFriendlyEligibility);

        //test 2
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "",	1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
        isKidFriendlyEligibility = book.isKidFriendly();
        assertFalse("For Self_help Genre - isKidFriendly should return false", isKidFriendlyEligibility);

    }
}
