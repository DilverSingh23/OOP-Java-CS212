/**
 * The ApplianceNode class represents a node in a linked list (ApplianceList.java or SortedApplianceList.java)
 * Each node holds an Appliance object as its data and a .next which references the next node in the linked list
 */
public class ApplianceNode {
    protected Appliance data;
    protected ApplianceNode next;

    /**
     * This is the constructor for a node 
     * Initilaizes each nodes .next to be null
     * @param data, this appliance object is used to store value in the node
     */
    public ApplianceNode (Appliance d) {
        data = d;
        next = null;
    }

}
