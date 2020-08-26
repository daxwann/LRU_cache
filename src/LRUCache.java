import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final Integer LRU_SIZE = 5;
  private Map<Integer, Entry> hashMap;
  private DoublyLinkedList doublyLinkedList;

  public LRUCache() {
    this.hashMap = new HashMap<>();
    this.doublyLinkedList = new DoublyLinkedList();
  }

  public Integer getEntry(Integer key) {
    Entry entry = this.hashMap.get(key);
    this.doublyLinkedList.removeEntry(entry);
    this.doublyLinkedList.addToStart(entry);

    return entry.getValue();
  }

  public void addEntry(Integer key, Integer value) {
    if (this.hashMap.containsKey(key)) {
      Entry entry = this.hashMap.get(key);
      this.doublyLinkedList.removeEntry(entry);
      this.doublyLinkedList.addToStart(entry);
      entry.setValue(value);
      return;
    }

    if (this.doublyLinkedList.getSize() == LRU_SIZE) {
      this.doublyLinkedList.removeLast();
    }

    Entry newEntry = new Entry(key, value);

    this.doublyLinkedList.addToStart(newEntry);
  }
}
