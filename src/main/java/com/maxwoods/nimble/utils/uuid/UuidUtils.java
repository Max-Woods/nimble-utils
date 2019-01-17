package com.maxwoods.nimble.utils.uuid;

import java.util.UUID;

public class UuidUtils {

	public static String randomUUIDString() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
