package revvilo.responsiveshields.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "responsiveshields")
@Config(name = "responsiveshields", wrapperName = "ResponsiveShieldsConfig")
public class ConfigModel {
    @RangeConstraint(min = 0, max = 20)
    public int SHIELD_DELAY = 0;
    public boolean IS_ENABLED = true;


}