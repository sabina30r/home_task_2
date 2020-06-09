package ua.com.alevel.nix.experienceusingclass.data;

import java.util.List;

public class Author extends AbstractData<Author> {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "Author{" +
                "fullName='" + fullName + '}';
    }
}
