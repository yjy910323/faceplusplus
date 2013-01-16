package model;

import client.Client;

public class Face {
	private String id;
	private String imgId;
	private String height;
	private String width;
	private String center;
	private String tag;
	private String personId;
	private boolean isReal;
	private Eye eye;
	private Mouth mouth;
	private Attribute attribute;
	private Client client;

	// client通过getFace 或者getImg 构造real的Face
	public Face(String id, String imgId, String personId, String center,
			String width, String height, String tag, Eye eye, Mouth mouth,
			Attribute attribute) {
		this.id = id;
		this.imgId = imgId;
		this.personId = personId;
		this.center = center;
		this.height = height;
		this.width = width;
		this.tag = tag;
		this.eye = eye;
		this.mouth = mouth;
		this.attribute = attribute;
		this.isReal = true;
	}

	// 通过faceid 构造face real = true
	public Face(Client client, String faceId) {
		this.id = faceId;
		this.client = client;
		this.isReal = true;
	}

	public String getId() {
		return id;
	}

	public String getImgId() {
		return imgId;
	}

	public Eye getEye() {
		return eye;
	}

	public Mouth getMouth() {
		return mouth;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public String getHeight() {
		return height;
	}

	public String getWidth() {
		return width;
	}

	public String getCenter() {
		return center;
	}

	public String getTag() {
		return tag;
	}

	public String getPersonId() {
		return personId;
	}

	public boolean isReal() {
		return isReal;
	}

	public Client getClient() {
		return client;
	}

}
