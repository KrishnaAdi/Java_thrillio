package com.kadi.dao;

import com.kadi.DataStore;
import com.kadi.entities.Bookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
}
