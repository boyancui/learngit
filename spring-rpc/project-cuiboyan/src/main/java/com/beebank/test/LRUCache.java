package com.beebank.test;


import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

//import java.util.HashMap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class LRUCache {
	public static BiMap<Integer, Entry> map=HashBiMap.create(); 
	public static final int MAXIMUNSIZE=5;
	public static void main(String[] args) {
		LoadingCache<String, Entry> EntryCache=
				CacheBuilder
				.newBuilder()
				//8分后失效
				.expireAfterAccess(8, TimeUnit.MINUTES)
				.maximumSize(MAXIMUNSIZE)
				.build(new CacheLoader<String,Entry>() {
					public Entry load(String value) throws Exception {
						System.out.println(1);
						return getEntry(value);
					}
				});
		try {
			EntryCache.get("a");
			EntryCache.get("b");
			EntryCache.get("c");
			EntryCache.get("d");
			EntryCache.get("e");
			EntryCache.get("b");//缓存队列里面存在，所以没有将b再放入缓存中
			EntryCache.get("f");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	public static Entry getEntry(String value) {
		putValue(value);
		return map.get(1);
	}
	public static  void putValue(String value){
		if(map.size()==0){
			putValues(value);
		}else{
			puForwardValues(value);
		}
	}
	
	
	//添加第一个键值对到BiMap中
	public static void putValues(String value) {
		map.put(new Integer(1), new Entry(value, 1));
		System.out.println(map);
	}
	//添加键值对到BiMap中（总数大于1，小于最大长度）
	public static void puForwardValues(String value) {
		//若添加新值时，依次进行移位
		if(map.get(value)==null){
			Set<Integer> set=map.keySet();
			for(int i=set.size();i>=1;i--){
				Entry entry=map.get(i);
				if(map.get(i+1)!=null){
					map.remove(i+1);
				}
				map.remove(i);
				map.put(i+1, entry);
				map.get(i+1).setKey(i+1);
			}
			map.remove(1);
			map.put(1, new Entry(value, 1));
			if(map.size()>5){
				map.remove(6);
			}
			System.out.println(map);
			
		}
		//若添加的值在map中时，将该值置于最前位，并依次移位
		else{
			int key=map.get(value).getKey();
			for(int i=key;i>=1;i--){
				map.remove(key);
				Entry entry=map.get(i-1);
				map.put(i, entry);
				map.get(i).setKey(i);
			}
			map.remove(1);
			map.put(1, new Entry(value, 1));
			System.out.println(map);
		}
	}
	
	
}
