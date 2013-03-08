package be.kdg.groeph.controllers;

import be.kdg.groeph.model.Trip;
import be.kdg.groeph.model.TripUser;

import com.google.gson.JsonSyntaxException;
import flexjson.JSONDeserializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Jo Somers - jo@webcomrades.be
 * @version 1.0
 * @company WebComrades
 * @year 2013
 */

public class DataParser {

    public DataParser() {

    }

    public TripUser parseData(String data) {

/*
Gson gson = new GsonBuilder().create();
Type rootType = new TypeToken<TripUser>(){}.getType();

TripUser object = gson.fromJson(data, rootType);
if(object == Null) {
throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
}
return object;
*/

        TripUser Tuser = null;
        try {
            System.out.println("test");
            Tuser = new JSONDeserializer<TripUser>().deserialize(data);
            if (Tuser == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return Tuser;

/*
ObjectMapper mapper = new ObjectMapper();
TripUser Tuser = Null;
try {
Tuser = mapper.readValue(data, TripUser.class);
} catch (IOException e) {
e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
}

return Tuser;
*/
/*
TripUser Tuser = gson.fromJson(data, TripUser.class);
System.out.println("OUTPUT"+Tuser.toString());
*/

    }

    public List<Trip> parsePublicTrips(String data) {
        List<Trip> trips = null;
        try {
            System.out.println("test");
            trips = new JSONDeserializer<List<Trip>>().deserialize(data);
            if (trips == null) {
               throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return trips;

    }
}
