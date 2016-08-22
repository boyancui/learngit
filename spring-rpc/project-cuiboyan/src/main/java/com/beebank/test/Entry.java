package com.beebank.test;

public class Entry implements Comparable<Entry>{
//	Entry prev;//前一节点  
//    Entry next;//后一节点  
    String value;//值  
    int key;//键
//	public Entry getPrev() {
//		return prev;
//	}
//	public void setPrev(Entry prev) {
//		this.prev = prev;
//	}
//	public Entry getNext() {
//		return next;
//	}
//	public void setNext(Entry next) {
//		this.next = next;
//	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Entry [ value=" + value + ", key=" + key + "]";
	}
	public Entry(String value, int key) {
		super();
//		this.prev = prev;
//		this.next = next;
		this.value = value;
		this.key = key;
	}
	public Entry() {
		super();
	}
	public int compareTo(Entry o) {
		if(this.key==o.key&&this.value.equals(o.value)){
			return 0;
		}else{
			return 1;
		}
		
	}
    
}
