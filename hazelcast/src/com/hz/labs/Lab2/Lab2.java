package com.hz.labs.Lab2;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.Map;

public class Lab2 {

	public static void main(String[] args) {

		ClientConfig clientConfig = new ClientConfig();

		clientConfig.setClusterName("dev");

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		IMap<String, String> map = client.getMap("my-distributed-map");

		map.put("4", "Marvin");
		
		//Map.Entry<String, String> entries :map.entrySet();

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		};
	}
}