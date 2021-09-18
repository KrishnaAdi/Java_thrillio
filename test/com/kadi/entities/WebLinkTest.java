package com.kadi.entities;

import com.kadi.managers.BookmarkManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class WebLinkTest {

    @Test
    public void testIsKidFriendlyEligible() {
//        porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com", "unknown");
        boolean isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For porn in url - isKidFriendly() must return false", isKidFriendlyEligible);

//        porn in title -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com", "unknown");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For porn in title - isKidFriendly() must return false", isKidFriendlyEligible);

//        adult in host -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com", "adult");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For adult in host - isKidFriendly() must return false", isKidFriendlyEligible);

//        adult in url but not in host -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com", "unknown");
        isKidFriendlyEligible = webLink.isKidFriendly();
        System.out.println(isKidFriendlyEligible);
        assertTrue("For adult in url but not in host - isKidFriendly() must return true", isKidFriendlyEligible);

//        adult in title only -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com", "unknown");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertTrue("For adult in title only - isKidFriendly() must return true", isKidFriendlyEligible);
    }
}
