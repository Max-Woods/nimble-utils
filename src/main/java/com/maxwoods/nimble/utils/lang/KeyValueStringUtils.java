package com.maxwoods.nimble.utils.lang;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Max Woods
 */
public class KeyValueStringUtils {

	public static Map<String, String> toMap(String keyValueString) {
		TreeMap<String, String> result = new TreeMap<>();
		String[] keyValuePairs = keyValueString.split("&");
		for (String keyValuePair : keyValuePairs) {
			String[] keyValue = keyValuePair.split("=");
			String key = keyValue[0];
			String value = keyValue.length > 1 ? keyValue[1] : null;
			result.put(key, value);
		}
		return result;
	}

	public static String toKeyValueString(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		TreeMap<String, String> treeMap = new TreeMap<>(map);
		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return sb.toString();
	}

	public static String toSortedKeyValueString(String keyValueString) {
		return KeyValueStringUtils.toKeyValueString(KeyValueStringUtils.toMap(keyValueString));
	}
}
