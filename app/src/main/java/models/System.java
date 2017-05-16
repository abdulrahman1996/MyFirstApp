package models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Asus on 16/05/2017.
 */
@Table(name = "system")
public class System extends Model {
    @Column
    public int numberOfFreelancer ;
    @Column
    public  int numberOfEmployer ;
    @Column
    public  int numberOfTasks ;

}
