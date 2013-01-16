package model;

public class Candidate {
	private String confidence;
	private Face face;
	private Object object;

	public Candidate(Face face,Object object,String confidence) {
		this.face = face;
		this.object = object;
		this.confidence = confidence;
	}

	public String getConfidence() {
		return confidence;
	}

	public Face getFace() {
		return face;
	}

	public Object getObject() {
		return object;
	}


}
