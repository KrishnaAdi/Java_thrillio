package com.kadi.dao;

import com.kadi.DataStore;
import com.kadi.entities.Bookmark;
import com.kadi.entities.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
