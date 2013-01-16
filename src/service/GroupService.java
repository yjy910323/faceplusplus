package service;

import java.util.HashMap;
import java.util.Map;

import model.Group;
import model.Person;
import net.sf.json.JSONObject;
import unti.Constants;
import unti.HttpURLUtils;

public class GroupService extends BaseService {
	public JSONObject groupGetInfoByGroupId(String groupId) {
		if (groupId.equals("")) {
			System.out.println("groupGetInfoByGroupId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, groupId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupGetInfoByGroupName(String groupName) {
		if (groupName.equals("")) {
			System.out.println("groupGetInfoByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_NAME, groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupName and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupCreate(String groupName) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_NAME, groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_CREATE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in groupCreate and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupDeleteByGroupName(String groupName) {
		if (groupName.equals("")) {
			System.out.println("groupDeleteByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_NAME, groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupDeleteByGroupName and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupDeleteByGroupId(String groupId) {
		if (groupId.equals("")) {
			System.out.println("groupDeleteByGroupId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, groupId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupDeleteByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupSetInfoByGroupName(String groupName, String newStr,
			String type) {
		if (groupName.equals("")) {
			System.out.println("groupSetInfoByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_NAME, groupName);
		parameters.put(type, newStr);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupSetInfoByGroupName and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupSetInfoByGroupId(String groupId, String newStr,
			String type) {
		if (groupId.equals("")) {
			System.out.println("groupSetInfoByGroupId中groupId不能为空");
			return null;
		}

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, groupId);
		parameters.put(type, newStr);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO,
				parameters);

		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);

		System.out
				.println("running in groupSetInfoByGroupId and the result is ： "
						+ tokenJson);

		return tokenJson;
	}

	public JSONObject groupAddPerson(Group group, Person person) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, group.getId());
		parameters.put(Constants.PERSON_ID, person.getId());
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_ADDPERSON,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in groupAddPerson and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupRemovePerson(Group group, Person person) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, group.getId());
		parameters.put(Constants.PERSON_ID, person.getId());
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_GROUP_REMOVEPERSON, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupRemovePerson and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

}
