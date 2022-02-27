package by.overone.demo.entity.Enum;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static by.overone.demo.entity.Enum.Function.*;

public enum Role {
    USER (Sets.newHashSet(INFO_READ)),
    ADMIN (Sets.newHashSet(INFO_READ, INFO_WRITE, ADMIN_READ, ADMIN_WRITE));

    private final Set<Function> function;

    Role(Set<Function> permissions) {
        this.function = permissions;
    }

    public Set<Function> getFunction() {
        return function;
    }

    public Set<GrantedAuthority> getGrantedAuthority() {
        Set<GrantedAuthority> function = this
                .getFunction()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getFunction()))
                .collect(Collectors.toSet());
        function.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return function;
    }
}
