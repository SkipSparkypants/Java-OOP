class Node{
	private Element ele;
	private Node next;
	Node(Element ele, Node n){
		this.ele = ele;
		this.next = n;
	}
	public void setNext(Node N){
		this.next = N;
	}
	public Node getNext(){
		return this.next;
	}
	public Element getEle(){
		return this.ele;
	}
}