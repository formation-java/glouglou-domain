package fr.glouglouwine.domain;

public enum GrapeTypes {

	// CABERNET, GRENACHE, MALBEC, MERLOT, PINOT_NOIR, SYRAH;
	CABERNET("Cabernet"), GRENACHE("Grenache"), MALBEC("Malbec"), MERLOT("Merlot"), PINOT_NOIR("Pinot noir"), SYRAH(
			"Syrah");

	private String label;

	GrapeTypes(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
