package am.chronograph.service.group;

import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.web.bean.group.GroupBean;

/**
 * Provides services for getting, managing Groups.
 * 
 * @author davit
 *
 */
public interface GroupService {

	/**
	 * Creates given group...
	 * 
	 * @param groupBean
	 */
	void create(GroupBean groupBean);

	/**
	 * Updates group by given one...
	 * 
	 * @param groupBean
	 */
	void update(GroupBean groupBean);

	/**
	 * Delets group by given id...
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * Get all groups...
	 * 
	 * @return
	 */
	List<GroupBean> getAll();
	
	/**
	 * Get the select items list of all groups... 
	 * 
	 * @return
	 */
	List<SelectItem> getAllItems();
}
