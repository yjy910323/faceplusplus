package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.PersonService;
import unti.Constants;
import client.Client;

public class Person {
	// private Client client;
	private String id;
	private String name;
	private String tag;
	private Client client;
	private boolean isReal;
	private List<Group> belongGroup;
	private boolean isGroupCurrent;
	private List<Face> faces;
	private PersonService ps;

	// private Face[] faces;

	// client构造的person 数据真实 real=true
	public Person(Client client, String id, String name, String tag) {
		this.client = client;
		this.id = id;
		this.name = name;
		this.tag = tag;
		this.isReal = true;
	}

	public Person(Client client) {
		this.client = client;
		this.isReal = false;
	}

	public Person(Client client,String id){
		this.client = client;
		this.id = id;
	}
	
	public void update() {
		JSONObject personGetInfo;
		if (getId() != null) {
			personGetInfo = getPs().personGetInfoByPersonId(getId());
		} else if (getName() != null) {
			personGetInfo = getPs().personGetInfoByPersonName(getName());
		} else {
			return;
		}

		List<Face> lfs = new ArrayList<Face>();
		List<Group> lgs = new ArrayList<Group>();
		this.id = personGetInfo.getString(Constants.PERSON_ID);
		this.name = personGetInfo.getString(Constants.PERSON_NAME);
		this.tag = personGetInfo.getString(Constants.TAG);
		this.isReal = true;
		JSONArray groupinfo = (JSONArray) personGetInfo.get("group");
		Iterator<JSONObject> it = groupinfo.iterator();
		while (it.hasNext()) {
			JSONObject g = (JSONObject) it.next();
			Group tmp = new Group(client, g.getString(Constants.GROUP_ID),
					g.getString(Constants.GROUP_NAME),
					g.getString(Constants.TAG));
			lgs.add(tmp);
		}
		this.belongGroup = lgs;
		JSONArray ps = personGetInfo.getJSONArray(Constants.FACE_ID);
		for (int i = 0; i < ps.size(); i++) {
			Face face = new Face(client, ps.getString(i));
			lfs.add(face);
		}
		this.faces = lfs;
	}

	private void commit(String paramter, String type) {
		JSONObject personGetInfo = null;
		if (!this.isReal) {
			return;
		}
		if (getId() != null) {
			personGetInfo = getPs().personSetInfoByPersonId(getId(), paramter,
					type);
		} else if (getName() != null) {
			personGetInfo = getPs().personSetInfoByPersonName(getName(),
					paramter, type);
		}
		this.name = personGetInfo.getString(Constants.GROUP_NAME);
		this.tag = personGetInfo.getString(Constants.TAG);
	}

	public boolean delete() {
		JSONObject personDelete;
		if (getId() != null) {
			personDelete = getPs().personDeleteByPersonId(getId());
		} else if (getName() != null) {
			personDelete = getPs().personDeleteByPersonName(getName());
		} else {
			return false;
		}
		if (personDelete.getBoolean(Constants.SUCCESS)) {
			update();
			client.setPersonsCurrent(false);
			this.ps = null;
			this.id = null;
			this.isReal = false;
			this.name = null;
			this.faces = null;
			this.tag = null;
			this.client.setPersonsCurrent(false);
			Iterator<Group> i = this.belongGroup.iterator();
			while (i.hasNext()) {
				i.next().setPersonsCurrent(false);
			}
			return true;
		}
		return false;
	}

	public boolean create() {
		return create(null, null);
	}

	
	//创建person 给person face和所在group
	public boolean create(List<Face> faces, List<Group> groups) {
		boolean isCreate = false;
		if (!isReal && (name != null || tag != null)) {
			JSONObject result = getPs().personCreate(getName(), getTag(),
					faces, groups);
			this.id = result.getString(Constants.PERSON_ID);
			this.name = result.getString(Constants.PERSON_NAME);
			this.tag = result.getString(Constants.TAG);
			this.isReal = true;
			client.setPersonsCurrent(false);// 通知client personslist有变化！
			isCreate = true;
		}
		return isCreate;
	}

	public boolean removeFaec(Face face) {
		boolean result = false;
		if (face.isReal()) {
			if (getPs().personRemoveFace(this, face).getBoolean(
					Constants.SUCCESS)) {
				getFaces().remove(face);
				result = true;
				Iterator<Group> i = this.belongGroup.iterator();
				while (i.hasNext()) {
					i.next().setPersonsCurrent(false);
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	public boolean addFace(Face face) {
		boolean result = false;
		if (face.isReal()) {

			if (getPs().personAddFace(this, face).getBoolean(Constants.SUCCESS)) {
				getFaces().add(face);
				result = true;
				Iterator<Group> i = this.belongGroup.iterator();
				while (i.hasNext()) {
					i.next().setPersonsCurrent(false);
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		if(name==null){
			update();
		}
		return name;
	}

	public String getTag() {
		return tag;
	}

	public boolean isReal() {
		return isReal;
	}

	public PersonService getPs() {
		if (ps == null) {
			ps = (PersonService) new PersonService().setClient(this.client);
		}
		return ps;
	}

	public void setName(String name) {
		if (isReal) {
			commit(name, Constants.NAME);
		} else {
			this.name = name;
		}

	}

	public void setTag(String tag) {
		if (isReal) {
			commit(tag, Constants.TAG);
		} else {
			this.tag = tag;
		}
	}

	public boolean isGroupCurrent() {
		return isGroupCurrent;
	}

	public List<Group> getBelongGroup() {
		if (belongGroup == null && isReal) {
			update();
		}
		return belongGroup;
	}

	public List<Face> getFaces() {
		if (faces == null && isReal) {
			update();
		}
		return faces;
	}

}
