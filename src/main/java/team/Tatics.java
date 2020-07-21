package team;

public class Tatics {

	/** f343, 3 defenders, 4 mid fields, 3 strikers */
	public static final Tatics f343 = new Tatics(3, 4, 3);
	/** f433, 4 defenders, 4 mid fields, 3 strikers */
	public static final Tatics f433 = new Tatics(4, 3, 3);
	/** f442, 4 defenders, 4 mid fields, 2 strikers */
	public static final Tatics f442 = new Tatics(4, 4, 2);
	/** f523, 5 defenders, 2 mid fields, 3 strikers */
	public static final Tatics f523 = new Tatics(5, 2, 3);
	/** f532, 5 defenders, 3 mid fields, 2 strikers */
	public static final Tatics f532 = new Tatics(5, 3, 2);
	/** f541, 5 defenders, 4 mid fields, 1 strikers */
	public static final Tatics f541 = new Tatics(5, 4, 1);
	/** f640, 6 defenders, 4 mid fields, 0 strikers */
	public static final Tatics f640 = new Tatics(6, 4, 0);
	/** f352, 3 defenders, 5 mid fields, 2 strikers */
	public static final Tatics f352 = new Tatics(3, 5, 2);

	private int defendersNumber;
	private int midFieldsNumber; 
	private int strikesNumber;

	public Tatics(int defendersNumber, int midFieldsNumber, int strikesNumber) {
		this.defendersNumber = defendersNumber;
		this.midFieldsNumber = midFieldsNumber;
		this.strikesNumber = strikesNumber;
	}
}
