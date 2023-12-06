package selftest2;

//판매/구매/재고
import java.util.ArrayList;
public class InOutExe {

	
	private ArrayList<InOut> inouts;
	
	InOutExe(){
		inouts = new ArrayList<InOut>();
	}
	
	boolean sellInOut(InOut inout) {
		return inouts.add(inout);
	}
	
	boolean buyInOut()

} //end of class
