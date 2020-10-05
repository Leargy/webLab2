package session;

import java.util.ArrayList;
import java.util.List;

public class EntryList {
    private List<Entry> entryList;

    public EntryList() {
        entryList = new ArrayList<Entry>();
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setElement(Entry tempEntry) {
        entryList.add(tempEntry);
    }

    public void clearList() {
        entryList.clear();
    }
}
