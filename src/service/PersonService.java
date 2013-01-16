package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Face;
import model.Group;
import model.Person;
import net.sf.json.JSONObject;
import unti.Constants;
import unti.HttpURLUtils;

public class PersonService extends BaseService {

	public JSONObject personRemoveFace(Person person,Face face) {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_ID, person.getId());
		parameters.put(Constants.FACE_ID, face.getId());
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_PERSON_REMOVEFACE, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}
	
	public JSONObject personAddFace(Person person,Face face) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_ID, person.getId());
		parameters.put(Constants.FACE_ID, face.getId());
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_ADDFACE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}
	
	
	public JSONObject personCreate(String name, String tag, List<Face> faces,
			List<Group> groups) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		if (name != null) {
			parameters.put(Constants.PERSON_NAME, name);
		}
		if (tag != null) {
			parameters.put(Constants.TAG, tag);
		}

		if (faces != null) {
			Iterator<Face> itf = faces.iterator();
			String faceid = "";
			while (itf.hasNext()) {
				faceid += itf.next().getId() + ",";
			}
			if (faceid != "") {
				parameters.put("face_id",
						faceid.substring(0, faceid.length() - 1));
			}
		}

		if (groups != null) {
			Iterator<Group> itg = groups.iterator();
			String groupid = "";
			while (itg.hasNext()) {
				groupid += itg.next().getId() + ",";
			}
			if (groupid != "") {
				parameters.put(Constants.GROUP_ID,
						groupid.substring(0, groupid.length() - 1));
			}
		}

		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_CREATE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personDeleteByPersonName(String personName) {
		if (personName.equals("")) {
			System.out.println("personDeleteByPersonName中personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_NAME, personName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personDeleteByPersonId(String personId) {
		if (personId.equals("")) {
			System.out.println("personDeleteByPersonId中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_ID, personId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personGetInfoByPersonName(String personName) {
		if (personName.equals("")) {
			System.out.println("personGetInfoBypersonName中personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_NAME, personName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personGetInfoByPersonId(String personId) {
		if (personId.equals("")) {
			System.out.println("personGetInfoBypersonId中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_ID, personId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personSetInfoByPersonName(String personName,
			String newStr, String type) {
		if (personName.equals("")) {
			System.out.println("personSetInfoBypersonName中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_NAME, personName);
		parameters.put(type, newStr);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in personSetInfoBypersonName and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject personSetInfoByPersonId(String personId, String newStr,
			String type) {
		if (personId.equals("")) {
			System.out.println("personSetInfoBypersonName中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.PERSON_ID, personId);
		parameters.put(type, newStr);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in personSetInfoBypersonName and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

}
