/**
 *
 */
package com.htmlhifive.sync.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.htmlhifive.sync.jsonctrl.SyncAction;
import com.htmlhifive.sync.jsonctrl.download.DownloadRequest;
import com.htmlhifive.sync.jsonctrl.download.DownloadRequestMessage;
import com.htmlhifive.sync.jsonctrl.upload.UploadRequest;
import com.htmlhifive.sync.jsonctrl.upload.UploadRequestMessage;
import com.htmlhifive.sync.sample.person.PersonResourceElement;
import com.htmlhifive.sync.sample.scd.ScheduleResourceElement;

/**
 * テスト用にJSONデータを生成するクラス.
 *
 * @author kawaguch
 */
public class TestJsonGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		TestJsonGenerator gen = new TestJsonGenerator();

		gen.downloadRequestJSON("schedule", 0L, "");

		//		gen.uploadNewRequestJSON_Person();
		// gen.uploadExistingRequestJSON_Person();
		// gen.uploadDeleteRequestJSON_Person();
		// gen.uploadMixedRequestJSON_Person();

		//		 gen.uploadNewRequestJSON_Schedule();
		//		gen.uploadExistingRequestJSON_Schedule();

	}

	void downloadRequestJSON(String dataModelName, long lastSyncTime, String query) throws Exception {

		DownloadRequest dr = new DownloadRequest();

		DownloadRequestMessage drm;
		ArrayList<DownloadRequestMessage> al = new ArrayList<>();

		drm = new DownloadRequestMessage();
		drm.setDataModelName(dataModelName);
		drm.setLastSyncTime(lastSyncTime);
		drm.setQuery(new HashMap<String, String[]>());

		al.add(drm);

		dr.setResources(al);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, dr);
	}

	void uploadExistingRequestJSON_Person() throws Exception {

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<PersonResourceElement>> dataList = new ArrayList<>();

		UploadRequestMessage<PersonResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.UPDATE);
		reqMsg.setDataModelName("person");
		reqMsg.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local1");
		reqMsg.setLastModified(100000000000000L);

		PersonResourceElement element = new PersonResourceElement("1");
		element.setName("kishigam2");
		element.setAge(333);
		element.setOrganization("AA2");

		reqMsg.setElement(element);

		UploadRequestMessage<PersonResourceElement> reqMsg2 = new UploadRequestMessage<>();

		reqMsg2.setAction(SyncAction.UPDATE);
		reqMsg2.setDataModelName("person");
		reqMsg2.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local2");
		reqMsg2.setLastModified(100000000000000L);

		PersonResourceElement element2 = new PersonResourceElement("2");
		element2.setName("kk2");
		element2.setAge(666);
		element2.setOrganization("i-system2");

		reqMsg2.setElement(element2);

		dataList.add(reqMsg);
		dataList.add(reqMsg2);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}

	void uploadExistingRequestJSON_Schedule() throws Exception {

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<ScheduleResourceElement>> dataList = new ArrayList<>();

		UploadRequestMessage<ScheduleResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.UPDATE);
		reqMsg.setDataModelName("schedule");
		reqMsg.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local1");

		ScheduleResourceElement element = new ScheduleResourceElement("1");
		List<String> userIds = new ArrayList<>();
		userIds.add("111");
		element.setUserIds(userIds);
		element.setTitle("______scd1");
		element.setCategory("______meeting");
		List<String> dates = new ArrayList<>();
		dates.add("10000000000009");
		dates.add("20000000000009");
		element.setDates(dates);
		element.setStartTime("1000000000091");
		element.setFinishTime("2000000000092");
		element.setDetail("_____meeting1");
		element.setPlace("_____Yokohama");

		reqMsg.setElement(element);

		UploadRequestMessage<ScheduleResourceElement> reqMsg2 = new UploadRequestMessage<>();

		reqMsg2.setAction(SyncAction.UPDATE);
		reqMsg2.setDataModelName("schedule");
		reqMsg2.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local2");

		ScheduleResourceElement element2 = new ScheduleResourceElement("2766622a-a532-476a-b405-57cc810a17c6");
		List<String> userIds2 = new ArrayList<>();
		userIds2.add("222");
		element2.setUserIds(userIds2);
		element2.setTitle("_____scd2");
		element2.setCategory("_____meeting2");
		List<String> dates2 = new ArrayList<>();
		dates2.add("10000000000009");
		dates2.add("20000000000009");
		element2.setDates(dates);
		element2.setStartTime("1000000000091");
		element2.setFinishTime("2000000000092");
		element2.setDetail("_____meeting2");
		element2.setPlace("_____Yokohama2");

		reqMsg2.setElement(element2);

		dataList.add(reqMsg);
		dataList.add(reqMsg2);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}

	void uploadNewRequestJSON_Person() throws Exception {

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<PersonResourceElement>> dataList = new ArrayList<>();

		UploadRequestMessage<PersonResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.CREATE);
		reqMsg.setDataModelName("person");
		reqMsg.setStorageLocalId("Local1");

		PersonResourceElement element = new PersonResourceElement("1");
		element.setName("kishigam");
		element.setAge(33);
		element.setOrganization("softsys");

		reqMsg.setElement(element);

		UploadRequestMessage<PersonResourceElement> reqMsg2 = new UploadRequestMessage<>();

		reqMsg2.setAction(SyncAction.CREATE);
		reqMsg2.setDataModelName("person");
		reqMsg2.setStorageLocalId("Local2");

		PersonResourceElement element2 = new PersonResourceElement("2");
		element2.setName("kk");
		element2.setAge(66);
		element2.setOrganization("i-system");

		reqMsg2.setElement(element2);

		dataList.add(reqMsg);
		dataList.add(reqMsg2);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}

	void uploadNewRequestJSON_Schedule() throws Exception {

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<ScheduleResourceElement>> dataList = new ArrayList<>();

		UploadRequestMessage<ScheduleResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.CREATE);
		reqMsg.setDataModelName("schedule");
		reqMsg.setStorageLocalId("Local1");

		ScheduleResourceElement element = new ScheduleResourceElement("1");
		List<String> userIds = new ArrayList<>();
		userIds.add("111");
		userIds.add("222");
		element.setUserIds(userIds);
		element.setTitle("scd1");
		element.setCategory("meeting");
		List<String> dates = new ArrayList<>();
		dates.add("1000000000000");
		dates.add("2000000000000");
		element.setDates(dates);
		element.setStartTime("1000000000001");
		element.setFinishTime("2000000000002");
		element.setDetail("meeting1");
		element.setPlace("Yokohama");

		reqMsg.setElement(element);

		UploadRequestMessage<ScheduleResourceElement> reqMsg2 = new UploadRequestMessage<>();

		reqMsg2.setAction(SyncAction.CREATE);
		reqMsg2.setDataModelName("schedule");
		reqMsg2.setStorageLocalId("Local2");

		ScheduleResourceElement element2 = new ScheduleResourceElement("2");
		List<String> userIds2 = new ArrayList<>();
		userIds2.add("111");
		userIds2.add("222");
		element2.setUserIds(userIds2);
		element2.setTitle("scd2");
		element2.setCategory("meeting2");
		List<String> dates2 = new ArrayList<>();
		dates2.add("1000000000000");
		dates2.add("2000000000000");
		element2.setDates(dates);
		element2.setStartTime("1000000000001");
		element2.setFinishTime("2000000000002");
		element2.setDetail("meeting2");
		element2.setPlace("Yokohama2");

		reqMsg2.setElement(element2);

		dataList.add(reqMsg);
		dataList.add(reqMsg2);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}

	void uploadDeleteRequestJSON_Person() throws Exception {

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<PersonResourceElement>> dataList = new ArrayList<>();

		UploadRequestMessage<PersonResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.DELETE);
		reqMsg.setDataModelName("person");
		reqMsg.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local1");
		reqMsg.setLastModified(100000000000000L);

		UploadRequestMessage<PersonResourceElement> reqMsg2 = new UploadRequestMessage<>();

		reqMsg2.setAction(SyncAction.DELETE);
		reqMsg2.setDataModelName("person");
		reqMsg2.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local2");
		reqMsg2.setLastModified(100000000000000L);

		dataList.add(reqMsg);
		dataList.add(reqMsg2);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}

	void uploadMixedRequestJSON_Person() throws Exception {

		UploadRequestMessage<PersonResourceElement> reqMsg = new UploadRequestMessage<>();

		reqMsg.setAction(SyncAction.CREATE);
		reqMsg.setDataModelName("person");
		reqMsg.setStorageLocalId("Local3");

		PersonResourceElement element = new PersonResourceElement("3");
		element.setName("no3");
		element.setAge(3);
		element.setOrganization("no3.org");

		reqMsg.setElement(element);

		UploadRequestMessage<PersonResourceElement> reqMsg2 = new UploadRequestMessage<>();
		reqMsg2.setAction(SyncAction.UPDATE);
		reqMsg2.setDataModelName("person");
		reqMsg2.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local2");
		reqMsg2.setLastModified(100000000000000L);

		PersonResourceElement element2 = new PersonResourceElement("2");
		element2.setName("no2");
		element2.setAge(2);
		element2.setOrganization("no2.org");

		reqMsg2.setElement(element2);

		UploadRequestMessage<PersonResourceElement> reqMsg3 = new UploadRequestMessage<>();
		reqMsg3.setAction(SyncAction.DELETE);
		reqMsg3.setDataModelName("person");
		reqMsg3.setSyncDataId("2ce1972a-26b3-4a2c-afa0-4c4c65ee1e43Local1");
		reqMsg3.setLastModified(100000000000000L);

		UploadRequest req = new UploadRequest();

		List<UploadRequestMessage<PersonResourceElement>> dataList = new ArrayList<>();
		dataList.add(reqMsg);
		dataList.add(reqMsg2);
		dataList.add(reqMsg3);

		req.setDataList(dataList);

		ObjectMapper om = new ObjectMapper();
		om.writeValue(System.out, req);
	}
}