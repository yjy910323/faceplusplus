FacePlusPlus Java SDK
Face++是北京旷视科技有限公司（Megvii）搭建的新型视觉服务平台 旨在创建简单易用，功能强大，平台兼容的新一代视觉服务。
http://www.faceplusplus.com/

author Nat.Yan 
email:yjy910323@gmail.com
======
Client c = new Client("640cef26df9b65d4fea480215cd51975","iD5K1vGzawH5nss_e2s8oG569ZHrtNd6");
System.out.println("每小时 QUOTA_SEARCH:"+c.getQuotaSearch());
System.out.println("每小时 QUOTA_ALL:"+c.getQuotaAll());
//都到所有的group
List<Group> allGroups = c.getAllGroups();
//都到所有的Person
List<Person> allPersons = c.getAllPersons();
		
Face f1 = new Face(c, "your_face_id");
Face f2 = new Face(c, "your_face_id");
		
//创建一个真实的person by person-id
Person p1 = new Person(c, "your_person_id");
//创建一个不存在的Person
Person p2 = new Person(c);
p2.setName("name");//为不存在的person设置name
p2.create();//创建person
p2.delete();//删除person
p2.getFaces();//获取这个人的face
p2.addFace(f1);//为这个人物添加一个face
p2.removeFaec(f1);//为这个人物移除一个face
		
//通过groupId创建一个真实存在的group
Group g1 = new Group(c,"your_group_id",Constants.ID);
//通过groupName创建一个真实存在的group
Group g2 = new Group(c,"your_group_name",Constants.NAME);
//创建一个不存在的group
Group g3 = new Group(c);
g3.setName("group");//为不存在的group设置name
g3.setTag("tag");//为不存在的group设置tag
g3.create();//创建group。
g3.addPerson(p1);
g3.removePerson(p2);
g3.delete();
		
c.detect(new File("your_photo_path"));
c.detect("http_url");
c.compare(f1, f2);
c.recognize(g1, new File("your_photo_path"));
c.search(f1, g3);
c.search(f1, g3, "50");
c.train(g3);