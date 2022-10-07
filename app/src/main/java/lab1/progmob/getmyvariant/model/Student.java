package lab1.progmob.getmyvariant.model;

import static android.text.TextUtils.isEmpty;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class Student implements Parcelable {
    public static final List<String> GROUPS = Arrays.asList("KI-161", "KI-162", "KI-163", "KIт-181", "МРАп-191");
    public static final int MAX_VARIANT = 20;

    private String firstName;
    private String lastName;
    private String group;

    public Student(String firstName, String lastName,
                   String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public boolean isValid() {
        return !isEmpty(firstName)
                && !isEmpty(lastName)
                && !isEmpty(group);
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    // --- auto-generated

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(group);
    }

    protected Student(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        group = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
