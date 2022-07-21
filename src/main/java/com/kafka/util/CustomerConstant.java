package com.kafka.util;

import org.springframework.stereotype.Component;

/**
 * @type CustomerConstant
 *
 * @author: Manjunatha Shivegowda
 * @version: 1.0
 * @created: Mar 11, 2019
 * @copyright CBRE 2019
 *
 *            CustomerConstant values
 */
@Component
public class CustomerConstant {

    public static final int COUNT = 1;

    public static final String ERROR_MESSAGES = "errors/errormessages";

    public static final String VALIDATION_MESSAGES = "validation/validationmessages";

    public static final String UTF = "UTF-8";

    public static final String TYPE = "article";

    public static final String FILE_NAME = "fileName";

    public static final String FILE = "file";

    public static final String VERSION_STRING = "version";

    public static final String DEFAULT_ERROR_BAD_REQUEST = "404";

    public static final String INTERNAL_SERVER_ERROR = "500";

    public static final String HEADER_KEY_AUTHORIZATION = "authorization";

    public static final String HEADER_KEY_ID_TOKEN = "x-id-token";

    public static final String HEADER_KEY_API_VERSION = "api-version";

    public static final String HEADER_KEY_PROVIDER = "x-provider";

    public static final String HEADER_KEY_API_VERSION_VALUE = "1.0";

    public static final String HEADER_KEY_AUTHORIZATION_VALUE = "";

    public static final String HEADER_KEY_ID_TOKEN_VALUE = "";

    public static final String NULL_VALUE = null;

    public static final String CONST_LOGO_URL = "logoUrl";

    public static final String SPACE_TYPE_CUSTOMER = "Customer";

    public static final String SPACE_TYPE_TENANT = "Tenant";

    public static final String SPACE_QUERY_PARAM_KEY = "types";

    public static final String EMPTY = "";

    public static final String ADMIN = "Admin";

    public static final String SUPER_ADMIN = "SuperAdmin";

    public static final String QUOTES = "\"";

    public static final char FORWARD_SLASH = '/';

    public static final String MSDT_AUTHORIZATION_HEADER_VALUE_PREFIX = "Bearer ";

    public static final String MSDT_AUTHORIZATION_HEADER_KEY = "Authorization";

    public static final String ACCESS_TOKEN_TOKENIZER = "\\.";

    public static final String USER_PRINCIPAL_NAME_KEY = "upn";

    public static final String FAMILY_NAME_KEY = "family_name";

    public static final String GIVEN_NAME_KEY = "given_name";

    public static final String UNIQUE_NAME_KEY = "unique_name";

    public static final String CUSTOMERCONFIGURATIONCOLLECTION = "CustomerConfiguration";

    public static final String USER_EMAIL = "email";

    public static final String ACTIVE = "active";

    public static final String PRIVILEGE_ENDPOINT = "/roleprivilege";

    public static final String TOKEN_ISSUER_KEY = "iss";

    public static final String GOOGLE_ISSUER_IDTOKEN_HTTP = "https://accounts.google.com";

    public static final String GOOGLE_ISSUER_IDTOKEN_WITHOUT_SCHEME = "accounts.google.com";

    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";

    public static final String TWO_HYPHENS = "--";

    public static final String DOMAIN_VS_CUSTOMERID = "%s:domainName:customerId";

    public static final String USER_ROLE_CONFIG_NAME = ":userId:roleName";

    public static final String BOOKINGS_SECRET = "booking-secret";

    public static final String BOOKINGS_PASSWORD = "booking-password";

    public static final String AVAILABILITY_SECRET = "availability-secret";

    public static final String AVAILABILITY_PASSWORD = "availability-password";

    public static final String ROOM_RELEASE_SECRET = "roomrelease-secret";

    public static final String ROOM_RELEASE_PASSWORD = "roomrelease-password";

    public static final String USER_ROLE_FETCH_ERROR =
            "Error occurred while fetching User details from Host User Service";

    public static final String CACHE_CUSTOMER_CONFIG_PREFIX = "cache.customerConfig.name";

    public static final String CACHE_CUSTOMER_ID_PREFIX = "cache.root.customer";

    public static final String DOMAIN_CUSTOMERID = "domainName:customerId";

    public static final String HEADER_KEY_LOGIN_MODE = "x-login-mode";

    public static final String DOMAIN_LOGINMODE_DELIMITTER = "::";

    public static final String DATE_TIME_FORMATTER_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

  public static final String PURGE_ANONYMIZE_AUTH_ERROR_MESSAGE = "AppId and ApiKey not authorized.";

    public static final String PURGE_ANONYMIZE_STATUS_NO_RECORDS_FOUND = "No records found for this user.";

    public static final String PURGE_ANONYMIZE_STATUS_SUCCESS = "Success";

    public static final String PURGE_ANONYMIZE_STATUS_ERROR = "Error";

    public static final String COLLECTION_ALIAS = "customer";
    
    public static final String ANNONYMIZE_AUDITINFO_CREATEDBY = "auditInfo.createdBy";

    public static final String ANNONYMIZE_AUDITINFO_MODIFIEDBY = "auditInfo.lastModifiedBy";

    private CustomerConstant() {}

}
