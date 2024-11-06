public class SortedApplianceList extends ApplianceList {
    public SortedApplianceList () {
        last.next = ln;
        last = ln;
        length++;
    }

    public void add (Appliance a) {
        ApplianceNode p = first.next;
        while (p != null) {
            if (a.compareTo(p) < 0){
                ApplianceNode temp = p;
                p = a;
                p.next = temp;
            }
            p = p.next;
        }
    }
    
}
