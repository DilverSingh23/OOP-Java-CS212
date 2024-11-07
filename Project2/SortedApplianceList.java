public class SortedApplianceList extends ApplianceList {
    public SortedApplianceList () {
        super();
    }

    public void add (Appliance a) {
        ApplianceNode p = first.next;
        ApplianceNode trail = first;
        ApplianceNode newNode = new ApplianceNode(a);
        while ((p != null) && (p.data.compareTo(a) < 0)) {
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
