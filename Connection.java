import java.time.Duration;

public class Connection {

    LocationNode orgin;
    LocationNode target;
    Duration distance;

    public Connection(LocationNode orgin, LocationNode target, Duration distance){
        this.orgin = orgin;
        this.target = target;
        this.distance = distance;
    }

    public String getTargetName(){
        return target.getName();
    }

    public String getOrginName(){
        return orgin.getName();
    }
}