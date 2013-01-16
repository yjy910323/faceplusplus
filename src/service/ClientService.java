package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Face;
import model.Group;
import net.sf.json.JSONObject;

import org.apache.http.ParseException;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import unti.Constants;
import unti.HttpURLUtils;

public class ClientService extends BaseService {

	public JSONObject search(Face face, Group group, String count) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put("key_face_id", face.getId());
		parameters.put(Constants.GROUP_ID, group.getId());
		if (!count.equals(""))
			parameters.put("count", count);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_SEARCH,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in search and the result is ： " + tokenJson);
		return tokenJson;
	}

	public JSONObject recognizeByGroupId(Group group, List<Face> faces) {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, group.getId());
		Iterator<Face> itf = faces.iterator();
		String faceid = "";
		while (itf.hasNext()) {
			faceid += itf.next().getId() + ",";
		}
		if (faceid != "") {
			parameters.put("key_face_id",
					faceid.substring(0, faceid.length() - 1));
		}

		String tokenResult = HttpURLUtils.doPost(Constants.URL_RECOGNIZE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject train(Group group, String type) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put(Constants.GROUP_ID, group.getId());
		parameters.put("type", type);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_TRAIN,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject compare(Face face1, Face face2) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put("face_id1", face1.getId());
		parameters.put("face_id2", face2.getId());
		String tokenResult = HttpURLUtils.doPost(Constants.URL_COMPARE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out
				.println("running in groupGetInfoByGroupId and the result is ： "
						+ tokenJson);
		return tokenJson;
	}

	public JSONObject detectByUrl(String url, String mode, String attribute,
			String tag) {
		if (url.equals("")) {
			System.out.println("detectByUrl中url不能为空");
			return null;
		}
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put("url", url);
		if (!mode.equals(""))
			parameters.put("mode", mode);
		if (!attribute.equals(""))
			parameters.put("attribute", attribute);
		if (!tag.equals(""))
			parameters.put(Constants.TAG, tag);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_DETECT,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in detectByUrl and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject detect(File file) throws ParseException, IOException {
		MultipartEntity reqEntity = new MultipartEntity();
		FileBody filebody = new FileBody(file);
		reqEntity.addPart("img", filebody);
		reqEntity.addPart(Constants.API_KEY, new StringBody(
				"640cef26df9b65d4fea480215cd51975"));
		reqEntity.addPart(Constants.API_SECRET, new StringBody(
				"iD5K1vGzawH5nss_e2s8oG569ZHrtNd6"));

		JSONObject tokenJson = JSONObject.fromObject(HttpURLUtils
				.doImg(reqEntity));
		System.out.println("running in detectByUrl and the result is ： "
				+ tokenJson);
		return tokenJson;

	}

	public JSONObject infoGetApp() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETAPP,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetApp and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetGroupList() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_INFO_GETGROUPLIST, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetGroupList and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetPersonList() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		String tokenResult = HttpURLUtils.doPost(
				Constants.URL_INFO_GETPERSONLIST, parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetPersonList and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetImg(String imgId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put("img_id", imgId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETIMAGE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetImg and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetFace(String faceId) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		parameters.put("face_id", faceId);
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETFACE,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetFace and the result is ： "
				+ tokenJson);
		return tokenJson;
	}

	public JSONObject infoGetQUOTA() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(Constants.API_KEY, super.getClient().getKey());
		parameters.put(Constants.API_SECRET, super.getClient().getSecret());
		String tokenResult = HttpURLUtils.doPost(Constants.URL_INFO_GETQUOTA,
				parameters);
		JSONObject tokenJson = (JSONObject) JSONObject.fromObject(tokenResult);
		System.out.println("running in infoGetQUOTA and the result is ： "
				+ tokenJson);
		return tokenJson;
	}
}
