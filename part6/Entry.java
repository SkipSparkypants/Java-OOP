class Entry{
	private Pair data;
	private Pair link;
	Entry(Pair p, Pair link){
		this.data = p;
		this.link = link;
	}
	public Pair getData(){
		return this.data;
	}
	public Pair getLink(){
		return this.link;
	}
}