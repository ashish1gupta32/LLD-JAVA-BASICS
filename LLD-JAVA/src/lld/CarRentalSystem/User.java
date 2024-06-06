package lld.CarRentalSystem;

public class User {
    private int userId;
    private String userName;
    private Location location;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return STR."User{userId=\{userId}, userName='\{userName}\{'\''}\{'}'}";
    }
}
