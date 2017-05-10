public abstract class Element{
	public abstract void Print();
	public abstract Sequence flatten();
	public abstract Sequence copy();
	public abstract int getInt();
	public abstract void setInt(int x);
}