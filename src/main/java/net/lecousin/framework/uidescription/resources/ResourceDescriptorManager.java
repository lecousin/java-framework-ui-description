package net.lecousin.framework.uidescription.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class ResourceDescriptorManager {

	Map<Object,Object> map = new HashMap<>();
	int size = 0;
	
	@SuppressWarnings("unchecked")
	ResourceDescriptor get(Object... data) {
		Map<Object,Object> m = map;
		for (int i = 0; i < data.length - 1; ++i) {
			m = (Map<Object,Object>)m.get(data[i]);
			if (m == null) return null;
		}
		return (ResourceDescriptor)m.get(data[data.length - 1]);
	}
	
	@SuppressWarnings("unchecked")
	void put(ResourceDescriptor resource, Object... data) {
		Map<Object,Object> m = map;
		for (int i = 0; i < data.length - 1; ++i) {
			Object o = m.get(data[i]);
			if (o == null) {
				o = new HashMap<Object,Object>();
				m.put(data[i], o);
			}
			m = (Map<Object,Object>)o;
		}
		if (m.put(data[data.length - 1], resource) != null)
			size++;
	}
	
	void getResources(Collection<ResourceDescriptor> list) {
		getResources(list, map);
	}
	
	@SuppressWarnings("unchecked")
	private static void getResources(Collection<ResourceDescriptor> list, Map<Object,Object> map) {
		for (Object o : map.values())
			if (o instanceof Map)
				getResources(list, (Map<Object,Object>)o);
			else
				list.add((ResourceDescriptor)o);
	}
	
}
