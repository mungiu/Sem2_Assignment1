package Shared;

import java.io.Serializable;

/*Used by producer */
public class Request implements Serializable
{
	public TYPE type;
	public int number;
	public int[] numArr;


	public enum TYPE
	{
		GIVE_NUMARR,        // when consumer asks for 3 numbers
		ADD_NUM,            // when producer asks server to add the numbers
		CALCULATE_NUM,       // when server asks consumer to calculate
		PRINT_NUM
	}


//	// example: TYPE type = TYPE.ADD_NUMBER;
//	private TYPE type;
//	private int i;
//
//	private int[] intArr;
//
//	public Request(String string, int i, int[] intArr)
//	{
//		switch (string)
//		{
//			case "NUMBER_ADDTOLIST":
//				type = TYPE.NUMBER_ADDTOLIST;
//				this.i = i;
//				break;
//			case "NUMBER_RESULTCALCULATE":
//				type = TYPE.NUMBER_RESULTCALCULATE;
//				this.intArr = intArr;
//				break;
//		}
//	}
//
//	/**
//	 * NOT HERE:
//	 * It is used to define tags that can be attached to a variable to th type "TYPE",
//	 * and later those variables can be stored inside another Object type.
//	 */
//	public enum TYPE
//	{
//		NUMBER_ADDTOLIST,
//		NUMBER_RETRIEVEFROMLIST,
//		NUMBER_RESULTCALCULATE,
//		NUMBER_DELETEFROMLIST,
//		MESSAGE
//	}
//
//	public TYPE getType()
//	{
//		return type;
//	}
//
//	public int getInt() { return i;}
//
//	public int[] getIntArr() { return intArr; }
}
