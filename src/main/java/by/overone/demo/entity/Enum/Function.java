package by.overone.demo.entity.Enum;

public enum Function {
    INFO_READ("info:read"), INFO_WRITE("info:write"),
    ADMIN_READ("admin:read"), ADMIN_WRITE("admin:write");


    private final String function;


    Function(String function) {
        this.function = function;
    }

    public String getFunction() {
        return this.function;
    }
}
