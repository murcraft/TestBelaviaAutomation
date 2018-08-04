package by.htp.kyzniatsova.entity;

public enum EnumMonth {
	������(0), �������(1), ����(2), ������(3), ���(4), ����(5),
	����(6), ������(7), ��������(8), �������(9), ������(10), �������(11);
	
	private int number;
	
	private EnumMonth(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}
