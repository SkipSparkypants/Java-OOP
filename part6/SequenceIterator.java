class SequenceIterator {
	private Node data;
	SequenceIterator(Node N){
		this.data = N;
	}
	public boolean equal(SequenceIterator other){
		if (this.data == other.data){
			return true;
		}
		else{
			return false;
		}
	}
	public void setIterator(Node N){
		this.data = N;
	}
	public void advance(){
		this.data = this.data.getNext();
	}
	public Element get(){
		Element temp = this.data.getEle();
		return temp;
	}
}