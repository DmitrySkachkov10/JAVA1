package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;


import java.util.List;

public interface IFlightDao {
    List<Flight> getFlights() ;


    /**
     *
     * @param page number of page
     * @param size how many objects on the page
     * @return list of objects on this page
     */

    List<Flight> getFlights(int page, int size);

    /**
     *
     * @param page
     * @param size
     * @param filters method with filters
     * @return
     */
    List<Flight> getFlights(int page, int size, List<String> filters);


}
