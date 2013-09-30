package pss;
/************************************************************************
** @author Chad
** Utility contains some methods essential to the performance of the PSS program, but have nothing to do with SamStat behaviour
** instead they have to do with how the program operates.
**
*************************************************************************/

public interface Utility {

	/**
	** This method identifies and returns the host's local IP addy
	** @param none
	** @return String ipAddy
	** @throws
	**/
	 void findIpAddy();//End findIpAddy
	
	
	 
	 
	 /**
	 ** Ztime creates a string var that we can return to the calling method using java.util.calendar and java.util.SimpleDateFormat
	 ** @param none
	 ** @return timestamp a string variable that returns a DTG group based on the Simple Date Format established in the method.
	 ** @throws none
	 **/
	public String zTime();//End formatDTG
	
	
	
	
	
	
}//End Utility
