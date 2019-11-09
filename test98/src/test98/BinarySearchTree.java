package test98;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BinarySearchTree {
private static class Node{
	int key;
	int value;
	Node left;
	Node right;
}
	private static Node root=null;
	public int get(int key) {
		Node cur=root;
		while(cur!=null) {
			if(key==cur.key)
				return cur.value;
			else if(key<cur.key) {
				cur=cur.left;
			}
			else {
				cur=cur.right;
			}
		}
		return -1;
	}
	public int getOrDefault(int key,int defaultValue) {
		Node cur=root;
		while(cur!=null) {
			if(cur==root) {
				root=cur.right;
			}
			if(key==cur.key)
				return cur.value;
			else if(key<cur.key) {
				cur=cur.left;
			}
			else {
				cur=cur.right;
			}
		}
		return defaultValue;
	}
	public int remove(int key) {
		Node cur=root;
		Node parent=root;
		while(cur!=null) {
			if(key==cur.key) {
				int oldValue=cur.value;
				deleteNode(parent,cur);
			}
			else if(key<cur.key) {
				parent=cur;
				cur=cur.left;
			}
			else {
				parent=cur;
				cur=cur.right;
			}
		}
		return 0;
	}
	private void deleteNode(Node parent, Node cur) {
		// TODO 自动生成的方法存根
		if(cur.left==null) {
			if(cur==parent.left) {
				parent.left=cur.right;
				}
				else {
				parent.right=cur.right;
				}
			}
		}
	public static class Entry{
		private int key;
	    private int value;
	public int getKey() {
		return key;
	}
	public int getValue() {
		return value;
	}
	public int getValue2() {
		Node cur=root;
		while(cur!=null) {
			if(cur.key<key) {
				cur=cur.left;
			}
			else if(cur.key>key) {
				cur=cur.right;
			}
			else {
				return value;
			}
		}
		return -1;
	}
	}
	public int put(int key,int value) {
	if(root==null) {
		root=new Node();
		root.key=key;
		root.value=value;
		return -1;
	}
	Node parent=null;
	Node cur=root;
	while(cur!=null) {
		if(key==cur.key) {
			int oldValue=cur.value;//记录返回值
			cur.value=value;
			return oldValue;
			}
		else if(key<cur.value){
			parent=cur;
			cur=cur.left;
		}
		else {
			parent=cur;
			cur=cur.right;
		}
	}
	Node node=new Node();
	node.key=key;
	node.value=value;
	if(key<parent.key) {
		parent.left=node;
	}else {
		parent.right=node;
	}
	return -1;
}
	public boolean containsKey(int key) {
		Node cur=root;
		while(cur!=null) {
			if(key==cur.key)
				return true;
			else if(key<cur.key) {
				cur=cur.left;
			}
			else {
				cur=cur.right;
			}
		}
		return false;
	}
	public Set<Integer> keySet(){
	Set<Integer> result=new HashSet<>();
	if(root==null) return result;
	Queue<Node> queue=new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		Node front=queue.poll();
		result.add(front.key);
		if(front.left!=null) {
			queue.add(front.left);
		}
		if(front.right!=null) {
			queue.add(front.right);
		}
	}
		return result;
	}
}
