public abstract class ApplianceList {
    ApplianceNode ln = new ApplianceNode();
    private ApplianceNode first = ln;
    private ApplianceNode last = ln;
    private int length = 0;

    public ApplianceList () {
        last.next = ln;
        last = ln;
        length ++;
    }

    public void append (Appliance s) {
        ApplianceNode n = new ApplianceNode(s);
        last.next = n;
        last = n;
        length++; 
    }
}
