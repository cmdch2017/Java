public static Node getMid(Node head) {
	if(head==null) return null;
	Node slow=head;
	Node fast=head;
	while(fast!=null) {
		fast=fast.next;
		if(fast==null) break;
		fast=fast.next;
		slow=slow.next;
	}
	return slow;
}