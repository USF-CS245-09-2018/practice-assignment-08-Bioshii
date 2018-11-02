public class LinkedList implements List {
	int size;
	Node head;

	public class Node {
		Object data;
		Node next;

		public Node() {
			data = null;
			next = null;
		}
	}

	public LinkedList() {
		size = 0;
	}

	public void add(Object obj) throws Exception {
		if (size == 0) {
			Node node = new Node();
			node.data = obj;
			head = node;
			++size;
		} else {
			Node node = new Node();
			node.data = obj;
			Node lastNode = getNode(size-1);
			lastNode.next = node;
			++size;
		}
	}
	
	public void add(int pos, Object obj) throws Exception {
		if (pos < 0 || pos >= size+1)
			throw new Exception("Not a valid position.");

		if (pos == 0) {
			Node node = new Node();
			node.data = obj;
			node.next = head;
			head = node;
			++size;
		} else {
			Node node = new Node();
			node.data = obj;
			Node previous = getNode(pos-1);
			node.next = previous.next;
			previous.next = node;
			++size;
		}
	}

	public Node getNode(int pos) throws Exception {
		if (pos < 0 || pos >= size)
			throw new Exception("Not a valid position.");

		if (pos == 0) 
			return head;

		Node curr = head;
		for (int i = 0; i < pos; i++)
			curr = curr.next;
		return curr;
	}

	public Object get(int pos) throws Exception {
		if (pos < 0 || pos >= size)
			throw new Exception("Not a valid position.");

		Node node = getNode(pos);
		return node.data;
	}
	
	public Object remove(int pos) throws Exception {
		if (pos < 0 || pos >= size)
			throw new Exception("Not a valid position");

		if (pos == 0) {
			Node temp = head;
			head = head.next;
			--size;
			return temp.data;
		} else {
			Node previous = getNode(pos-1);
			Node temp = previous.next;
			previous.next = temp.next;
			--size;
			return temp.data;
		}
	}

	public int size() {
		return size;
	}

}
