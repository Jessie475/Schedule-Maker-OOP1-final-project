import java.util.ArrayList;

public class leisure extends schedule {
	private ArrayList<leisure> leisures = new ArrayList<>();

	public leisure() {

	}

	public leisure(Double date, String type, int timeBegin, int timeEnd, String detail) {
		super(date, timeBegin, timeEnd, type, detail);
	}

	public void classifier() {
		leisure orderElement;
		// 排日期
		for (int k = 0; k < leisures.size() - 1; k++) {
			int a = leisures.size();

			for (int n = 0; n < a - 1; n++) {
				if (leisures.size() > 1) {
					if (leisures.get(n).getDate() * 100 > leisures.get(n + 1).getDate() * 100) {
						orderElement = leisures.get(n + 1);
						leisures.set(n + 1, leisures.get(n));
						leisures.set(n, orderElement);

					}
				}
			}
			a--;
		}
		for (int k = 0; k < leisures.size() - 1; k++) {
			int a = leisures.size();

			for (int n = 0; n < a - 1; n++) {
				if (leisures.size() > 1) {
					if (leisures.get(n).getDate() == leisures.get(n + 1).getDate()) {
					if (leisures.get(n).getTimeBegin() > leisures.get(n + 1).getTimeBegin()) {
						orderElement = leisures.get(n + 1);
						leisures.set(n + 1, leisures.get(n));
						leisures.set(n, orderElement);
					}
					}
				}
			}
			a--;
		}
	}

	public void adder(leisure leisures) {
		this.leisures.add(leisures);
	}

	public String getInfo() {
		double i = 0;
		String allLeisure = "Leisure's List: \n";

		for (leisure leisure : leisures) {
			if (leisure.getDate() != i) {
				allLeisure += " ".repeat(4) + "Date: " + leisure.getDate() + "\n";
			}
			allLeisure += " ".repeat(8) + leisure.getTimeBegin() + " ~ " + leisure.getTimeEnd() + ": "
					+ leisure.getDetail() + "\n";
			i = leisure.getDate();
		}

		allLeisure += "-".repeat(40);
		return allLeisure;
	}

}