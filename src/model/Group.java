package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.GroupService;
import unti.Constants;
import client.Client;

public class Group {
	private String id;
	private String name;
	private String tag;
	private List<Person> persons;
	private GroupService gs;
	private Client client;
	private boolean isPersonsCurrent;
	private boolean isReal;

	// client 获取的 Group构造器 一定是Real
	public Group(Client client, String id, String name, String tag) {
		this.id = id;
		this.name = name;
		this.tag = tag;
		this.client = client;
		this.isReal = true;
	}

	// 通过一个参数（id或者name）构造一个真实的group
	public Group(Client client, String parameter, String type) {
		if (type.equals(Constants.ID)) {
			this.id = parameter;
		} else if (type.equals(Constants.NAME)) {
			this.name = parameter;
		}
		this.client = client;
		update();
	}

	// 创建爱你虚拟构造group,使用create，创建真实的group
	public Group(Client client) {
		this.isReal = false;
		this.client = client;
	}

	public boolean delete() {
		JSONObject groupDelete;
		if (getId() != null) {
			groupDelete = getGs().groupDeleteByGroupId(getId());
		} else if (getName() != null) {
			groupDelete = getGs().groupDeleteByGroupName(getName());
		} else {
			return false;
		}
		if (groupDelete.getBoolean(Constants.SUCCESS)) {
			// this.client = null;
			client.setGroupsCurrent(false);
			this.gs = null;
			this.id = null;
			this.isReal = false;
			this.name = null;
			this.persons = null;
			this.tag = null;
			return true;
		}
		return false;
	}

	public boolean create() {
		boolean isCreate = false;
		if (!isReal && name != null) {
			JSONObject result = getGs().groupCreate(getName());
			this.id = result.getString(Constants.GROUP_ID);
			this.name = result.getString(Constants.GROUP_NAME);
			this.tag = result.getString(Constants.TAG);
			this.isReal = true;
			client.setGroupsCurrent(false);// 通知client grouplist有变化！
			isCreate = true;
		}
		return isCreate;
	}

	public boolean addPerson(Person person) {
		boolean result = false;
		if (person.isReal()) {

			if (getGs().groupAddPerson(this, person).getBoolean(
					Constants.SUCCESS)) {
				getPersons().add(person);
				result = true;
				this.client.setPersonsCurrent(false);
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	public boolean removePerson(Person person) {
		boolean result = false;
		if (person.isReal()) {
			if (getGs().groupRemovePerson(this, person).getBoolean(
					Constants.SUCCESS)) {
				getPersons().remove(person);
				result = true;
				this.client.setPersonsCurrent(false);
			} else {
				result = false;
			}

		} else {
			result = false;
		}
		return result;
	}

	private void commit(String paramter, String type) {
		JSONObject groupGetInfo = null;
		if (!this.isReal) {
			return;
		}
		if (getId() != null) {
			groupGetInfo = getGs().groupSetInfoByGroupId(getId(), paramter,
					type);
		} else if (getName() != null) {
			groupGetInfo = getGs().groupSetInfoByGroupName(getName(), paramter,
					type);
		}
		this.name = groupGetInfo.getString(Constants.GROUP_NAME);
		
		this.tag = groupGetInfo.getString(Constants.TAG);
	}

	public void update() {
		JSONObject groupGetInfo;
		if (getId() != null) {
			groupGetInfo = getGs().groupGetInfoByGroupId(getId());
		} else if (getName() != null) {
			groupGetInfo = getGs().groupGetInfoByGroupName(getName());
		} else {
			return;
		}

		List<Person> lps = new ArrayList<Person>();
		this.id = groupGetInfo.getString(Constants.GROUP_ID);
		this.name = groupGetInfo.getString(Constants.GROUP_NAME);
		this.tag = groupGetInfo.getString(Constants.TAG);
		JSONArray ps = groupGetInfo.getJSONArray(Constants.PERSON);
		Iterator<JSONObject> i = ps.iterator();
		while (i.hasNext()) {
			JSONObject result = i.next();
			Person tmp = new Person(getClient(), result.getString(Constants.PERSON_ID),
					result.getString(Constants.PERSON_NAME), result.getString(Constants.TAG));
			lps.add(tmp);
		}
		this.persons = lps;
		this.isReal = true;
		this.isPersonsCurrent = true;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTag() {
		return tag;
	}

	public GroupService getGs() {
		if (gs == null) {
			gs = (GroupService) new GroupService().setClient(client);
		}
		return gs;
	}

	public List<Person> getPersons() {
		if (persons == null || !isPersonsCurrent) {
			update();
		}
		return persons;
	}

	public Client getClient() {
		return client;
	}

	public boolean isReal() {
		return isReal;
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

	public boolean isPersonsCurrent() {
		return isPersonsCurrent;
	}

	public void setPersonsCurrent(boolean isPersonsCurrent) {
		this.isPersonsCurrent = isPersonsCurrent;
	}

}
