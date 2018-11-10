package models;

public class Bank {

    private String id;
    private String nationality;
    private boolean isBlacklisted;
    private int numOfRejections;

    public Bank(String id, String nationality) {
        this.id = id;
        this.nationality = nationality;
        this.isBlacklisted = false;
        this.numOfRejections = 0;
    }

    @Override
    public String toString() {
        return "Bank(" + this.id + ", " + this.nationality + ", " + this.isBlacklisted + ", " + this.numOfRejections + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getNationality() {
        return this.nationality;
    }

    public boolean isBlacklisted() {
        return this.isBlacklisted;
    }

    public void setBlacklisted(boolean isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    public int getNumOfRejections() {
        return this.numOfRejections;
    }

    public void setNumOfRejections(int numOfRejections) {
        this.numOfRejections = numOfRejections;
    }
}
