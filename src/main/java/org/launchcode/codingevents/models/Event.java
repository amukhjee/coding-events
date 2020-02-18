package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Place is required")
    @NotNull(message="Place can not be null")
    private String place;

    @AssertTrue(message="attendee must register")
    private boolean attendeeRegistration;

    @Min(value=1, message="Number of Attendee should be atleast 1")
    private Integer numberOfAttendee;


    public Event(String name, String description, String contactEmail, String Place, boolean attendeeRegistration, Integer numberOfAttendee) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.place=place;
        this.attendeeRegistration=attendeeRegistration;
        this.numberOfAttendee=numberOfAttendee;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isAttendeeRegistration() {
        return attendeeRegistration;
    }

    public void setAttendeeRegistration(boolean attendeeRegistration) {
        this.attendeeRegistration = attendeeRegistration;
    }

    public Integer getNumberOfAttendee() {
        return numberOfAttendee;
    }

    public void setNumberOfAttendee(Integer numberOfAttendee) {
        this.numberOfAttendee = numberOfAttendee;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
