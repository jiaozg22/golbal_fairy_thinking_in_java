package com.jzg.thinkingInJava.test.hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V> {
	private static int defaultLength = 32;

	private static double defaultAddSizeFactor = 0.75;

	// 使用数组位置总数
	private int size;

	// 定义一个Entry类型的数组
	private Entry<K, V>[] table = null;

	public MyHashMap() {
		//defaultLength 必须是static的
		this(defaultLength, defaultAddSizeFactor);
		// this(32,0.75);
	}

	public MyHashMap(int length, double defaultAddSizeFactorP) {
		if (length < 0) {
			throw new IllegalArgumentException("扩容标准必须是大于0");
		}
		if (defaultAddSizeFactor < 0) {
			throw new IllegalArgumentException("扩容因子必须是大于0");
		}
		this.defaultLength = length;
		this.defaultAddSizeFactor = defaultAddSizeFactorP;
		table = new Entry[defaultLength];
	}

	public int size() {
		return size;
	}

	class Entry<K, V> implements MyMap.Entry<K, V> {
		// 获取存到Entry对象里面的key value
		K k;
		V v;
		// 这个就是存在next找到地下的Entry对象
		Entry<K, V> next;

		public Entry(K k, V v, Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

		private K getKey() {
			return k;
		}

		private V getValue() {
			return v;
		}

		public Entry getEntry() {
			return next;
		}
	}

	public V get(K k) {
		// key 拿到数组下表位置的对象
		int index = getIndex(k, table.length);
		if (table[index] == null) {
			return (V) new NullPointerException();
		}
		return findValueByEqualKey(k,table[index]);
	}

	private V findValueByEqualKey(K k, Entry<K, V> entry) {
		if (k == entry.getKey() || k.equals(entry.getKey())) {
			return entry.getValue();
		} else {
			if (entry.next != null) {
				return findValueByEqualKey(k, entry.next);
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

//	public V get(Object key) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	// 快存 里面用到hash散列，
	public V put(K key, V value) {
		if (size >= defaultLength * defaultAddSizeFactor) {
			// 扩容两倍
			up2Size();
		}

		// 通过Key来确定存储到我们底层数组的位置
		int index = getIndex(key, table.length);
		//
		Entry<K, V> entry = table[index];
		if (entry == null) {
			table[index] = newEntry(key, value, null);
			size++;
		} else {
			// 位置不为空 链表解决冲突
			table[index] = newEntry(key, value, entry.next);

		}
		return table[index].getValue();
	}

	// 获取实例的方法
	private MyHashMap<K, V>.Entry<K, V> newEntry(K k, V v, Entry<K, V> next) {
		return new Entry(k, v, next);
	}

	public int getIndex(K k, int length) {
		// hashcode算法
		int m = length - 1;
		int index = hash(k.hashCode()) & m;
		// 还不放心
		return index >= 0 ? index : -index;
	}

	// 这个就是我们现在最精髓的方法
	private int hash(int hashCode) {
		// ????????????????
		hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}

	// 扩容两倍的方法
	private void up2Size() {
		Entry<K, V>[] newTable = new Entry[2 * defaultLength];
		// 老数组的存的Entry对象再重新散列到newTable
		againHash(newTable);
	}

	private void againHash(Entry<K, V>[] newTable) {
		// 再次散列
		List<Entry<K, V>> entryList = new ArrayList<Entry<K, V>>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				continue;
			}
			foundEntryByNext(table[i], entryList);
		}

		if (entryList.size() > 0) {
			size = 0;
			defaultLength = 2 * defaultLength;
			table = newTable;
			// 遍历
			for (Entry<K, V> entry : entryList) {
				if (entry.next != null) {
					// 重新散列之前，将所有链表归零
					entry.next = null;
				}
				// TODO
				put(entry.getKey(), entry.getValue());
			}

		}

	}

	// 寻找Entry对象，包括每个数组位置链表的所有Entry对象
	private void foundEntryByNext(Entry<K, V> entry, List<Entry<K, V>> entryList) {
		// TODO Auto-generated method stub
		if (entry != null && entry.next != null) {
			entryList.add(entry);
			// 递归
			foundEntryByNext(entry.next, entryList);
		} else {
			entryList.add(entry);
		}

	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public Set<K> keySet() {
		return null;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
