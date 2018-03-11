package net.lecousin.framework.uidescription.annotations;

import java.util.ArrayList;
import java.util.List;

import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.locale.LocalizableString;

public class UIAttributeCategory {

	public UIAttributeCategory(ILocalizableString name) {
		this.name = name;
	}
	
	public UIAttributeCategory(Category cat) {
		if (cat.fixedName().length() > 0)
			this.name = new FixedLocalizedString(cat.fixedName());
		else
			this.name = new LocalizableString(cat.localeNamespace(), cat.localeKey());
	}
	
	private ILocalizableString name;
	private List<UIAttribute> attributes = new ArrayList<>();
	
	public boolean hasName() {
		return name != null;
	}
	
	public boolean isSame(Category cat) {
		if (cat.fixedName().length() > 0)
			return (name instanceof FixedLocalizedString) && ((FixedLocalizedString)name).equals(new FixedLocalizedString(cat.fixedName()));
		return ((LocalizableString)name).equals(new LocalizableString(cat.localeNamespace(), cat.localeKey()));
	}
	
	public void addAttribute(UIAttribute attr) {
		attributes.add(attr);
	}
	
	public List<UIAttribute> getAttributes() {
		return attributes;
	}
	
}
