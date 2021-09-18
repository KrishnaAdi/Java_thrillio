package com.kadi.entities;

import com.kadi.constants.MovieGenre;
import com.kadi.managers.BookmarkManager;
import org.junit.Test;
import static org.junit.Assert.*;
public class MovieTest {

    @Test
    public void testIsKidFriendlyEligible() {
        // test 1
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane","",1941, new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.HORROR,8.5);
        boolean isKidFriendlyEligibility = movie.isKidFriendly();
        assertFalse("For Horror Genre - isKidfriendly should return false", isKidFriendlyEligibility);

        //test 2
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane","",1941, new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.THRILLERS,8.5);
        isKidFriendlyEligibility = movie.isKidFriendly();
        assertFalse("For Thriller Genre - isKidfriendly should return false", isKidFriendlyEligibility);
    }

}
