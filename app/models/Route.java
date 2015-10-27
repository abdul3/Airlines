package models;

/**
 * Created by randomlocks on 10/20/2015.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

import javax.persistence.*;
import java.util.List;


@Entity
public class Route extends Model {


    @Id
    public Long id;

    @OneToOne
    public Airport airport;

    @ManyToOne
    public Fare fare;

    @OneToMany(mappedBy = "route")
    public List<Flight> flights;



    public static Finder<Long, Route> find = new Finder<>(Route.class);



    /**************************************ATTRIBUTE****************************************/

    public String source;


    public String destination;

    //optional
    public String intermediate; // multi_valued



    public Route(){
        // left blank
    }

/**********************************ROUTE**********************************************/

public static PagedList findPage(int page , int index) {

    return find.where()
            .orderBy("id asc")
            .findPagedList(page,index);

}



}
