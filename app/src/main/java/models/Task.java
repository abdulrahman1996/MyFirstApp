package models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

import models.Account;

/**
 * Created by Asus on 16/05/2017.
 */
@Table(name = "tasks")
public class Task extends Model{
    @Column (name =  "describtion")
    public  String describtion ;
    @Column(name = "hours")
    public  int hours ;
    @Column (name = "date")
    public Date date ;
    @Column(name =  "budjet")
    public  double budjet ;
    @Column (name = "freelancerId")
    public Long freelancer;
    @Column (name = "employerId")
    public  long employerId ;
    @Column (name = "state")
    public  int state ;


    public    List<Task> listAllTasks()
    {
        return  new Select().from(Task.class).execute();
    }



}
