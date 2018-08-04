package by.htp.kyzniatsova.entity;

public enum EnumMonth {
	ßÍÂÀĞÜ(0), ÔÅÂĞÀËÜ(1), ÌÀĞÒ(2), ÀÏĞÅËÜ(3), ÌÀÉ(4), ÈŞÍÜ(5),
	ÈŞËÜ(6), ÀÂÃÓÑÒ(7), ÑÅÍÒßÁĞÜ(8), ÎÊÒßÁĞÜ(9), ÍÎßÁĞÜ(10), ÄÅÊÀÁĞÜ(11);
	
	private int number;
	
	private EnumMonth(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}
