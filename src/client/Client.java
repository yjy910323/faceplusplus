package client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Candidate;
import model.Eye;
import model.Face;
import model.Group;
import model.Img;
import model.Mouth;
import model.Person;
import model.Similarity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.ParseException;

import service.ClientService;
import unti.Constants;

/**
 * 	@author 颜隽彦   QQ：523722590 E-mail：yjy910323@gmail
 *	有任何bug请联系我~~~~~有商业合作也欢迎哦~~~~~
 *	Face++ Java SDK 1.0版本
 */

public class Client {
	private String key;
	private String secret;
	private String name;
	private String description;
	private String quotaAll;
	private String quotaSearch;
	private ClientService cs;
	private boolean isGroupsCurrent;
	private boolean isPersonsCurrent;
	private List<Group> allGroups;
	private List<Person> allPersons;

	public Client(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}

	private void initApp(JSONObject infoGetApp) {
		setDescription((String) infoGetApp.get("description"));
		setName((String) infoGetApp.get("name"));
	}

	private void initQUOTA(JSONObject infoGetQUOTA) {
		setQuotaAll(infoGetQUOTA.getString("QUOTA_ALL"));
		setQuotaSearch(infoGetQUOTA.getString("QUOTA_SEARCH"));
	}

	private void initAllGroup(JSONObject allGroupInfo) {
		JSONArray result = (JSONArray) allGroupInfo.get("group");
		Iterator<JSONObject> i = result.iterator();
		allGroups = new ArrayList<Group>();
		while (i.hasNext()) {
			JSONObject j = JSONObject.fromObject(i.next());
			Group tmp = new Group(this, j.getString(Constants.GROUP_ID),
					j.getString(Constants.GROUP_NAME),
					j.getString(Constants.TAG));
			allGroups.add(tmp);
		}
		this.isGroupsCurrent = true;
	}

	private void initAllPerson(JSONObject allPersonsInfo) {
		JSONArray result = (JSONArray) allPersonsInfo.get(Constants.PERSON);
		Iterator<JSONObject> i = result.iterator();
		allPersons = new ArrayList<Person>();
		while (i.hasNext()) {
			JSONObject j = JSONObject.fromObject(i.next());
			Person tmp = new Person(this, j.getString(Constants.PERSON_ID),
					j.getString(Constants.PERSON_NAME),
					j.getString(Constants.TAG));
			allPersons.add(tmp);
		}
		this.isPersonsCurrent = true;
	}

	private Img initImg(JSONObject infoGetImg) {
		List<Face> faces = new ArrayList<Face>();
		JSONArray result = (JSONArray) infoGetImg.get("face");
		Iterator<JSONObject> i = result.iterator();
		while (i.hasNext()) {
			JSONObject j = JSONObject.fromObject(i.next());
			JSONObject position = (JSONObject) j.get("position");
			Eye eye = new Eye();
			eye.setEyeLeftX(JSONObject.fromObject(position.get("eye_left"))
					.getString("x"));
			eye.setEyeLeftY(JSONObject.fromObject(position.get("eye_left"))
					.getString("y"));
			eye.setEyeRightY(JSONObject.fromObject(position.get("eye_right"))
					.getString("y"));
			eye.setEyeRightX(JSONObject.fromObject(position.get("eye_right"))
					.getString("x"));

			Mouth mouth = new Mouth();
			mouth.setMouthLeftX(JSONObject.fromObject(
					position.get("mouth_left")).getString("x"));
			mouth.setMouthLeftY(JSONObject.fromObject(
					position.get("mouth_left")).getString("y"));
			mouth.setMouthRightX(JSONObject.fromObject(
					position.get("mouth_right")).getString("x"));
			mouth.setMouthRightY(JSONObject.fromObject(
					position.get("mouth_right")).getString("y"));

			Face tmp = new Face(j.getString("face_id"),
					infoGetImg.getString("img_id"), null,
					position.getString("center"), position.getString("width"),
					position.getString("height"), j.getString(Constants.TAG),
					eye, mouth, null);

			faces.add(tmp);
		}

		return new Img(infoGetImg.getString("img_id"), null, null, null,
				infoGetImg.getString("url"), faces);
	}

	private Img initDetect(JSONObject infoGetImg) {
		List<Face> faces = new ArrayList<Face>();
		JSONArray result = (JSONArray) infoGetImg.get("face");
		Iterator<JSONObject> i = result.iterator();
		while (i.hasNext()) {
			JSONObject j = JSONObject.fromObject(i.next());
			String faceId = j.getString(Constants.FACE_ID);
			Face tmp = new Face(this, faceId);
			faces.add(tmp);
		}

		return new Img(infoGetImg.getString("img_id"),
				infoGetImg.getString("img_width"),
				infoGetImg.getString("img_height"),
				infoGetImg.getString("url"), infoGetImg.getString("url"), faces);
	}

	private Similarity initCompare(JSONObject result) {
		JSONObject component = result.getJSONObject("component_similarity");
		return new Similarity(component.getString("eye"),
				component.getString("mouth"), component.getString("nose"),
				component.getString("eyebrow"), result.getString("similarity"));
	}

	private Map<Face, List<Candidate>> initRecognize(JSONObject result) {
		Map<Face, List<Candidate>> candidates = new HashMap();
		JSONArray facesjson = result.getJSONArray(Constants.FACE);
		Iterator facesit = facesjson.iterator();
		while (facesit.hasNext()) {
			JSONObject a = (JSONObject) facesit.next();
			Face facetmp = new Face(this, a.getString(Constants.FACE_ID));
			Iterator candi = a.getJSONArray("candidate").iterator();
			List<Candidate> candidate = new ArrayList();
			while (candi.hasNext()) {
				JSONObject cand = (JSONObject) candi.next();

				Person persontmp = new Person(this,
						cand.getString(Constants.PERSON_ID));
				Candidate candidatetmp = new Candidate(facetmp,
						(Person) persontmp, cand.getString("confidence"));
				candidate.add(candidatetmp);
			}
			candidates.put(facetmp, candidate);
		}
		return candidates;
	}

	private Map<Face, List<Candidate>> initSearch(JSONObject result, Face face) {
		Map<Face, List<Candidate>> candidates = new HashMap();
		JSONArray c = result.getJSONArray("candidate");
		Iterator ic = c.iterator();
		List<Candidate> candidate = new ArrayList();
		while (ic.hasNext()) {
			JSONObject a = (JSONObject) ic.next();
			Face facrtmp = new Face(this, a.getString(Constants.FACE_ID));
			Candidate candidatetmp = new Candidate(face, (Face) facrtmp,
					a.getString("similarity"));
			candidate.add(candidatetmp);
		}
		candidates.put(face, candidate);
		return candidates;
	}

	public Img detect(String url, String mode, String attribute, String tag) {

		return initDetect(getCs().detectByUrl(url, mode, attribute, tag));

	}

	public Img detect(String url) {
		return detect(url, "", "", "");
	}

	public Img detect(File file) throws ParseException, IOException {
		return initDetect(getCs().detect(file));
	}

	public Similarity compare(Face face1, Face face2) {
		if (face1.isReal() && face2.isReal()) {
			return initCompare(getCs().compare(face1, face2));
		}
		return null;
	}

	public void train(Group group) {
		if (group.isReal()) {
			getCs().train(group, Constants.ALL);
		}
	}

	public Map<Face, List<Candidate>> recognize(Group group, List<Face> faces) {
		return initRecognize(getCs().recognizeByGroupId(group, faces));

	}

	public Map<Face, List<Candidate>> recognize(Group group, File file)
			throws ParseException, IOException {
		return recognize(group, this.detect(file).getFaces());
	}

	public Map<Face, List<Candidate>> search(Face face, Group group,
			String count) {
		return initSearch(getCs().search(face, group, count), face);

	}

	public Map<Face, List<Candidate>> search(Face face, Group group) {
		return search(face, group, "");
	}

	private Face initFace(JSONObject infoGetFace) {
		JSONArray result = (JSONArray) infoGetFace.get("face_info");
		Iterator i = result.iterator();
		while (i.hasNext()) {
			JSONObject face = (JSONObject) i.next();
			JSONObject position = face.getJSONObject("position");
			Eye eye = new Eye();
			eye.setEyeLeftX(JSONObject.fromObject(position.get("eye_left"))
					.getString("x"));
			eye.setEyeLeftY(JSONObject.fromObject(position.get("eye_left"))
					.getString("y"));
			eye.setEyeRightY(JSONObject.fromObject(position.get("eye_right"))
					.getString("y"));
			eye.setEyeRightX(JSONObject.fromObject(position.get("eye_right"))
					.getString("x"));

			Mouth mouth = new Mouth();
			mouth.setMouthLeftX(JSONObject.fromObject(
					position.get("mouth_left")).getString("x"));
			mouth.setMouthLeftY(JSONObject.fromObject(
					position.get("mouth_left")).getString("y"));
			mouth.setMouthRightX(JSONObject.fromObject(
					position.get("mouth_right")).getString("x"));
			mouth.setMouthRightY(JSONObject.fromObject(
					position.get("mouth_right")).getString("y"));

			return new Face(face.getString("face_id"),
					face.getString("img_id"),
					face.getString(Constants.PERSON_ID),
					position.getString("center"), position.getString("width"),
					position.getString("height"),
					face.getString(Constants.TAG), eye, mouth, null);
		}
		return null;
	}

	public Face getFace(String faceId) {
		return initFace(getCs().infoGetFace(faceId));
	}

	public Img getImg(String imgId) {
		return initImg(getCs().infoGetImg(imgId));
	}

	public String getName() {
		if (this.name == null) {
			initApp(getCs().infoGetApp());
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		if (this.description == null) {
			initApp(getCs().infoGetApp());
		}
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}

	public ClientService getCs() {
		if (cs == null) {
			cs = (ClientService) new ClientService().setClient(this);
		}
		return cs;
	}

	public List<Group> getAllGroups() {
		if (allGroups == null || !isGroupsCurrent) {
			initAllGroup(getCs().infoGetGroupList());
		}
		return allGroups;
	}

	public List<Person> getAllPersons() {
		if (allPersons == null || !isPersonsCurrent) {
			initAllPerson(getCs().infoGetPersonList());
		}
		return allPersons;
	}

	public String getQuotaAll() {
		if (quotaAll == null) {
			initQUOTA(getCs().infoGetQUOTA());
		}
		return quotaAll;
	}

	public String getQuotaSearch() {
		if (quotaSearch == null) {
			initQUOTA(getCs().infoGetQUOTA());
		}
		return quotaSearch;
	}

	public void setQuotaAll(String quotaAll) {
		this.quotaAll = quotaAll;
	}

	public void setQuotaSearch(String quotaSearch) {
		this.quotaSearch = quotaSearch;
	}

	public boolean isGroupsCurrent() {
		return isGroupsCurrent;
	}

	public void setGroupsCurrent(boolean isGroupsCurrent) {
		this.isGroupsCurrent = isGroupsCurrent;
	}

	public boolean isPersonsCurrent() {
		return isPersonsCurrent;
	}

	public void setPersonsCurrent(boolean isPersonsCurrent) {
		this.isPersonsCurrent = isPersonsCurrent;
	}

}
