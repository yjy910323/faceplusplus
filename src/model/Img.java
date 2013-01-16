package model;

import java.util.List;

public class Img {
	private String id;
	private String sessionId;
	private String height;
	private String width;
	private String url;
	private List<Face> faces;

	public Img(String id, String sessionId, String width, String height,
			String url, List<Face> faces) {
		this.id = id;
		this.sessionId = sessionId;
		this.height = height;
		this.width = width;
		this.url = url;
		this.faces = faces;
	}

	public String getId() {
		return id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getHeight() {
		return height;
	}

	public String getWidth() {
		return width;
	}

	public String getUrl() {
		return url;
	}

	public List<Face> getFaces() {
		return faces;
	}

}
