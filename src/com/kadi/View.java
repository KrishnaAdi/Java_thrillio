package com.kadi;

import com.kadi.constants.KidFriendlyStatus;
import com.kadi.constants.UserType;
import com.kadi.controllers.BookmarkController;
import com.kadi.entities.Bookmark;
import com.kadi.entities.User;
import com.kadi.partner.Shareable;

public class View {

    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n" + user.getEmail() + " is browsing items.");

        int bookmarkCount = 0;
        for(Bookmark[] bookmarkList: bookmarks){
            for(Bookmark bookmark: bookmarkList){
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isBookmarked = getBookmarkDecision();
                    if(isBookmarked){
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New Item Bookmarked -- " + bookmark);
                    }
                }

                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)){
                    //Marking as kid-friendly
                    if(bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision();

                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
                        }
                    }

                    //Sharing!!
                    if(bookmark instanceof Shareable && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)){
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user, bookmark);
                        }
                    }
                }
            }
        }
    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;
    }

    private static String getKidFriendlyStatusDecision() {
        final double temp = Math.random();
        if(temp < 0.4){
            return KidFriendlyStatus.APPROVED;
        }else if(temp >= 0.4 && temp < 0.8){
            return KidFriendlyStatus.REJECTED;
        }else {
            return KidFriendlyStatus.UNKNOWN;
        }
    }

    private static boolean getBookmarkDecision() {
        return Math.random() < 0.5 ? true : false;
    }
}
