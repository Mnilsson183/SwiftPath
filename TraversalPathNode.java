public class TraversalPathNode {
    LocationNode nextLocationNode = null;
    LocationNode myLocationNode = null;
    LocationNode prevLocationNode = null;

    public TraversalPathNode(LocationNode nextLocationNode, LocationNode myLocationNode, LocationNode prevLocationNode){
        this.nextLocationNode = nextLocationNode;
        this.myLocationNode = myLocationNode;
        this.prevLocationNode = prevLocationNode;
    }
}
