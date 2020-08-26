public class Entry {
  private Integer key;
  private Integer value;
  private Entry prev;
  private Entry next;

  public Entry(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public Entry(){
  }

  public Integer getValue() {
    return this.value;
  }

  public Integer setValue(Integer value) {
    this.value = value;
    return this.value;
  }

  public Entry getNext(){
    return this.next;
  }

  public Entry setNext(Entry entry){
    this.next = entry;
    return this.next;
  }

  public Entry getPrev(){
    return this.prev;
  }

  public Entry setPrev(Entry entry){
    this.prev = entry;
    return this.prev;
  }
}
