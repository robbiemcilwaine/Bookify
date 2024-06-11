package com.example.Bookify.models;

public class UserDTO {

    private long bookshelvesId;
    private long usersBooksId;
    private String username;

    public UserDTO(long bookshelvesId, long usersBooksID, String userName) {
        this.bookshelvesId = bookshelvesId;
        this.usersBooksId = usersBooksID;
        this.username = userName;
    }

    public UserDTO() {
    }

    public long getBookshelvesId() {
        return bookshelvesId;
    }

    public void setBookshelvesId(long bookshelvesId) {
        this.bookshelvesId = bookshelvesId;
    }

    public long getUsersBooksId() {
        return usersBooksId;
    }

    public void setUsersBooksId(long usersBooksId) {
        this.usersBooksId = usersBooksId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
