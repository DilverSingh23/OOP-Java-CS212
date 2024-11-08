/**
 * The SortedApplianceList class represents a linked list of appliances that is in ascending order
 * based on their serial numbers. This class extends ApplianceList
 * and provides a method to add appliances while preserving the sorted order.
 * This class is used heavily in Project2.java and ApplianceGUI.java 
 */
public class SortedApplianceList extends ApplianceList {
    /**
     * Constructs an empty SortedApplianceList.
     */
    public SortedApplianceList () {
        super();
    }

    /**
     * This method adds an Appliance to the list in sorted order based on its serial number
     * The list maintains ascending order as new appliances are added.
     * This returns void so it returns nothing
     * @param appliance the Appliance object is passed into be the data of a 
     * new node that will be added to the linked list
     * current is a node used to itterate through the current linked list and find the proper position 
     * for the new node to fit in ascending order 
     * When a node is successfully added it increments the length of the list by 1
     * If the new node doesn't have any nodes after, the list is updated to make the new node the last
     */
    public void add (Appliance a) {
        ApplianceNode p = first.next;
        ApplianceNode trail = first;
        ApplianceNode newNode = new ApplianceNode(a);
        while (p != null && p.data.compareTo(a) < 0) {
            p = p.next;
            trail = trail.next;
        }
        trail.next = newNode;
        newNode.next = p;

        if (p == null) {
            last = newNode;
        }
        length++;
    }
}
