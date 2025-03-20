public class Locker {
    private LockerState lockerState;
    private Size size;

    public void open(String code) {}
    public void close() {
        // expire locker's code
        // set locker state as available
    }
    public void book() {
        // set locker state as booked
        // generate code
    }
    public LockerState getLockerState() {
        return this.lockerState;
    }
    public void setLockerState(LockerState lockerState) {}
}

/*
 * Distributed key value store
 * 
 * 2 operations
 *  get (key) -> value
 *  put(key, value)
 * 
 * data partitions
 * 
 * data replications
 * 
 * manage node cluster (dynamically add/remove nodes)
 * 
 * discover nodes
 * 
 * failure detection
 * 
 * failure handling
 * 
 * tunable consistency
 * 
 * conflict resolution
*/