package com.head.ooad.chap1;

public class Guitar {

	public int model;
	GuitarSpec sepc;

	public Guitar(int model, GuitarSpec spec) {
		this.model = model;
		this.sepc=spec;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public GuitarSpec getSepc() {
		return sepc;
	}

	public void setSepc(GuitarSpec sepc) {
		this.sepc = sepc;
	}

	public Guitar search(Guitar searchGuitar) {

			if (this.getModel() != 0 && searchGuitar.getModel() !=this.getModel()) return null;
			GuitarSpec spec = searchGuitar.getSepc();
			
			if (spec.getType() != (this.getSepc().getType())) return null;
			if (!spec.getBrand().equals(this.getSepc().getBrand())) return null;
			return this;
	}

}
