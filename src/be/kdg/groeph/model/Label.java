package be.kdg.groeph.model;


import java.io.Serializable;

public class Label implements Serializable {

    private int id;

    private String name;


    //TODO: enkel cascade DELETE fzo
    //@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Trip trip;

    public Label() {
    }

    public Label(String label) {
        this.name=label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (!name.toLowerCase().equals(label.name.toLowerCase())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
