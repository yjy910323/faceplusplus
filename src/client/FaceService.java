package client;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import unti.Constants;
import unti.HttpURLUtils;

public class FaceService {
	
	public static JSONObject detectByUrl(String url,String mode,String attribute,String tag){
		if(url.equals("")){
			System.out.println("detectByUrl中url不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("url", url);
        if(!mode.equals("")) parameters.put("mode", mode);
        if(!attribute.equals(""))  parameters.put("attribute", attribute);
        if(!tag.equals("")) parameters.put("tag", tag);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_DETECT, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject compare(String face_id1,String face_id2){
		if(face_id1.equals("")||face_id2.equals("")){
			System.out.println("compare中face_id不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("face_id1", face_id1);
        parameters.put("face_id2", face_id2);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_COMPARE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject recognizeByGroupId(String groupId,String url,String key_face_id){
		if(groupId.equals("")){
			System.out.println("recognizeByGroupId中groupId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        if(!url.equals("")) parameters.put("url", url);
        if(!key_face_id.equals("")) parameters.put("key_face_id", key_face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_RECOGNIZE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject recognizeByGroupName(String groupName,String url,String key_face_id){
		if(groupName.equals("")){
			System.out.println("recognizeByGroupName中groupName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        if(!url.equals("")) parameters.put("url", url);
        if(!key_face_id.equals("")) parameters.put("key_face_id", key_face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_RECOGNIZE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject searchByGroupId(String keyFaceId,String groupId,String count){
		if(groupId.equals("")||keyFaceId.equals("")){
			System.out.println("searchByGroupId中groupId或keyFaceId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("key_face_id", keyFaceId);
        parameters.put("group_id", groupId);
        if(!count.equals("")) parameters.put("count", count);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_SEARCH, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject searchByGroupName(String keyFaceId,String groupName,String count){
		if(groupName.equals("")||keyFaceId.equals("")){
			System.out.println("searchByGroupName中groupName或keyFaceId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("key_face_id", keyFaceId);
        parameters.put("group_name", groupName);
        if(!count.equals("")) parameters.put("count", count);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_SEARCH, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}

	
	public static JSONObject trainByGroupName(String groupName,String type){
		if(groupName.equals("")||type.equals("")){
			System.out.println("trainByGroupName中groupName或type不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        parameters.put("type", type);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_TRAIN, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject trainByGroupId(String groupId,String type){
		if(groupId.equals("")||type.equals("")){
			System.out.println("trainByGroupId中groupId或type不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        parameters.put("type", type);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_TRAIN, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject verifyByPersonId(String personId,String face_id){
		if(personId.equals("")||face_id.equals("")){
			System.out.println("verifyByPersonId中personId或 face_id不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        parameters.put("face_id", face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_VERIFY, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject verifyByPersonName(String personName,String face_id){
		if(personName.equals("")||face_id.equals("")){
			System.out.println("verifyByPersonName中personName或 face_id不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("persion_name", personName);
        parameters.put("face_id", face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_VERIFY, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personAddFaceByPersonName(String personName,String face_id){
		if(personName.equals("")||face_id.equals("")){
			System.out.println("personAddFaceByPersonName中personName或 face_id不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("persion_name", personName);
        parameters.put("face_id", face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_ADDFACE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personAddFaceByPersonId(String personId,String face_id){
		if(personId.equals("")||face_id.equals("")){
			System.out.println("personAddFaceByPersonId中personId或 face_id不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        parameters.put("face_id", face_id);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_ADDFACE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personCreate(String  personName,String face_id,String tag,String GroupId){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        if(!personName.equals("")) parameters.put("person_name", personName);
        if(!face_id.equals("")) parameters.put("face_id", face_id);
        if(!tag.equals("")) parameters.put("tag", tag);
        if(!GroupId.equals("")) parameters.put("group_id", GroupId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_CREATE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personDeleteBypersonName(String  personName){
		if(personName.equals("")){
			System.out.println("personDeleteBypersonName中personName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_name", personName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personDeleteBypersonId(String  personId){
		if(personId.equals("")){
			System.out.println("personDeleteBypersonId中personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_DELETE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personGetInfoBypersonName(String  personName){
		if(personName.equals("")){
			System.out.println("personGetInfoBypersonName中personName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_name", personName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personGetInfoBypersonId(String  personId){
		if(personId.equals("")){
			System.out.println("personGetInfoBypersonId中personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_GETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personRemoveFaceBypersonName(String personName,String faceId){
		if(personName.equals("")||faceId.equals("")){
			System.out.println("personRemoveFaceBypersonName中personName或faceId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_name", personName);
        parameters.put("face_id", faceId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_REMOVEFACE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personRemoveFaceBypersonId(String  personId,String faceId){
		if(personId.equals("")||faceId.equals("")){
			System.out.println("personRemoveFaceBypersonId中personName或faceId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        parameters.put("face_id", faceId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_REMOVEFACE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject personSetInfoBypersonName(String personName,String newName,String newTag){
		if(personName.equals("")){
			System.out.println("personSetInfoBypersonName中personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_name", personName);
        if(!newName.equals("")) parameters.put("name", newName);
        if(!newTag.equals("")) parameters.put("tag", newTag);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject personSetInfoBypersonId(String  personId,String newName,String newTag){
		if(personId.equals("")){
			System.out.println("personSetInfoBypersonId中personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", personId);
        if(!newName.equals("")) parameters.put("name", newName);
        if(!newTag.equals("")) parameters.put("tag", newTag);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_PERSON_SETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	
	public static JSONObject groupAddPersonById(String groupId,String personId){
		if(groupId.equals("")||personId.equals("")){
			System.out.println("groupAddPersonById中groupId或personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        parameters.put("person_id", personId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_ADDPERSON, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupAddPersonByName(String groupName,String personName){
		if(groupName.equals("")||personName.equals("")){
			System.out.println("groupAddPersonByName中groupName或personName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        parameters.put("person_name", personName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_ADDPERSON, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject groupCreate(String groupName){
		if(groupName.equals("")){
			System.out.println("groupCreate中groupName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_CREATE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupDeleteByGroupName(String groupName){
		if(groupName.equals("")){
			System.out.println("groupDeleteByGroupName中groupName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupDeleteByGroupId(String groupId){
		if(groupId.equals("")){
			System.out.println("groupDeleteByGroupId中groupId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_DELETE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	
	public static JSONObject groupGetInfoByGroupName(String groupName){
		if(groupName.equals("")){
			System.out.println("groupGetInfoByGroupName中groupName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupGetInfoByGroupId(String groupId){
		if(groupId.equals("")){
			System.out.println("groupGetInfoByGroupId中groupId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_GETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupRemovePersonById(String groupId,String personId){
		if(groupId.equals("")||personId.equals("")){
			System.out.println("groupRemovePersonById中groupId或personId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_id", groupId);
        parameters.put("person_id", personId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_REMOVEPERSON, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupRemovePersonBy(String groupName,String personName){
		if(groupName.equals("")||personName.equals("")){
			System.out.println("groupRemovePersonById中groupName或personName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("group_name", groupName);
        parameters.put("person_name", personName);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_REMOVEPERSON, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	
	public static JSONObject groupSetInfoBypersonName(String groupName,String newName,String newTag){
		if(groupName.equals("")){
			System.out.println("groupSetInfoBypersonName中groupName不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_name", groupName);
        if(!newName.equals("")) parameters.put("name", newName);
        if(!newTag.equals("")) parameters.put("tag", newTag);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject groupSetInfoBypersonId(String  groupId,String newName,String newTag){
		if(groupId.equals("")){
			System.out.println("groupSetInfoBypersonId中groupId不能为空");
			return null;
		}
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("person_id", groupId);
        if(!newName.equals("")) parameters.put("name", newName);
        if(!newTag.equals("")) parameters.put("tag", newTag);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_GROUP_SETINFO, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject infoGetApp(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETAPP, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject infoGetFace(String faceId){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("face_id",faceId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETFACE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject infoGetGroupList(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETGROUPLIST, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject infoGetImg(String imgId){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("img_id",imgId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETIMAGE, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	
	public static JSONObject infoGetPersonList(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETPERSONLIST, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject infoGetQUOTA(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETQUOTA, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	
	public static JSONObject infoGetSession(String sessionId){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("api_key", Constants.FACE_KEY);
        parameters.put("api_secret", Constants.FACE_SECRET);
        parameters.put("session_id",sessionId);
        String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETSESSION, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        System.out.println(tokenJson);
		return tokenJson;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f97194f893f379daba243e80d0bf6073
		
		//detectByUrl("http://file9.ihushcdn.com/cnproduct/product/1/2/p372473/images/product_image372473_0.jpg","oneface","","");
		//personCreate("", "", "", "");
		//trainByGroupName("test","all");
		//groupGetInfoByGroupId("b647026a54ee41e6832655c4d9613c3a");
		//infoGetGroupList();
		//infoGetQUOTA();
		//groupDeleteByGroupId("59381db25411fe8b4e5cab6edaad07a8");
		//infoGetGroupList();
		//FaceService.groupCreate("test");
		//FaceService.infoGetPersonList();
		//FaceService.trainByGroupName("test", "all");
		//FaceService.groupGetInfoByGroupName("test");
		//FaceService.infoGetGroupList();
		//FaceService.groupCreate("test");
		//FaceService.personDeleteBypersonId("7ae5589535ec1cfc7df1d9910577a159");
		//FaceService.personDeleteBypersonId("59f666fbf304f1ad2cd4aeb66d8d9b6c");
		//FaceService.personCreate("", "ee77712256565ed645384a50a3bb16f9", "", "4a6297e0fcf3f47c12856f77961627b2");
		FaceService.detectByUrl("http://hdn.xnimg.cn//photos//hdn321//20120727//1245//h_main_Wdrl_292a000002af1375.jpg", "", "", "");
		//FaceService.searchByGroupName("1a8584c4f3e4235239bb55a67f14b49d", "test", "");
		//FaceService.personAddFaceByPersonId("e64dcec74f5c4d9005ef1f331c8b69a8", "e2bbb4b167ee5ad852262c2d306f2670");
		//FaceService.personGetInfoBypersonId("e64dcec74f5c4d9005ef1f331c8b69a8");
		
		
		//FaceService.recognizeByGroupName("test", "http://fmn.rrimg.com/fmn064/20111124/1305/large_cMUm_33390000d2fe125c.jpg", "");
		
		//FaceService.groupDeleteByGroupName("test");
		//FaceService.personDeleteBypersonId("ac85d311e70fefb5e150c29757b5dcda,38096e663108780d939b6e965d15c695,a1097b46de7a4f62d12eeb3f1751e6d9");
		
		
	}

}
