package model;

public class Similarity {
	private String eye;
	private String mouth;
	private String nose;
	private String eyebrow;
	private String similarity;

	public Similarity(String eye, String mouth, String nose, String eyebrow,
			String similarity) {
		this.eye = eye;
		this.mouth = mouth;
		this.nose = nose;
		this.eyebrow = eyebrow;
		this.similarity = similarity;

	}

	public String getEye() {
		return eye;
	}

	public String getMouth() {
		return mouth;
	}

	public String getNose() {
		return nose;
	}

	public String getEyebrow() {
		return eyebrow;
	}

	public String getSimilarity() {
		return similarity;
	}
}
