package models;

import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Asus on 16/05/2017.
 */
@Table (name = "accounts")
public class Account extends Model  implements Serializable{
    @Column (name ="username")
    public  String username ;
    @Column (name = "fname")
    public  String fnmae ;
    @Column (name = "lname")
    public String lname ;
    @Column (name = "phone")
    public  String phone;
    @Column (name =  "adress")
    public  String adress;
    @Column (name = "password")
    public  String password;
    @Column (name =  "mail")
    public  String mail;
    @Column (name = "roleId")
    public  int roleId ; // 0 for admin , 1 for freelancer , 2 for Employer
    @Column
    public double freeLancerCostPerHour ;
    @Column (name = "freelancerTasks")
    public  List<Task> freelancerTask = new ArrayList<>();


    //////// Employer function ////////////////

    // for Employer account
    public  void CreateTask(Task task)
    {
        task.state = 0 ;
        task.employerId = this.getId();
        task.save();
    }

    // this for Employer
    public   List<Task> getTasks()
    {
        List<Task> tasks =  new Select().from(Task.class).where(" employerId = ? " ,this.getId()).execute();
        return tasks;
    }


    // for Employer account
    public  void agereeFreelancer(Account freelancer ,Task task)
    {
        task.freelancer = freelancer.getId() ;
        task.budjet = task.hours * freelancer.freeLancerCostPerHour;
        task.state = 2 ;
        task.save();

    }
  // show request  in task
    public List<Account> showRequest(Task task)
    {
        List<taskRequest> taskRequests = new Select().from(taskRequest.class).where("taskId = ?"  , task.getId()).execute();
        List<Account> freelancerRequest = new ArrayList<>();
        for(taskRequest tr :taskRequests)
        {
         freelancerRequest.add(getFreelacerById(tr.freelancerId));
        }
        return  freelancerRequest;
    }


private Account getFreelacerById(long id)
{
    return new Select().from(Account.class).where("accounts = ? " , id).executeSingle();
}
//////// freelancer functions ////////////
   // this for freelancer account
    public  void chooseTask(Account account , Task task)
    {
        taskRequest taskRequest = new taskRequest();
        taskRequest.taskId = task.getId();
        taskRequest.freelancerId  = account.getId();
        taskRequest.save();


        task.state = 1 ;
        task.save();
    }


    // fot freelancer
    public List<Task> showMyTasks(Account freelancer)
    {
        return  new Select().from(Task.class).where(" freelancerId = ? " ,freelancer.getId()).execute();
    }


////////////////// Admin functions ////////////////

    // for admin account
    public  void AddAdmin(Account account)
    {
        account.save();
    }



    public List<Account> getAllAccounts()
    {
        return  new Select().from(Account.class).execute();
    }
    // foe admin
    public List<System> getStatistics ()
    {
        return new Select().from(System.class).execute();

    }

    // getAccount by userName and password
    public Account getAccount(String username , String password)
    {
       ArrayList<Account> accs = (ArrayList<Account>) this.getAllAccounts();
        for(Account account : accs)
        {
            if(account.username.equalsIgnoreCase(username) && account.password.equalsIgnoreCase(password))
            {
                Log.e("Ea" ,">>>>");
                return account;
            }
        }

        return  null ;
    }


    /////////////
 public  boolean isUsernamefound(String username) {
     Account acc = new Select().from(Account.class).where("username = ?" , username).executeSingle();
     if(acc!= null)
     {
         return  false;
     }
     else
     return  true;
 }


public boolean save(Account account)
{
  Account acc = new Select().from(Account.class).where("username = ?" , account.username).executeSingle();
  if(acc!= null)
  {
     return  false;
  }
  else
      account.save();

    return  true;
}




}
