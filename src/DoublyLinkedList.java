public class DoublyLinkedList {
  private Entry start;
  private Entry end;
  private Integer size;

  public DoublyLinkedList() {
    this.start = null;
    this.end = null;
    this.size = 0;
  }

  public Entry removeLast() {
    // no op for empty list
    if (this.start == null && this.end == null) {
      return null;
    }

    Entry last = this.end;
    Entry secondToLast = last.getPrev();

    if (secondToLast != null) {
      secondToLast.setNext(null);
    }

    this.end = secondToLast;

    if (this.size > 0) {
      this.size--;
    }

    return last;
  }

  public Integer getSize() {
    return this.size;
  }

  public void removeEntry(Entry entry) {
    if (entry == null) {
      return;
    }

    if (entry.getPrev() != null) {
      entry.getPrev().setNext(entry.getNext());
    }

    if (entry.getNext() != null) {
      entry.getNext().setPrev(entry.getPrev());
    }

    if (this.start == entry) {
      this.start = entry.getNext();
    }

    if (this.end == entry) {
      this.end = entry.getPrev();
    }
  }

  public Entry addToStart(Entry entry) {
    // First entry is both head and tail
    if (this.start == null && this.end == null) {
      this.start = entry;
      this.end = entry;
      return entry;
    }

    Entry start = this.start;
    entry.setNext(start);
    this.start = entry;
    this.size++;
    return entry;
  }
}
