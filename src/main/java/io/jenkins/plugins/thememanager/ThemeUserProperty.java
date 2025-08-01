package io.jenkins.plugins.thememanager;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import hudson.model.userproperty.UserPropertyCategory;
import io.jenkins.plugins.thememanager.none.NoOpThemeManagerFactory;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

@Restricted(NoExternalUse.class)
public class ThemeUserProperty extends UserProperty {

    private ThemeManagerFactory theme;

    @DataBoundConstructor
    public ThemeUserProperty() {}

    public ThemeManagerFactory getTheme() {
        if (theme == null) {
            return new NoOpThemeManagerFactory();
        }

        return theme;
    }

    @DataBoundSetter
    public void setTheme(ThemeManagerFactory theme) {
        this.theme = theme;
    }

    @CheckForNull
    public static Theme forCurrentUser() {
        ThemeManagerFactory factory = forCurrentUserFactory();
        if (factory == null) {
            return null;
        }
        return factory.getTheme();
    }

    @CheckForNull
    public static ThemeManagerFactory forCurrentUserFactory() {
        final User current = User.current();
        if (current == null) {
            return null;
        }

        ThemeUserProperty property = current.getProperty(ThemeUserProperty.class);
        if (property == null || property.theme == null) {
            return null;
        }

        return property.getTheme();
    }

    @Extension(ordinal = Integer.MAX_VALUE)
    public static class ThemeUserPropertyDescriptor extends UserPropertyDescriptor {

        @Override
        public boolean isEnabled() {
            return !ThemeManagerPageDecorator.get().isDisableUserThemes();
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Theme";
        }

        @Override
        public UserProperty newInstance(User user) {
            return new ThemeUserProperty();
        }

        @Override
        public @NonNull UserPropertyCategory getUserPropertyCategory() {
            return UserPropertyCategory.get(UserPropertyCategory.Appearance.class);
        }
    }
}
