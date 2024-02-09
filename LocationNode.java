import java.util.ArrayList;

public class LocationNode {
    String name;
    ArrayList<Connection> connections = new ArrayList<Connection>();
    int locationNumber;

    public String getName(){
        return new String(this.name);
    }

    public void addConntection(Connection connection){
        connections.add(connection);
    }
}
