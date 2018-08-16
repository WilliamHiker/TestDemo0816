package com.toocms.www.testdemoforwzw;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int userId;
    private String userName;
    private boolean isMale;

    public Book book;

    public User(int userId,String userName,boolean isMale){
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(userName);
        parcel.writeInt((isMale ? 1 : 0));
        parcel.writeParcelable(book,0);
    }
}
