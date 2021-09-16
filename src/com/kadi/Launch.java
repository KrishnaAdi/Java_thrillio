package com.kadi;

import com.kadi.entities.Bookmark;
import com.kadi.entities.User;
import com.kadi.managers.BookmarkManager;
import com.kadi.managers.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading Data ...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        printUserData();
        printBookmarkData();
    }

    private static void printUserData(){
        for(User user: users){
            System.out.println(user);
        }
    }

    private static void printBookmarkData(){
        for(Bookmark[] bookmarkList: bookmarks){
            for(Bookmark bookmark: bookmarkList){
                System.out.println(bookmark);
            }
        }
    }

    public static void main(String[] args){
        loadData();
    }


}
