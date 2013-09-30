package pss;

public class connected {

	private String target1;
	private String target2;
	
	
	public connected(String target1, String target2) {
		this.setTarget1(target1);
		this.setTarget2(target2);
	
	}

	/**
	 * @return the target1
	 */
	public String getTarget1() {
		return target1;
	}

	/**
	 * @param target1 the target1 to set
	 */
	public void setTarget1(String target1) {
		this.target1 = target1;
	}

	/**
	 * @return the target2
	 */
	public String getTarget2() {
		return target2;
	}

	/**
	 * @param target2 the target2 to set
	 */
	public void setTarget2(String target2) {
		this.target2 = target2;
	}

}
