package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by craigshorrocks on 1/12/2017.
 */
@Entity
public class BuddyInfo {

    private String name;
    @Id private String phoneNumber;

    public BuddyInfo(){

    }

    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuddyInfo buddyInfo = (BuddyInfo) o;

        if (name != null ? !name.equals(buddyInfo.name) : buddyInfo.name != null) return false;
        return phoneNumber != null ? phoneNumber.equals(buddyInfo.phoneNumber) : buddyInfo.phoneNumber == null;
    }
}
