package client;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import unti.Constants;
import unti.HttpURLUtils;

public class TotalService2 {
	private String key;
	private String secret;

	public TotalService2(String key, String secret) {
		this.key = key;
		this.secret = secret;

	}

	public JSONObject detectByUrl(String url, String mode, String attribute,
			String tag) {
		if (url.equals("")) {
			// System.out.println("detectByUrl中url不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("url", url);
		if (!mode.equals(""))
			parameters.put("mode", mode);
		if (!attribute.equals(""))
			parameters.put("attribute", attribute);
		if (!tag.equals(""))
			parameters.put("tag", tag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_DETECT,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject compare(String face_id1, String face_id2) {
		if (face_id1.equals("") || face_id2.equals("")) {
			// System.out.println("compare中face_id不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("face_id1", face_id1);
		parameters.put("face_id2", face_id2);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_COMPARE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject recognizeByGroupId(String groupId, String url,
			String key_face_id) {
		if (groupId.equals("")) {
			// System.out.println("recognizeByGroupId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		if (!url.equals(""))
			parameters.put("url", url);
		if (!key_face_id.equals(""))
			parameters.put("key_face_id", key_face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_RECOGNIZE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject recognizeByGroupName(String groupName, String url,
			String key_face_id) {
		if (groupName.equals("")) {
			// System.out.println("recognizeByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		if (!url.equals(""))
			parameters.put("url", url);
		if (!key_face_id.equals(""))
			parameters.put("key_face_id", key_face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_RECOGNIZE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject searchByGroupId(String keyFaceId, String groupId,
			String count) {
		if (groupId.equals("") || keyFaceId.equals("")) {
			// System.out.println("searchByGroupId中groupId或keyFaceId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("key_face_id", keyFaceId);
		parameters.put("group_id", groupId);
		if (!count.equals(""))
			parameters.put("count", count);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_SEARCH,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject searchByGroupName(String keyFaceId, String groupName,
			String count) {
		if (groupName.equals("") || keyFaceId.equals("")) {
			// System.out.println("searchByGroupName中groupName或keyFaceId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("key_face_id", keyFaceId);
		parameters.put("group_name", groupName);
		if (!count.equals(""))
			parameters.put("count", count);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_SEARCH,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject trainByGroupName(String groupName, String type) {
		if (groupName.equals("") || type.equals("")) {
			// System.out.println("trainByGroupName中groupName或type不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		parameters.put("type", type);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_TRAIN,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject trainByGroupId(String groupId, String type) {
		if (groupId.equals("") || type.equals("")) {
			// System.out.println("trainByGroupId中groupId或type不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		parameters.put("type", type);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_TRAIN,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject verifyByPersonId(String personId, String face_id) {
		if (personId.equals("") || face_id.equals("")) {
			// System.out.println("verifyByPersonId中personId或 face_id不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		parameters.put("face_id", face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_VERIFY,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject verifyByPersonName(String personName, String face_id) {
		if (personName.equals("") || face_id.equals("")) {
			// System.out.println("verifyByPersonName中personName或 face_id不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		parameters.put("face_id", face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_VERIFY,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personAddFaceByPersonName(String personName,
			String face_id) {
		if (personName.equals("") || face_id.equals("")) {
			//System.out.println("personAddFaceByPersonName中personName或 face_id不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		parameters.put("face_id", face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_ADDFACE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		//System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}

	public JSONObject personAddFaceByPersonId(String personId, String face_id) {
		if (personId.equals("") || face_id.equals("")) {
			// System.out.println("personAddFaceByPersonId中personId或 face_id不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		parameters.put("face_id", face_id);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_ADDFACE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personCreate(String personName, String face_id,
			String tag, String GroupId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		if (!personName.equals(""))
			parameters.put("person_name", personName);
		if (!face_id.equals(""))
			parameters.put("face_id", face_id);
		if (!tag.equals(""))
			parameters.put("tag", tag);
		if (!GroupId.equals(""))
			parameters.put("group_id", GroupId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_CREATE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personDeleteBypersonName(String personName) {
		if (personName.equals("")) {
			// System.out.println("personDeleteBypersonName中personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personDeleteBypersonId(String personId) {
		if (personId.equals("")) {
			// System.out.println("personDeleteBypersonId中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personGetInfoBypersonName(String personName) {
		if (personName.equals("")) {
			// System.out.println("personGetInfoBypersonName中personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personGetInfoBypersonId(String personId) {
		if (personId.equals("")) {
			// System.out.println("personGetInfoBypersonId中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personRemoveFaceBypersonName(String personName,
			String faceId) {
		if (personName.equals("") || faceId.equals("")) {
			//System.out.println("personRemoveFaceBypersonName中personName或faceId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		parameters.put("face_id", faceId);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_PERSON_REMOVEFACE, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		//System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}

	public JSONObject personRemoveFaceBypersonId(String personId,
			String faceId) {
		if (personId.equals("") || faceId.equals("")) {
			//System.out.println("personRemoveFaceBypersonId中personName或faceId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		parameters.put("face_id", faceId);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_PERSON_REMOVEFACE, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		//System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}

	public JSONObject personSetInfoBypersonName(String personName,
			String newName, String newTag) {
		if (personName.equals("")) {
			// System.out.println("personSetInfoBypersonName中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_name", personName);
		if (!newName.equals(""))
			parameters.put("name", newName);
		if (!newTag.equals(""))
			parameters.put("tag", newTag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject personSetInfoBypersonId(String personId, String newName,
			String newTag) {
		if (personId.equals("")) {
			// System.out.println("personSetInfoBypersonId中personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", personId);
		if (!newName.equals(""))
			parameters.put("name", newName);
		if (!newTag.equals(""))
			parameters.put("tag", newTag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupAddPersonById(String groupId, String personId) {
		if (groupId.equals("") || personId.equals("")) {
			// System.out.println("groupAddPersonById中groupId或personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		parameters.put("person_id", personId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_ADDPERSON,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupAddPersonByName(String groupName, String personName) {
		if (groupName.equals("") || personName.equals("")) {
			// System.out.println("groupAddPersonByName中groupName或personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		parameters.put("person_name", personName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_ADDPERSON,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupCreate(String groupName) {
		if (groupName.equals("")) {
			// System.out.println("groupCreate中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_CREATE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupDeleteByGroupName(String groupName) {
		if (groupName.equals("")) {
			// System.out.println("groupDeleteByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupDeleteByGroupId(String groupId) {
		if (groupId.equals("")) {
			// System.out.println("groupDeleteByGroupId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupGetInfoByGroupName(String groupName) {
		if (groupName.equals("")) {
			// System.out.println("groupGetInfoByGroupName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupGetInfoByGroupId(String groupId) {
		if (groupId.equals("")) {
			// System.out.println("groupGetInfoByGroupId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupRemovePersonById(String groupId, String personId) {
		if (groupId.equals("") || personId.equals("")) {
			// System.out.println("groupRemovePersonById中groupId或personId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_id", groupId);
		parameters.put("person_id", personId);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_GROUP_REMOVEPERSON, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupRemovePersonBy(String groupName,
			String personName) {
		if (groupName.equals("") || personName.equals("")) {
			//System.out.println("groupRemovePersonById中groupName或personName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("group_name", groupName);
		parameters.put("person_name", personName);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_GROUP_REMOVEPERSON, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		//System.out.println("running in groupGetInfoByGroupId and the result is ： "+ tokenJson);
		return tokenJson;
	}

	public JSONObject groupSetInfoBypersonName(String groupName,
			String newName, String newTag) {
		if (groupName.equals("")) {
			// System.out.println("groupSetInfoBypersonName中groupName不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, "640cef26df9b65d4fea480215cd51975");
		parameters
				.put(Constants.API_SECRET, "iD5K1vGzawH5nss_e2s8oG569ZHrtNd6");
		parameters.put("person_name", groupName);
		if (!newName.equals(""))
			parameters.put("name", newName);
		if (!newTag.equals(""))
			parameters.put("tag", newTag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject groupSetInfoBypersonId(String groupId, String newName,
			String newTag) {
		if (groupId.equals("")) {
			// System.out.println("groupSetInfoBypersonId中groupId不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("person_id", groupId);
		if (!newName.equals(""))
			parameters.put("name", newName);
		if (!newTag.equals(""))
			parameters.put("tag", newTag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetApp() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETAPP,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetFace(String faceId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("face_id", faceId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETFACE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetGroupList() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_INFO_GETGROUPLIST, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetImg(String imgId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("img_id", imgId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETIMAGE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetPersonList() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_INFO_GETPERSONLIST, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetQUOTA() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETQUOTA,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetSession(String sessionId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, key);
		parameters.put(Constants.API_SECRET, secret);
		parameters.put("session_id", sessionId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETSESSION,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		// System.out.println("running in groupGetInfoByGroupId and the result is ： "+
		// tokenJson);
		return tokenJson;
	}
}
