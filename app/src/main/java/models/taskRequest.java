package models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Asus on 16/05/2017.
 */
@Table(name =  "taskRequest")
public class taskRequest extends Model {
    @Column(name = "taskId")
    public  long taskId ;
    @Column (name = "freelancerId")
    public  long freelancerId ;

}
