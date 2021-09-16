package com.kadi.controllers;

import com.kadi.entities.Bookmark;
import com.kadi.entities.User;
import com.kadi.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();

    private BookmarkController() {}
    public static BookmarkController getInstance(){
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }
}
