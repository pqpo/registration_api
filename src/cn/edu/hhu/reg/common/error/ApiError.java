package cn.edu.hhu.reg.common.error;

public enum ApiError {
    SERVICE_NOT_FOUND               (  404, "Api not found."),
    SERVICE_METHOD_NOT_SUPPORTED    (  405, "Request method is not supported."),
    SERVICE_INTERNAL                (  500, "Service internal error."),

    SYSTEM_UNKNOWN                  (10099, "System unknown error."),

    PARAMETER_MISSING               (10601, "Missing required parameter."),
    PARAMETER_INVALID               (10602, "Parameter's value invalid."),

    NICKNAME_TOO_SHORT              (20201, "Nickname is too short."),
    NICKNAME_TOO_LONG               (20202, "Nickname is too long."),
    NICKNAME_ILLEGAL                (20203, "Nickname is illegal."),

    PASSWORD_TOO_SHORT              (20301, "Password is too long."),
    PASSWORD_TOO_LONG               (20302, "Password is too short."),
    PASSWORD_ILLEGAL                (20303, "Password is illegal."),
    PASSWORD_NOT_MATCH              (20304, "密码错误！"),

    TOKEN_INVALID                   (20401, "Token is invalid."),
    TOKEN_DISCARD                   (20402, "Token has been discard."),
    TOKEN_EXPIRED                   (20403, "Token has been expired."),

    USER_NOT_REGISTER             (20501, "用户未注册！"),
    USER_ALREADY_REGISTERED       (20502, "用户已注册！"),

    REGISTRATION_DATE_INVALID     (20601,"预订日期无效（该天预订人数已满）！"),
    REGISTRATION_DOCTOR_INVALID     (20601,"该医生不可预订（预订状态：不可预订）！"),
    REGISTRATION_CANNOT_CANCEL     (20601,"无法取消（无效预约）！"),

    SERVICE_ERROR_TYPE              (21001, "Service's type is invalid."),
    ;
    public final int code;
    public final String message;

    private ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiError getError(int code) {
        for(ApiError error : values()) {
            if(error.code == code) return error;
        }
        return null;
    }
}
