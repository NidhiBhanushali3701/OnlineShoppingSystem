package OnlineShoppingSystem.TnE;

import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.Product.*;

public class phonenumberException extends Exception
{
	public phonenumberException(String m)
	{
		super(m);
	}
	public String toString()
	{
		return "\n\tINVALID PHONE NO :/\n";
	}
}