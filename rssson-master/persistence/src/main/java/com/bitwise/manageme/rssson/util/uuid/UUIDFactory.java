package com.bitwise.manageme.rssson.util.uuid;

import java.util.UUID;
import java.util.regex.Pattern;

import com.bitwise.manageme.rssson.domain.users.User;

public class UUIDFactory {
	
	private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public boolean hasMatchingUUID(User account, String oneTimeToken) {
        boolean userTokenValid = account != null && account.getOneTimeToken() != null && UUID_PATTERN.matcher(account.getOneTimeToken()).matches();
        boolean matchingTokenValid = oneTimeToken != null && UUID_PATTERN.matcher(oneTimeToken).matches();
        return userTokenValid && matchingTokenValid && account.getOneTimeToken().equals(oneTimeToken);
    }

}
