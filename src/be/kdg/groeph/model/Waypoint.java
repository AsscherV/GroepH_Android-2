package be.kdg.groeph.model;


import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;

public class Waypoint implements Nullable, Serializable {

    private int id;

    private String label;

    private String description;

    private double lattitude;

    private double longitude;

    private WaypointType waypointType;


    private Trip trip;

    public Waypoint(){

    }

    public Waypoint(String label, String description, WaypointType waypointType, double lattitude, double longitude) {

        this.label=label;
        this.description=description;
        this.waypointType=waypointType;
        this.lattitude=lattitude;
        this.longitude=longitude;

    }

    public WaypointType getWaypointType() {
        return waypointType;
    }

    public void setWaypointType(WaypointType waypointType) {
        this.waypointType = waypointType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    @Override
    public boolean isNull() {
        return false;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                ", waypointType=" + waypointType +
                ", trip=" + trip +
                '}';
    }
}
