package be.kdg.groeph.model;


import be.kdg.groeph.model.Null.NullTrip;
import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Trip implements Nullable, Serializable {

    private int id;

    private String title;

    private String description;

    private Date startTime;

    private Date endTime;

    private boolean isPublic;


    private List<Label> labels = new ArrayList<Label>();

    //@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private TripType tripType;

    private TripUser tripUser;

    private List<TripUser> tripUsers = new ArrayList<TripUser>();

    /*@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id", nullable = true)
    private List<TripUser> confirmedTripUsers = new ArrayList<TripUser>();  */


    private List<Cost> costs = new ArrayList<Cost>();


    private List<Waypoint> waypoints = new ArrayList<Waypoint>();


    public Trip() {
    }

    public Trip(String title, String description, Date startTime, Date endTime, List<Label> labels, TripType tripType, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.labels = labels;
        this.tripType = tripType;
        this.isPublic = isPublic;
    }

    public Trip(String title, String description, Date startTime, Date endTime, List<Label> labels, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.labels = labels;
        this.isPublic = isPublic;
    }

    public Trip(String title, String description, Date startTime, Date endTime, TripType tripType, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripType = tripType;
        this.isPublic = isPublic;
    }

    public void addLabel(Label label) {
        label.setTrip(this);
        labels.add(label);
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public static Trip INVALID_TRIP() {
        return new NullTrip();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TripUser> getTripUsers() {
        return tripUsers;
    }

    public void setTripUsers(List<TripUser> tripUsers) {
        this.tripUsers = tripUsers;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TripUser getTripUser() {
        return tripUser;
    }

    public void setTripUser(TripUser tripUser) {
        this.tripUser = tripUser;
    }

    public void addTripUser(TripUser tripUser) {
        tripUsers.add(tripUser);
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
        waypoint.setTrip(this);
    }

    /*
    public List<TripUser> getConfirmedTripUsers() {

        return confirmedTripUsers;
    }

    public void setConfirmedTripUsers(List<TripUser> confirmedTripUsers) {
        this.confirmedTripUsers = confirmedTripUsers;
    }

    public void addConfirmedUser(TripUser user){
        confirmedTripUsers.add(user);
        tripUsers.remove(user);
    }
    */

    @Override
    public String toString() {


       // DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());



        return "START: " + sdf.format(startTime) + " END: " + sdf.format(endTime) + " TITLE: " + title;
    }
}
