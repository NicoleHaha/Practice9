package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {
        if (IsParameterValid(user, permission, permissions)) return false;
        if (securityChecker.isAdmin()) return true;
        if (IsPermissionValid(user, permission, permissions)) return true;
        return false;
    }

    public boolean IsPermissionValid(User user, Permission permission, ImmutableList<Permission> permissions) {
        return this.securityChecker.checkPermission(user, permission) || permissions.contains(permission);
    }

    public boolean IsParameterValid(User user, Permission permission, ImmutableList<Permission> permissions) {
        if (user == null) {
            return true;
        }
        if (permission == null) {
            return true;
        }
        if (permissions.size() == 0) {
            return true;
        }
        return false;
    }
}
