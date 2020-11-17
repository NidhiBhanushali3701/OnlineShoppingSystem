package OnlineShoppingSystem;

public class SearchingException extends Exception
{
	private static final long serialVersionUID = 1L;
	public SearchingException(String msg)
	{
		super(msg);
	}

	public String toString()
	{
		return "PRODUCT NOT FOUND :/";
	}
}
