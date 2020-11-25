package OnlineShoppingSystem.TnE;

import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.Product.*;

public class ProductNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String msg)
	{
		super(msg);
	}

	public String toString()
	{
		return "\n\tPRODUCT NOT FOUND :/\n";
	}
}
