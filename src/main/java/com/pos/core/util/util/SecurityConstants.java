package com.pos.core.util.util;

/**
 * Created by admin on 4/13/2018.
 */
public class SecurityConstants {

    public static final String SECRET = "PosCheckInSecretKeyToGenJWTs";

    public static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static final long RECOVERY_TIME = 86_400_000; // 1 day

    public static final String TOKEN_PREFIX = "Bearer ";

}
