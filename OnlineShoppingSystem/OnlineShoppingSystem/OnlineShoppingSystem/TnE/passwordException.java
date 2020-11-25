package OnlineShoppingSystem.TnE;

import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.Product.*;

public class passwordException extends Exception
{
	public passwordException(String m)
	{
		super(m);
	}
	public String toString()
	{
		return "\n\tINVALID PASSWORD PATTERN :/\n";
	}
}