package com.model;

import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author implements Comparable<Author> {

@SerializedName("LastName")
@Expose
private String lastName;
@SerializedName("ForeName")
@Expose
private String foreName;
@SerializedName("Initials")
@Expose
private String initials;

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getForeName() {
return foreName;
}

public void setForeName(String foreName) {
this.foreName = foreName;
}

public String getInitials() {
return initials;
}

public void setInitials(String initials) {
this.initials = initials;
}

@Override
public String toString(){
	return foreName + " " + lastName + " " + initials;
}

@Override
public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Author)) {
        return false;
    }

    Author user = (Author) o;

    return user.getForeName().equals(foreName) &&
            user.getLastName().equals(lastName) &&
            user.getInitials().equals(initials);
}

@Override
public int hashCode() {
    return Objects.hash(foreName,lastName,initials);
}

@Override
public int compareTo(Author other) {
	int last = this.foreName.compareTo(other.foreName);
    return last == 0 ? this.lastName.compareTo(other.lastName) : last;
}

}